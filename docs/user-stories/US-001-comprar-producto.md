# US-001 - Comprar producto

## Historia

Como cliente,
quiero comprar productos desde la tienda,
para completar mi compra online de forma segura y recibir confirmacion del pedido.

## Valor de negocio

Habilita el flujo principal de ventas del MVP.

## Criterios de aceptacion

- El cliente puede agregar productos al carrito.
- El cliente puede modificar cantidad y quitar productos del carrito antes del checkout.
- El sistema valida stock en carrito y bloquea avanzar al checkout si la cantidad supera el stock.
- Si el cliente no esta autenticado al iniciar checkout, debe registrarse o iniciar sesion para continuar.
- En checkout, el cliente puede elegir modalidad de entrega: retiro en sucursal, envio a domicilio o retiro en correo.
- Si elige envio a domicilio o retiro en correo, el sistema cotiza costo de envio con Correo Argentino antes del pago.
- Si elige retiro en sucursal, el costo de envio es cero.
- El sistema muestra total final (productos + envio) antes de pagar.
- El cliente puede pagar con Mercado Pago.
- El sistema revalida stock antes de confirmar la orden.
- Si el pago es aprobado y hay stock, el sistema crea el pedido.
- Si el pago es rechazado, el pedido no se crea.
- Si el stock cambia durante checkout, el sistema no crea pedido y solicita ajustar carrito.
- Si la compra es exitosa, se envia correo de confirmacion al cliente.
- Si la compra es exitosa, se envia correo de aviso al propietario/admin.

## Reglas de negocio

- No permitir cantidades menores a 1 ni mayores al stock disponible.
- El pedido solo se confirma con pago aprobado.
- El costo de envio debe quedar registrado en el pedido.
- La modalidad de entrega debe quedar registrada en el pedido.

## Dependencias

- Integracion con Mercado Pago.
- Integracion con Correo Argentino (cotizacion).
- Servicio de envio de correos.

## Fuera de alcance de esta historia

- Cupones o promociones avanzadas.
- Multiples pasarelas de pago.
- Notificaciones por WhatsApp/SMS.

## Referencia

- `docs/product/core-business-flow-003-purchase.md`

