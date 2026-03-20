# US-006 - Gestion de perfil y direcciones de cliente

## Historia

Como cliente,
quiero administrar mis datos personales y direcciones,
para comprar mas rapido y con informacion correcta de envio/facturacion.

## Valor de negocio

Mejora conversion en checkout y reduce errores operativos de entrega.

## Criterios de aceptacion

- [ ] El cliente autenticado puede ver y editar su perfil.
- [ ] El cliente puede agregar, editar y eliminar direcciones.
- [ ] El sistema valida campos obligatorios de direccion.
- [ ] El cliente puede definir una direccion principal de envio.
- [ ] Los datos actualizados se usan en checkout.

## Reglas de negocio

- Solo el cliente propietario puede editar su perfil/direcciones.
- Debe existir al menos una direccion valida para envios a domicilio o retiro en correo.

## Dependencias

- Registro/login de cliente.
- Modulo de perfil de cliente.

## Referencia

- `docs/product/core-business-flow-004-customer-management.md`
