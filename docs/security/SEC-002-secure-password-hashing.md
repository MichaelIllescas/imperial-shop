# SEC-002 - Secure Password Hashing

## Objetivo

Almacenar passwords usando hash robusto y nunca en texto plano.

## Alcance

- Registro de usuario.
- Cambio/reseteo de password.
- Verificacion de login.

## Requerimiento tecnico

- Usar `Argon2id` o `BCrypt` con configuracion segura.
- No almacenar ni loguear passwords en claro.

## Criterios de aceptacion

- [ ] Passwords se guardan hasheadas con algoritmo seguro.
- [ ] Login valida contra hash almacenado correctamente.
- [ ] No existen logs con passwords en claro.
- [ ] Configuracion del algoritmo queda documentada.
