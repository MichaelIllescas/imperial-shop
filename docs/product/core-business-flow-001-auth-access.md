# Core Business Flow 001 - Authentication and Access

## 1. Nombre del flujo

`Registro, autenticacion y acceso por rol`

## 2. Objetivo

Permitir que clientes se registren y que clientes y administradores ingresen al sistema con permisos correctos segun su rol.

## 3. Actor principal

`Cliente o Admin`

## 4. Actores secundarios (opcional)

`Servicio de autenticacion, servicio de correo (recuperacion)`

## 5. Precondiciones

- Para login: el usuario existe y tiene una cuenta activa.
- Para registro: el email del cliente no esta registrado.

## 6. Disparador

El usuario intenta iniciar sesion o registrarse.

## 7. Pasos principales (happy path)

1. El usuario elige iniciar sesion o registrarse.
2. Si es cliente no registrado, completa formulario de registro.
3. El sistema valida datos de registro y crea cuenta cliente.
4. El usuario ingresa email y password.
5. El sistema valida credenciales.
6. El sistema identifica rol del usuario.
7. El sistema crea sesion/token seguro.
8. El sistema redirige segun rol:
   - Cliente -> tienda.
   - Admin -> panel de administracion.

## 8. Reglas de negocio

- No permitir acceso con credenciales invalidas.
- No permitir registro con email ya existente.
- Bloquear acceso a rutas de admin para usuarios cliente.
- Cerrar sesion invalida token/sesion activa.

## 9. Excepciones / errores esperados

- **Credenciales invalidas**: mostrar mensaje y permitir reintento.
- **Email ya registrado**: bloquear registro y sugerir iniciar sesion o recuperar password.
- **Datos de registro invalidos**: mostrar errores de validacion y no crear cuenta.
- **Usuario inactivo/bloqueado**: denegar acceso e informar estado.
- **Token expirado**: solicitar nuevo login.

## 10. Resultado esperado

Cliente registrado/autenticado o admin autenticado, con acceso solo a funcionalidades autorizadas.

## 11. Datos que crea o actualiza

- Sesion/token de autenticacion.
- Cuenta de cliente (en caso de registro).
- Ultimo acceso del usuario (si aplica).

## 12. Historias relacionadas

- `US-002`
- `US-005`

## 13. Criterios de aceptacion del flujo

- [ ] Cliente no registrado puede crear cuenta.
- [ ] Cliente autenticado accede a la tienda.
- [ ] Admin autenticado accede al panel admin.
- [ ] Usuario cliente no puede acceder a rutas admin.
- [ ] Logout invalida sesion/token.
- [ ] Credenciales invalidas no permiten acceso.

