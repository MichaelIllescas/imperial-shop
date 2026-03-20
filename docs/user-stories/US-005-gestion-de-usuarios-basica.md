# US-005 - Gestion de usuarios basica

## Historia

Como administrador de tienda,
quiero gestionar usuarios (clientes y admins),
para controlar accesos y estados de cuenta en la plataforma.

## Valor de negocio

Permite administrar seguridad y operacion de usuarios desde el panel.

## Criterios de aceptacion

- [ ] El admin puede ver listado de usuarios.
- [ ] El admin puede activar o desactivar usuarios.
- [ ] El admin puede asignar o actualizar rol segun permisos.
- [ ] El sistema impide acciones de admin a usuarios sin rol admin.

## Reglas de negocio

- Solo admin con permisos puede gestionar usuarios.
- Usuarios desactivados no pueden iniciar sesion.

## Dependencias

- Modulo de autenticacion y roles.

## Referencia

- `docs/product/core-business-flow-001-auth-access.md`
