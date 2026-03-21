# Almacenamiento y servicio de imagenes de producto

Documento autocontenido: flujo de carga desde el panel admin, persistencia en servidor (Spring) y URL devuelta al cliente / guardada en producto.

## Objetivo

- El administrador sube una imagen de producto.
- El backend valida, guarda el archivo y expone una **URL publica** accesible por el navegador.
- Esa URL se persiste en el producto (campo equivalente a `primary_image_url` en el modelo de datos) y el storefront la usa en listados y detalle.

## Alcance (MVP)

- Solo **imagen principal** por producto (una por carga; reemplazo si ya existia).
- Formatos tipicos: `image/jpeg`, `image/png`, `image/webp`.
- Tamano maximo configurable (ej. 2–5 MB); rechazar con error claro.

## Flujo resumido

1. Cliente admin envia `multipart/form-data` con el archivo (y opcionalmente `productId` si el producto ya existe).
2. Spring valida tipo MIME, tamano y permisos (**solo rol admin**).
3. Se genera un **nombre unico** (UUID + extension) para evitar colisiones y path traversal.
4. El archivo se guarda bajo un directorio dedicado fuera del classpath o bajo `uploads/` configurado por propiedad (ej. `app.media.upload-dir`).
5. La aplicacion **sirve** esos archivos bajo una ruta HTTP estable, por ejemplo:
   - `GET /api/media/products/{filename}` o
   - `GET /media/products/{filename}`
6. La respuesta del upload devuelve la **URL absoluta o relativa** que el front debe guardar en el producto:
   - Ejemplo JSON: `{ "url": "https://api.dominio.com/api/media/products/uuid.jpg" }`
7. El endpoint de creacion/edicion de producto recibe `primaryImageUrl` ya establecida, o el front llama primero a upload y luego PATCH del producto con esa URL.

## Seguridad

- Upload: autenticacion JWT + rol **ADMIN** obligatorio.
- Servicio estatico de archivos:
  - solo servir desde el directorio controlado (sin `..` ni paths arbitrarios);
  - contenido **solo lectura** para GET publico si las imagenes son publicas del catalogo;
  - opcional: en MVP las URLs de media pueden ser publicas; si en el futuro hay datos sensibles, separar bucket privado.
- No loguear contenido binario ni rutas internas completas en produccion si exponen estructura del servidor.

## Configuracion sugerida (conceptual)

- `app.media.upload-dir`: ruta absoluta donde se escriben archivos.
- `app.media.public-base-url`: base para construir URL absoluta en la respuesta (util en detras de reverse proxy o CDN).
- `app.media.max-file-size-bytes`: limite de tamano.

## Contrato API (referencia)

**Subir imagen (admin)**

- `POST /api/admin/products/images` (o `POST /api/admin/products/{id}/image`)
- `Content-Type: multipart/form-data`
- Campo archivo: `file`
- **201/200** cuerpo: `{ "url": "<string>" }`

**Servir imagen (publico para catalogo)**

- `GET /api/media/products/{safeFileName}`  
  - `safeFileName` = nombre generado por el servidor (UUID.ext), no aceptar paths arbitrarios del cliente.

## Frontend

- Formulario admin: `input type="file"` + preview opcional.
- Tras upload exitoso, asignar `url` al modelo del producto antes de guardar o llamar al PATCH de producto con `primaryImageUrl`.

## Evolucion futura (fuera de MVP)

- Multiples imagenes por producto (galeria + tabla `product_image`).
- Object storage (S3, R2, etc.) + CDN; el contrato sigue siendo “backend devuelve URL publica”.
- Procesamiento: resize, thumbnails, formato WebP unificado.

## Notas operativas

- En **dev/prod**: el directorio `upload-dir` debe existir o crearse al arranque; documentar backup si las imagenes viven solo en disco del servidor.
- Detras de **reverse proxy**: ajustar `public-base-url` o headers `X-Forwarded-*` para URLs correctas en la respuesta JSON.
