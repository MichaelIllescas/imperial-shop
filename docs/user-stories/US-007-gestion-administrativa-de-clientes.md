# US-007 - Gestion administrativa de clientes

## Historia

Como administrador de tienda,
quiero visualizar y gestionar clientes,
para controlar acceso, estado y calidad de datos de la base de clientes.

## Valor de negocio

Permite operacion segura y ordenada del canal de ventas.

## Criterios de aceptacion

- [ ] El admin puede listar clientes con datos basicos.
- [ ] El admin puede ver detalle del cliente (perfil y estado).
- [ ] El admin puede activar/desactivar clientes.
- [ ] Cliente desactivado no puede iniciar sesion ni comprar.
- [ ] El sistema registra cambios de estado realizados por admin.

## Reglas de negocio

- Solo admin puede cambiar el estado de un cliente.
- No debe existir cliente sin `User` asociado.

## Dependencias

- Modulo de autenticacion/roles.
- Entidades `User` y `Customer`.

## Referencia

- `docs/product/core-business-flow-004-customer-management.md`
