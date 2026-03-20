# SEC-003 - Brute-force Protection

## Objetivo

Reducir riesgo de ataques por fuerza bruta en login.

## Alcance

- Endpoint/login de autenticacion.
- APIs relacionadas con autenticacion.

## Controles minimos

- Rate limit por IP y por cuenta.
- Bloqueo temporal progresivo tras intentos fallidos.
- Mensaje generico de error (sin filtrar si usuario existe).

## Criterios de aceptacion

- [ ] Luego de N intentos fallidos se aplica bloqueo temporal.
- [ ] Rate limit efectivo en endpoint de login.
- [ ] Mensajes de error no exponen informacion sensible.
- [ ] Eventos de bloqueo quedan auditados.
