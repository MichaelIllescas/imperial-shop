# Product Backlog - Imperial Shop

Backlog priorizado para ejecutar el MVP sin burocracia.

## Convenciones

- Prioridad: `P1` (alta), `P2` (media), `P3` (baja).
- Estado: `Todo`, `Ready`, `In Progress`, `Done`, `Blocked`.
- Sprint objetivo: referencia tentativa para planificacion.

---

## Epic E1 - Autenticacion y acceso


| ID     | Item                             | Tipo | Prioridad | Estado | Sprint objetivo | Dependencias |
| ------ | -------------------------------- | ---- | --------- | ------ | --------------- | ------------ |
| US-002 | Registro, login y acceso por rol | US   | P1        | Ready  | Sprint 1        | -            |
| US-005 | Gestion de usuarios basica       | US   | P2        | Todo   | Sprint 1        | US-002       |


Referencia:

- `docs/product/core-business-flow-001-auth-access.md`

---

## Epic E2 - Catalogo y contenido comercial


| ID     | Item                          | Tipo | Prioridad | Estado | Sprint objetivo | Dependencias   |
| ------ | ----------------------------- | ---- | --------- | ------ | --------------- | -------------- |
| US-003 | Gestion de categorias         | US   | P1        | Ready  | Sprint 1        | US-002         |
| US-004 | Gestion de productos y stock  | US   | P1        | Ready  | Sprint 1        | US-003         |
| US-008 | Navegacion publica y busqueda | US   | P1        | Todo   | Sprint 1        | US-003, US-004 |
| US-009 | Detalle publico de producto   | US   | P1        | Todo   | Sprint 1        | US-004         |


Referencia:

- `docs/product/core-business-flow-002-catalog-setup.md`
- `docs/product/core-business-flow-005-public-storefront-navigation.md`

---

## Epic E3 - Cliente y perfil comercial


| ID     | Item                                       | Tipo | Prioridad | Estado | Sprint objetivo | Dependencias   |
| ------ | ------------------------------------------ | ---- | --------- | ------ | --------------- | -------------- |
| US-006 | Gestion de perfil y direcciones de cliente | US   | P1        | Todo   | Sprint 1        | US-002         |
| US-007 | Gestion administrativa de clientes         | US   | P2        | Todo   | Sprint 1        | US-002, US-006 |


Referencia:

- `docs/product/core-business-flow-004-customer-management.md`

---

## Epic E4 - Checkout y ventas


| ID     | Item                                       | Tipo | Prioridad | Estado | Sprint objetivo | Dependencias           |
| ------ | ------------------------------------------ | ---- | --------- | ------ | --------------- | ---------------------- |
| US-010 | Carrito como visitante y login en checkout | US   | P1        | Todo   | Sprint 1        | US-002, US-008, US-009 |
| US-001 | Comprar producto (checkout y pago)         | US   | P1        | Ready  | Sprint 1        | US-004, US-006, US-010 |


Referencia:

- `docs/product/core-business-flow-003-purchase.md`
- `docs/product/core-business-flow-005-public-storefront-navigation.md`

---

## Orden sugerido de ejecucion (Sprint 1)

1. US-002
2. US-003
3. US-004
4. US-008
5. US-009
6. US-010
7. US-006
8. US-001
9. US-007
10. US-005

---

## Backlog futuro (post MVP)

- Recuperacion de password.
- Cupones y promociones avanzadas.
- Reporteria avanzada.
- Notificaciones por WhatsApp/SMS.
- Multiples pasarelas de pago.

