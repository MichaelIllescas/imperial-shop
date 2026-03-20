# SEC-005 - Security Audit Events

## Objetivo

Tener trazabilidad de eventos criticos de seguridad para deteccion y respuesta.

## Alcance

- Login exitoso/fallido.
- Logout.
- Bloqueos temporales por intentos fallidos.
- Cambios de rol/estado de usuario por admin.

## Requerimientos minimos

- Registrar fecha/hora, usuario (si aplica), IP y evento.
- No registrar datos sensibles (passwords, tokens completos).
- Mantener formato consistente para analisis posterior.

## Criterios de aceptacion

- [ ] Eventos criticos de seguridad se registran correctamente.
- [ ] Logs no exponen secretos ni credenciales.
- [ ] Se puede filtrar eventos por usuario y fecha.
- [ ] Cambios administrativos de seguridad quedan auditados.
