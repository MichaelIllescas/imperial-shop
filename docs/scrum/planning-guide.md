# Planning Guide (Lean)

Guía práctica para iniciar la planificación y documentación de `Imperial Shop` sin burocracia.

## 1) Product Goal (1 página)

Objetivo: alinear qué problema resolvemos y para quién.

Checklist:
- [ ] Definir problema principal que resuelve el producto.
- [ ] Definir usuario objetivo (quién compra y quién opera).
- [ ] Definir propuesta de valor en una frase.
- [ ] Definir alcance de la primera versión (MVP).
- [ ] Definir explícitamente qué queda fuera por ahora.

Entregable sugerido:
- `docs/product/product-vision.md`

---

## 2) Core Business Flow

Objetivo: visualizar el recorrido principal del usuario.

Checklist:
- [ ] Escribir flujo principal de punta a punta (ejemplo: login -> catálogo -> carrito -> checkout).
- [ ] Identificar puntos críticos (errores, validaciones, pagos, stock).
- [ ] Identificar dependencias externas (pasarela de pago, correo, etc.).

Entregable sugerido:
- Sección en `docs/product/backlog.md` o documento corto de flujo.

---

## 3) Initial Product Backlog (nivel épica)

Objetivo: priorizar trabajo por valor de negocio.

Checklist:
- [ ] Definir 5-10 épicas iniciales.
- [ ] Asignar prioridad (`P1`, `P2`, `P3`).
- [ ] Marcar impacto esperado de cada épica.
- [ ] Marcar riesgos/tamaño (S, M, L) para ordenar mejor.

Entregable sugerido:
- `docs/product/backlog.md`

---

## 4) Sprint 1 User Stories (solo primeras)

Objetivo: preparar historias listas para construir.

Checklist:
- [ ] Seleccionar solo historias de mayor prioridad.
- [ ] Redactar cada historia en formato: Como [rol], quiero [objetivo], para [beneficio].
- [ ] Agregar criterios de aceptación claros y testeables.
- [ ] Agregar supuestos o dependencias de la historia.
- [ ] Asignar ID (`US-001`, `US-002`, ...).

Entregable sugerido:
- `docs/user-stories/US-001-*.md`
- `docs/user-stories/README.md` (índice)

---

## 5) Definition of Done (DoD) v1

Objetivo: unificar el criterio de "terminado de verdad".

Checklist:
- [ ] Código implementado y revisado.
- [ ] Build/lint sin errores críticos.
- [ ] Criterios de aceptación cumplidos.
- [ ] Pruebas acordadas ejecutadas.
- [ ] Documentación mínima actualizada.

Entregable sugerido:
- `docs/scrum/definition-of-done.md`

---

## 6) ADR iniciales (decisiones técnicas)

Objetivo: dejar trazabilidad de decisiones importantes.

Checklist:
- [ ] Definir stack base.
- [ ] Definir estrategia de autenticación/autorización.
- [ ] Definir base de datos y enfoque de persistencia.
- [ ] Registrar consecuencias y trade-offs.

Entregable sugerido:
- `docs/architecture/adr/0001-initial-architecture-decision.md`
- `docs/architecture/adr/0002-auth-strategy.md`

---

## 7) Data Model v1 (justo para Sprint 1)

Objetivo: modelar entidades mínimas para construir.

Checklist:
- [ ] Listar entidades principales (ejemplo: User, Product, Cart, Order, Payment).
- [ ] Definir relaciones entre entidades.
- [ ] Definir campos obligatorios clave.
- [ ] Definir reglas básicas de integridad.

Entregable sugerido:
- `docs/data/data-model.md`

---

## Definition of Ready (para empezar desarrollo)

Una historia está lista para entrar al sprint cuando:
- [ ] Tiene objetivo claro de negocio.
- [ ] Tiene criterios de aceptación.
- [ ] No tiene bloqueos externos abiertos.
- [ ] Se entiende qué validar al finalizar.

---

## Recommended Execution Order (simple)

1. Product Goal
2. Core Business Flow
3. Initial Backlog
4. Sprint 1 User Stories
5. DoD v1
6. ADR 0001
7. Data Model v1

---

## Working Rule (anti-bureaucracy)

Documentar solo lo que ayuda a decidir o construir en el sprint actual.  
Si un documento no se usa para tomar decisiones, simplificarlo o eliminarlo.
