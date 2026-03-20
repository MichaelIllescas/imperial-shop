# Core Business Flow 003 - Purchase

## 1. Nombre del flujo

`Compra simple de producto`

## 2. Objetivo

Permitir que un cliente compre un producto y que el sistema registre el pedido correctamente.

## 3. Actor principal

`Cliente`

## 4. Actores secundarios (opcional)

`Mercado Pago, Correo Argentino`

## 5. Precondiciones

- El producto existe y tiene stock.
- El cliente puede acceder al checkout.
- El cliente esta autenticado para confirmar la compra.
- Correo Argentino disponible para cotizar envios.

## 6. Disparador

El cliente presiona el botón "Finalizar compra".

## 7. Pasos principales (happy path)

1. El cliente agrega un producto al carrito.
2. El cliente puede modificar cantidad o quitar productos del carrito.
3. El sistema recalcula subtotal y valida stock disponible para la cantidad solicitada.
4. El cliente inicia checkout.
5. Si el cliente no tiene sesion, el sistema solicita registro/login y luego permite continuar.
6. El sistema solicita tipo de entrega: retiro en sucursal, envio a domicilio o retiro en correo.
7. El cliente selecciona tipo de entrega y completa datos necesarios.
8. El sistema cotiza costo de envio con Correo Argentino cuando aplique.
9. El sistema muestra costo final (productos + envio).
10. El cliente confirma y paga con Mercado Pago.
11. El sistema valida el pago aprobado.
12. El sistema revalida stock antes de confirmar la orden.
13. El sistema crea el pedido con modalidad de entrega seleccionada.
14. El sistema envia correo de confirmacion al cliente.
15. El sistema envia correo de aviso de nueva compra al propietario/admin.
16. El sistema muestra confirmacion al cliente.

## 8. Reglas de negocio

- No permitir compra si no hay stock disponible.
- No permitir cantidades menores a 1 ni mayores al stock disponible.
- Para confirmar compra el cliente debe estar autenticado.
- Validar stock en carrito y revalidar stock antes de confirmar la orden para evitar inconsistencias por concurrencia.
- El pedido se crea solo si el pago esta aprobado.
- Si la modalidad es envio a domicilio o retiro en correo, el costo de envio debe cotizarse con Correo Argentino antes del pago.
- Si la modalidad es retiro en sucursal, el costo de envio es cero.

## 9. Excepciones / errores esperados

- **Pago rechazado**: se informa el error y no se crea pedido.
- **Cliente no autenticado**: redirigir a registro/login y conservar carrito para continuar checkout.
- **Stock insuficiente**: se detecta en carrito y se bloquea avanzar al checkout. Si el stock cambia durante checkout, se revalida antes de confirmar la orden y se informa ajuste de stock sin crear pedido.
- **Error de cotizacion de envio**: se informa fallo temporal y se permite reintentar.
- **Error de integración de pago**: se informa fallo temporal y se permite reintentar.

## 10. Resultado esperado

Pedido creado con estado inicial, modalidad de entrega y costo de envio registrados, y confirmacion visible para el cliente.
Ademas, se envia notificacion por correo al cliente y al propietario/admin.

## 11. Datos que crea o actualiza

- Pedido (`Order`)
- Detalle del pedido (`OrderItem`)
- Stock del producto
- Tipo de entrega seleccionado
- Costo de envio cotizado
- Registro de notificaciones/correos enviados (si aplica)

## 12. Historias relacionadas

- `US-001`

## 13. Criterios de aceptación del flujo

- [ ] Si hay stock y pago aprobado, se crea el pedido.
- [ ] El cliente puede modificar la cantidad en carrito antes del checkout y el sistema recalcula los totales.
- [ ] Si el cliente no esta autenticado al iniciar checkout, debe registrarse o iniciar sesion para continuar.
- [ ] Si el cliente elige envio a domicilio o retiro en correo, se cotiza envio con Correo Argentino antes de pagar.
- [ ] Si el cliente elige retiro en sucursal, el envio no suma costo.
- [ ] Si el pago es rechazado, no se crea el pedido.
- [ ] Si no hay stock, el sistema impide avanzar al checkout desde carrito.
- [ ] Si el stock cambia durante checkout, el sistema revalida antes de confirmar y no crea pedido hasta ajustar carrito.
- [ ] Si la compra es exitosa, se envia correo de confirmacion al cliente.
- [ ] Si la compra es exitosa, se envia correo de aviso al propietario/admin.

---

## Diagrama rápido (opcional)

`Cliente -> Carrito -> Checkout -> Correo Argentino (cotizacion) -> Mercado Pago -> Pedido confirmado -> Emails enviados`
