# Core Business Flow 005 - Public Storefront Navigation

## 1. Nombre del flujo

`Navegacion publica de tienda`

## 2. Objetivo

Permitir que visitantes no autenticados descubran productos, exploren catalogo y avancen a compra.

## 3. Actor principal

`Visitante`

## 4. Actores secundarios (opcional)

`Sistema`

## 5. Precondiciones

- Existen categorias activas y productos publicados.
- La tienda publica esta disponible.

## 6. Disparador

El visitante ingresa al sitio publico de la tienda.

## 7. Pasos principales (happy path)

1. El visitante accede a home publica.
2. El visitante navega por categorias.
3. El visitante usa busqueda o filtros.
4. El sistema muestra resultados de productos publicados.
5. El visitante entra al detalle de un producto.
6. El sistema muestra informacion de producto (precio, stock, descripcion, imagenes).
7. El visitante agrega producto al carrito.
8. El visitante inicia checkout.
9. Si no esta autenticado, el sistema solicita registro/login para continuar compra.

## 8. Reglas de negocio

- Solo productos publicados deben aparecer en storefront publico.
- Productos sin stock pueden mostrarse, pero con estado "sin stock".
- Filtros y busqueda deben operar solo sobre catalogo publicado.

## 9. Excepciones / errores esperados

- **Sin resultados**: mostrar estado vacio y sugerencias de busqueda.
- **Producto no publicado/inactivo**: no permitir acceso al detalle.
- **Error de carga de catalogo**: mostrar mensaje y permitir reintento.

## 10. Resultado esperado

Visitante navega la tienda publica, encuentra productos relevantes y puede iniciar proceso de compra.

## 11. Datos que crea o actualiza

- Carrito temporal (si aplica para visitante no autenticado).
- Preferencias de navegacion/filtros (si aplica).

## 12. Historias relacionadas

- `US-008`
- `US-009`
- `US-010`

## 13. Criterios de aceptacion del flujo

- Visitante puede navegar categorias activas.
- Visitante puede buscar y filtrar productos publicados.
- Visitante puede ver detalle de producto publicado.
- Visitante puede agregar productos al carrito.
- Checkout exige registro/login si no hay sesion activa.

