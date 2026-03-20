# ADR-0001 - Initial Architecture Decision

## Estado

Aprobado

## Fecha

2026-03-20

## Contexto

`Imperial Shop` necesita una arquitectura que permita:

- salir rapido con un MVP funcional de ecommerce,
- mantener una base tecnica ordenada y segura desde el inicio,
- soportar crecimiento gradual sin sobredisenar.

La solucion debe cubrir autenticacion robusta, operaciones comerciales y mantenibilidad del producto.

## Decision

Se adopta una arquitectura de **monolito modular** con el siguiente stack:

- Frontend: `Angular 21` + `Tailwind`.
- Backend: `Java 21` + `Spring Boot 4`.
- Base de datos: `MySQL` (unica DB en MVP).
- Autenticacion: `JWT + refresh token`.
- Entornos iniciales: `dev` y `prod`.

## Razonamiento

- **Monolito modular**: reduce complejidad operativa inicial y acelera entrega.
- **Angular + Spring Boot**: stack robusto, productivo y ampliamente soportado.
- **MySQL unica**: simplifica operacion y reduce costo/overhead del MVP.
- **JWT + refresh**: balancea seguridad y experiencia de usuario.
- **Dev + prod**: permite iterar rapido sin agregar complejidad temprana de infraestructura.

## Consecuencias positivas

- Menor time-to-market.
- Menor costo inicial de infraestructura y mantenimiento.
- Estructura modular que facilita evolucion futura.
- Base de seguridad solida desde Sprint 1.

## Consecuencias negativas / trade-offs

- Escalado horizontal menos granular que microservicios.
- Un despliegue puede impactar mas areas del sistema.
- Requiere disciplina modular para evitar acoplamiento interno.

## Alternativas consideradas

1. **Microservicios desde el inicio**
   - Pros: escalado por dominio y despliegues independientes.
   - Contras: complejidad alta para etapa MVP.
   - Resultado: descartada por costo y velocidad de salida.

2. **Monolito no modular**
   - Pros: implementacion inicial mas rapida.
   - Contras: deuda tecnica y acoplamiento temprano.
   - Resultado: descartada por riesgo de mantenibilidad.

## Implicancias tecnicas iniciales

- Definir modulos de dominio desde el inicio (`auth`, `catalog`, `customer`, `order`, `payment`).
- Aplicar control de acceso por rol en backend y frontend.
- Implementar politica de tokens (expiracion, refresh, revocacion basica).
- Mantener trazabilidad de eventos de seguridad.

## Revision futura

Esta decision se revisara cuando ocurra alguno de estos escenarios:

- aumento fuerte de carga o equipos trabajando en paralelo sobre dominios distintos,
- necesidad de despliegues independientes por modulo,
- requerimientos de disponibilidad/escalado no cubiertos por el monolito modular.
