# US-004 - Gestion de productos y stock

## Historia

Como administrador de tienda,
quiero crear y administrar productos con precio y stock,
para mantener el catalogo actualizado y disponible para venta.

## Valor de negocio

Habilita la oferta comercial base para que existan productos comprables.

## Criterios de aceptacion

- [ ] El admin puede crear productos con datos obligatorios.
- [ ] El admin puede indicar URL de imagen principal del producto (o subir y persistir URL publica segun implementacion).
- [ ] El admin puede editar precio, stock, categoria, imagen principal y estado de publicacion.
- [ ] El sistema valida que precio y stock no sean negativos.
- [ ] Solo productos publicados se muestran en la tienda.

## Reglas de negocio

- Todo producto debe pertenecer al menos a una categoria.
- Un producto sin stock puede permanecer visible pero no debe poder comprarse.

## Dependencias

- Gestion de categorias activa.
- Login admin y permisos de catalogo.

## Referencia

- `docs/product/core-business-flow-002-catalog-setup.md`
