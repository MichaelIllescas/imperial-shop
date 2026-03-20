# Core Business Flow 004 - Customer Management

## 1. Nombre del flujo

`Gestion de clientes`

## 2. Objetivo

Administrar el ciclo de vida del cliente separando identidad de acceso (`User`) y perfil comercial (`Customer`).

## 3. Actor principal

`Cliente o Admin`

## 4. Actores secundarios (opcional)

`Sistema`

## 5. Precondiciones

- Existe un usuario autenticado con rol cliente o admin.
- Para gestion administrativa, el usuario tiene permisos de admin.

## 6. Disparador

Registro de cliente, actualizacion de perfil o accion administrativa sobre un cliente.

## 7. Pasos principales (happy path)

1. Cliente se registra en la plataforma.
2. El sistema crea `User` con rol cliente.
3. El sistema crea perfil `Customer` asociado al `User` (1:1).
4. Cliente completa o actualiza datos de perfil (nombre, telefono, documento).
5. Cliente agrega o edita direcciones de envio/facturacion.
6. Admin visualiza listado de clientes y detalle de perfil.
7. Admin activa/desactiva cliente segun necesidad operativa.

## 8. Reglas de negocio

- Todo cliente debe tener un `User` y un `Customer` asociado.
- Un `Customer` pertenece a un unico `User`.
- Cliente desactivado no puede iniciar sesion ni comprar.
- Direccion de envio debe ser obligatoria para confirmar compra con envio.

## 9. Excepciones / errores esperados

- **Email duplicado en registro**: no crear `User` ni `Customer`.
- **Datos de perfil invalidos**: no guardar cambios y mostrar validaciones.
- **Usuario sin permisos admin**: bloquear gestion de clientes en panel.
- **Relacion inconsistente User/Customer**: bloquear operacion y registrar incidencia.

## 10. Resultado esperado

Clientes con identidad y perfil comercial consistentes, listos para operar compra y postventa.

## 11. Datos que crea o actualiza

- `User` (autenticacion y rol)
- `Customer` (perfil comercial)
- `CustomerAddress` (direcciones)
- Estado de cliente (activo/inactivo)

## 12. Historias relacionadas

- `US-006`
- `US-007`

## 13. Criterios de aceptacion del flujo

- Al registrar cliente se crea `User` y `Customer` asociados.
- Cliente puede actualizar su perfil y direcciones.
- Admin puede visualizar y gestionar estado de clientes.
- Cliente inactivo no puede autenticarse ni comprar.
- No se permite inconsistencia entre `User` y `Customer`.

