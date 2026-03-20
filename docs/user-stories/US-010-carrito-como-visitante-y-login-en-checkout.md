# US-010 - Carrito como visitante y login en checkout

## Historia

Como visitante,
quiero agregar productos al carrito sin iniciar sesion,
para decidir mi compra y autenticarme solo al momento de pagar.

## Valor de negocio

Reduce friccion inicial y mejora conversion al permitir exploracion libre antes del login.

## Criterios de aceptacion

- [ ] Visitante no autenticado puede agregar/quitar productos del carrito.
- [ ] El carrito mantiene cantidades y totales durante la sesion.
- [ ] Al iniciar checkout sin sesion, el sistema redirige a registro/login.
- [ ] Luego de autenticarse, el visitante puede continuar con el mismo carrito.
- [ ] Si la autenticacion falla, no se pierde el carrito.

## Reglas de negocio

- El checkout requiere usuario autenticado.
- El carrito de visitante se asocia a la sesion temporal hasta login/registro.

## Dependencias

- Flujo de registro/login.
- Flujo de compra.

## Referencia

- `docs/product/core-business-flow-005-public-storefront-navigation.md`
- `docs/product/core-business-flow-003-purchase.md`
