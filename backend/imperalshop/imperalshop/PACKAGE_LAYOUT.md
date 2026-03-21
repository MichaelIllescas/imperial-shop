# Estructura de paquetes (backend)

Alineado con `docs/architecture/adr/0002-clean-architecture-approach.md` (Clean Architecture pragmatica por modulo).

## Raiz

- `com.imperialnet.imperalshop` — `ImperalshopApplication` y configuracion global.
- `com.imperialnet.imperalshop.config` — beans Spring transversales (seguridad, CORS, etc.).

## Modulos de negocio

Cada modulo (`auth`, `catalog`, `customer`, `order`, `payment`) repite:

| Paquete | Uso |
|---------|-----|
| `domain.model` | Entidades y value objects de dominio (sin JPA/Spring). |
| `domain.service` | Reglas de dominio puras cuando aplique. |
| `application.usecase` | Casos de uso / orquestacion. |
| `application.port` | Interfaces (puertos) hacia infraestructura. |
| `infrastructure.persistence` | Entidades JPA, repositorios, adaptadores a DB. |
| `infrastructure.config` | Config especifica del modulo si hace falta. |
| `infrastructure.external` | Integraciones (Mercado Pago, Correo, email, etc.). |
| `interfaces.http` | Controllers REST. |
| `interfaces.dto` | Request/response DTOs. |
| `interfaces.mapper` | Mapeos DTO <-> dominio. |

## Shared

- `shared.domain.exception` — excepciones de dominio compartidas.
- `shared.application` — utilidades de capa aplicacion compartidas si hace falta.

## Resources

- `src/main/resources/db/migration` — scripts Flyway/Liquibase (cuando los agregues).
- `src/main/resources/static` / `templates` — reservados si aplica.

Las carpetas vacias incluyen `.gitkeep` para versionarlas en Git.
