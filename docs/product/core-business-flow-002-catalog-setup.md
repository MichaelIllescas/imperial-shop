# Core Business Flow 002 - Catalog Setup (Admin)

## 1. Nombre del flujo

`Configuracion de catalogo inicial`

## 2. Objetivo

Permitir que el administrador cree categorias y productos para dejar la tienda lista para vender.

## 3. Actor principal

`Admin`

## 4. Actores secundarios (opcional)

`Sistema`

## 5. Precondiciones

- Admin autenticado.
- Admin con permisos de gestion de catalogo.

## 6. Disparador

El admin inicia configuracion del catalogo desde el panel.

## 7. Pasos principales (happy path)

1. El admin crea una categoria.
2. El admin crea un producto y lo asigna a una categoria.
3. El admin define precio, stock, imagen principal (URL o carga que genere URL publica) y estado (publicado/no publicado).
4. El sistema valida datos obligatorios.
5. El sistema guarda cambios y deja producto disponible en tienda si esta publicado.

## 8. Reglas de negocio

- Un producto debe pertenecer al menos a una categoria.
- Precio y stock no pueden ser negativos.
- Solo productos publicados se muestran en tienda.
- La imagen principal del producto debe ser una URL accesible publicamente (o ruta servida por la app) para mostrarla en el catalogo.

## 9. Excepciones / errores esperados

- **Datos invalidos**: mostrar errores de validacion y no guardar.
- **Categoria inexistente**: impedir asociacion de producto.
- **Usuario sin permisos**: bloquear accion.

## 10. Resultado esperado

Catalogo base configurado, con categorias y productos listos para compra.

## 11. Datos que crea o actualiza

- Categoria (`Category`)
- Producto (`Product`)
- Stock y precio de producto
- Estado de publicacion

## 12. Historias relacionadas

- `US-003`
- `US-004`

## 13. Criterios de aceptacion del flujo

- Admin puede crear/editar categorias.
- Admin puede crear/editar productos.
- El sistema valida campos obligatorios de categoria y producto.
- Productos no publicados no aparecen en tienda.
- Cambios de stock se reflejan en el catalogo.

