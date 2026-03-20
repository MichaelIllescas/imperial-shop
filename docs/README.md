# Documentacion - Imperial Shop

Mapa general para ubicar rapidamente cada documento del proyecto.

## Como usar esta documentacion

- Si estas arrancando: leer `product/product_vision_imperial_shop.md` -> `product/backlog.md` -> `scrum/sprint-1-scope.md`.
- Si vas a desarrollar una historia: leer primero su `US-XXX` y luego el `core-business-flow` relacionado.
- Si hay dudas de implementacion: revisar `architecture/adr/`.
- Si hay dudas de datos: revisar `data/data-model.md`.
- Antes de cerrar una historia: validar `scrum/definition-of-done.md`.

## Orden recomendado de lectura (nuevo integrante)

1. `product/product_vision_imperial_shop.md`
2. `product/backlog.md`
3. `scrum/sprint-1-scope.md`
4. `product/core-business-flow-001-auth-access.md`
5. `product/core-business-flow-002-catalog-setup.md`
6. `product/core-business-flow-005-public-storefront-navigation.md`
7. `product/core-business-flow-003-purchase.md`
8. `data/data-model.md`
9. `architecture/adr/0001-initial-architecture-decision.md`
10. `architecture/adr/0002-clean-architecture-approach.md`

## Mapa por carpeta

### `product/`

- Vision del producto: `product/product_vision_imperial_shop.md`
- Backlog priorizado: `product/backlog.md`
- Flows de negocio:
  - `product/core-business-flow-001-auth-access.md`
  - `product/core-business-flow-002-catalog-setup.md`
  - `product/core-business-flow-003-purchase.md`
  - `product/core-business-flow-004-customer-management.md`
  - `product/core-business-flow-005-public-storefront-navigation.md`
- Plantilla reusable de flow: `product/core-business-flow-template.md`

### `user-stories/`

- Historias funcionales del MVP (`US-001` a `US-010`).
- Una historia por archivo para facilitar seguimiento en sprint.

### `scrum/`

- Definition of Done: `scrum/definition-of-done.md`
- Plantilla de planning: `scrum/sprint-planning-template.md`

### `security/`

- Tareas tecnicas de seguridad `SEC-001` a `SEC-005`.
- Indice: `security/README.md`

### `architecture/adr/`

- ADR-0001 (decision inicial de arquitectura): `architecture/adr/0001-initial-architecture-decision.md`
- ADR-0002 (clean architecture pragmatica): `architecture/adr/0002-clean-architecture-approach.md`

### `data/`

- Modelo de datos v1: `data/data-model.md`

## Documentos transversales (raiz de `docs/`)

- Guia de planificacion: `scrum/planning-guide.md`
- Scope actual de sprint: `scrum/sprint-1-scope.md`
- Este indice: `README.md`

## Regla simple de mantenimiento

Cuando cambie una US o un flow, actualizar en la misma sesion:

- documento afectado,
- referencias cruzadas,
- y backlog/scope si cambia prioridad o dependencia.

