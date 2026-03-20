# US-009 - Detalle publico de producto

## Historia

Como visitante,
quiero ver el detalle de un producto,
para evaluar si me conviene comprarlo.

## Valor de negocio

Mejora la decision de compra mostrando informacion completa y confiable.

## Criterios de aceptacion

- [ ] El visitante puede abrir el detalle de un producto publicado.
- [ ] Se muestra nombre, precio, descripcion, imagenes y estado de stock.
- [ ] Si el producto no tiene stock, se informa visualmente.
- [ ] Desde el detalle, el visitante puede agregar al carrito si hay stock.
- [ ] Producto no publicado/inactivo no es accesible desde URL publica.

## Reglas de negocio

- El precio mostrado debe ser el vigente del producto.
- Solo productos publicados pueden tener detalle publico.

## Dependencias

- Catalogo publicado.
- Carrito habilitado.

## Referencia

- `docs/product/core-business-flow-005-public-storefront-navigation.md`
