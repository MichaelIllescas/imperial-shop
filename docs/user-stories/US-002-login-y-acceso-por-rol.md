# US-002 - Registro, login y acceso por rol

## Historia

Como cliente no registrado o usuario existente (cliente/admin),
quiero registrarme o iniciar sesion en la plataforma,
para acceder a las funcionalidades que corresponden a mi perfil y poder comprar.

## Valor de negocio

Asegura acceso controlado y habilita el resto de funcionalidades del sistema.

## Criterios de aceptacion

- El cliente puede iniciar sesion y acceder a la tienda.
- El cliente no registrado puede crear su cuenta con datos obligatorios.
- El admin puede iniciar sesion y acceder al panel de administracion.
- Si las credenciales son invalidas, el sistema no permite acceso.
- Si el email ya existe, el sistema no permite registro duplicado.
- El sistema aplica permisos por rol sobre las rutas protegidas.
- El usuario puede cerrar sesion y el token/sesion queda invalidado.

## Reglas de negocio

- Email y password son obligatorios.
- El registro de cliente requiere email unico.
- Usuarios inactivos o bloqueados no pueden iniciar sesion.
- Rutas de administracion solo disponibles para rol admin.

## Dependencias

- Modulo de autenticacion/autorizacion.

## Referencia

- `docs/product/core-business-flow-001-auth-access.md`

