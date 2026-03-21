# Data Model v1 - Imperial Shop

Modelo de datos inicial alineado con los core flows y user stories del MVP.

## Convenciones generales

- **PK**: `BIGINT` autoincremental salvo indicacion contraria.
- **IDs publicos** (opcional): `UUID` en columnas `public_id` donde haga falta exponer en API sin revelar secuencia interna.
- **Timestamps**: `created_at`, `updated_at` en tablas principales.
- **Soft delete** (opcional): `deleted_at` donde aplique (productos, categorias).
- **Moneda**: `ARS` implicito en MVP; montos en `DECIMAL(12,2)`.

---

## Diagrama de relaciones (resumen textual)

```text
User 1--1 Customer (solo rol CLIENT)
User *--* Role (via user_role o rol simple en user)

Customer 1--* CustomerAddress

Category *--* Product (via product_category)  [o Product N--1 Category si solo una categoria por producto]

Cart 1--* CartItem --* Product
Order 1--* OrderItem --* Product
Order 1--1 Payment (o 1--* si reintentos)

RefreshToken *--1 User
SecurityAuditEvent *--1 User (opcional)
```

> **Nota**: Si en MVP cada producto pertenece a **una sola** categoria, simplificar a `Product.category_id` y eliminar tabla intermedia.

---

## 1. Identidad y acceso

### `user`


| Campo                   | Tipo                | Notas                                           |
| ----------------------- | ------------------- | ----------------------------------------------- |
| id                      | BIGINT PK           |                                                 |
| email                   | VARCHAR(255) UNIQUE | Login                                           |
| password_hash           | VARCHAR(255)        | Argon2/BCrypt                                   |
| role                    | ENUM o VARCHAR      | `ADMIN`, `CLIENT` (o tabla `role` si multi-rol) |
| status                  | ENUM                | `ACTIVE`, `BLOCKED`, `INACTIVE`                 |
| last_login_at           | TIMESTAMP           | Opcional                                        |
| created_at / updated_at | TIMESTAMP           |                                                 |


### `refresh_token` (JWT refresh)


| Campo      | Tipo              | Notas                            |
| ---------- | ----------------- | -------------------------------- |
| id         | BIGINT PK         |                                  |
| user_id    | BIGINT FK -> user |                                  |
| token_hash | VARCHAR(255)      | Hash del refresh, no texto plano |
| expires_at | TIMESTAMP         |                                  |
| revoked_at | TIMESTAMP NULL    | Revocacion                       |
| created_at | TIMESTAMP         |                                  |


### `security_audit_event` (SEC-005)


| Campo      | Tipo           | Notas                                                         |
| ---------- | -------------- | ------------------------------------------------------------- |
| id         | BIGINT PK      |                                                               |
| user_id    | BIGINT FK NULL | Si aplica                                                     |
| event_type | VARCHAR(64)    | LOGIN_OK, LOGIN_FAIL, LOGOUT, ROLE_CHANGE, USER_BLOCKED, etc. |
| ip_address | VARCHAR(45)    | IPv4/IPv6                                                     |
| metadata   | JSON NULL      | Sin datos sensibles                                           |
| created_at | TIMESTAMP      |                                                               |


---

## 2. Cliente comercial

### `customer`


| Campo                           | Tipo                     | Notas                            |
| ------------------------------- | ------------------------ | -------------------------------- |
| id                              | BIGINT PK                |                                  |
| user_id                         | BIGINT UNIQUE FK -> user | Relacion 1:1 con usuario cliente |
| first_name                      | VARCHAR(100)             |                                  |
| last_name                       | VARCHAR(100)             |                                  |
| phone                           | VARCHAR(30) NULL         |                                  |
| document_type / document_number | VARCHAR NULL             | Si aplica facturacion            |
| created_at / updated_at         | TIMESTAMP                |                                  |


### `customer_address`


| Campo                   | Tipo                    | Notas                            |
| ----------------------- | ----------------------- | -------------------------------- |
| id                      | BIGINT PK               |                                  |
| customer_id             | BIGINT FK -> customer   |                                  |
| label                   | VARCHAR(100) NULL       | Ej: "Casa", "Trabajo"            |
| street                  | VARCHAR(255)            |                                  |
| city                    | VARCHAR(100)            |                                  |
| province                | VARCHAR(100)            |                                  |
| postal_code             | VARCHAR(20)             | Importante para Correo Argentino |
| country                 | VARCHAR(2) DEFAULT 'AR' |                                  |
| is_default_shipping     | BOOLEAN                 |                                  |
| created_at / updated_at | TIMESTAMP               |                                  |


---

## 3. Catalogo

### `category`


| Campo                   | Tipo                | Notas                |
| ----------------------- | ------------------- | -------------------- |
| id                      | BIGINT PK           |                      |
| name                    | VARCHAR(150)        |                      |
| slug                    | VARCHAR(160) UNIQUE | URL amigable         |
| status                  | ENUM                | `ACTIVE`, `INACTIVE` |
| sort_order              | INT DEFAULT 0       |                      |
| created_at / updated_at | TIMESTAMP           |                      |


### `product`


| Campo                   | Tipo                    | Notas                                            |
| ----------------------- | ----------------------- | ------------------------------------------------ |
| id                      | BIGINT PK               |                                                  |
| sku                     | VARCHAR(64) UNIQUE NULL | Opcional MVP                                     |
| name                    | VARCHAR(255)            |                                                  |
| slug                    | VARCHAR(280) UNIQUE     |                                                  |
| description             | TEXT NULL               |                                                  |
| primary_image_url       | VARCHAR(2048) NULL      | URL publica imagen principal (CDN, bucket, etc.) |
| price                   | DECIMAL(12,2)           |                                                  |
| stock_quantity          | INT                     | >= 0                                             |
| status                  | ENUM                    | `DRAFT`, `PUBLISHED`, `ARCHIVED`                 |
| created_at / updated_at | TIMESTAMP               |                                                  |


**Imagenes adicionales (opcional post-MVP o si el catalogo lo exige):** tabla `product_image` con `product_id`, `image_url`, `sort_order` para galeria. En MVP suele alcanzar `primary_image_url` en `product`.

### Relacion producto-categoria

**Opcion A (simple MVP)**: `product.category_id` FK -> `category` (una categoria por producto).

**Opcion B**: tabla `product_category (product_id, category_id)` PK compuesta (varias categorias).

---

## 4. Carrito (visitante y logueado)

### `cart`


| Campo                   | Tipo              | Notas                              |
| ----------------------- | ----------------- | ---------------------------------- |
| id                      | BIGINT PK         |                                    |
| user_id                 | BIGINT FK NULL    | Si logueado                        |
| session_id              | VARCHAR(128) NULL | Carrito invitado (cookie/sesion)   |
| status                  | ENUM              | `OPEN`, `CHECKED_OUT`, `ABANDONED` |
| created_at / updated_at | TIMESTAMP         |                                    |


> Regla: un carrito `OPEN` por `user_id` o por `session_id` segun corresponda.

### `cart_item`


| Campo               | Tipo                 | Notas                                         |
| ------------------- | -------------------- | --------------------------------------------- |
| id                  | BIGINT PK            |                                               |
| cart_id             | BIGINT FK -> cart    |                                               |
| product_id          | BIGINT FK -> product |                                               |
| quantity            | INT                  | >= 1                                          |
| unit_price_snapshot | DECIMAL(12,2)        | Precio al agregar (opcional pero recomendado) |


---

## 5. Pedido y pago

### Enumeraciones sugeridas

- `delivery_type`: `BRANCH_PICKUP` | `HOME_DELIVERY` | `CORREO_PICKUP`
- `order_status`: `PENDING_PAYMENT` | `PAID` | `PREPARING` | `SHIPPED` | `DELIVERED` | `CANCELLED` (ajustar a flujo operativo)
- `payment_status`: `PENDING` | `APPROVED` | `REJECTED` | `REFUNDED`
- `payment_provider`: `MERCADOPAGO` (MVP)

### `order`


| Campo                   | Tipo                               | Notas                 |
| ----------------------- | ---------------------------------- | --------------------- |
| id                      | BIGINT PK                          |                       |
| order_number            | VARCHAR(32) UNIQUE                 | Legible para cliente  |
| customer_id             | BIGINT FK -> customer              |                       |
| status                  | ENUM                               | Ver `order_status`    |
| delivery_type           | ENUM                               | Ver `delivery_type`   |
| shipping_cost           | DECIMAL(12,2)                      | Cotizacion Correo o 0 |
| subtotal                | DECIMAL(12,2)                      |                       |
| total                   | DECIMAL(12,2)                      |                       |
| shipping_address_id     | BIGINT FK NULL -> customer_address | Si envio              |
| notes                   | TEXT NULL                          |                       |
| created_at / updated_at | TIMESTAMP                          |                       |


### `order_item`


| Campo      | Tipo                 | Notas    |
| ---------- | -------------------- | -------- |
| id         | BIGINT PK            |          |
| order_id   | BIGINT FK -> order   |          |
| product_id | BIGINT FK -> product |          |
| quantity   | INT                  |          |
| unit_price | DECIMAL(12,2)        | Snapshot |
| line_total | DECIMAL(12,2)        |          |


### `payment`


| Campo                   | Tipo                      | Notas                                         |
| ----------------------- | ------------------------- | --------------------------------------------- |
| id                      | BIGINT PK                 |                                               |
| order_id                | BIGINT FK UNIQUE -> order | Un pago principal por orden en MVP            |
| provider                | ENUM                      | MERCADOPAGO                                   |
| external_id             | VARCHAR(128) NULL         | ID de MP                                      |
| status                  | ENUM                      | Ver `payment_status`                          |
| amount                  | DECIMAL(12,2)             |                                               |
| raw_payload             | JSON NULL                 | Respuesta MP (cuidado PII; retencion acotada) |
| created_at / updated_at | TIMESTAMP                 |                                               |


---

## 6. Integraciones (referencia)

- **Mercado Pago**: IDs y estado en `payment`; no duplicar logica de negocio en JSON crudo.
- **Correo Argentino**: cotizacion puede guardarse en `order` (`shipping_cost`) y opcionalmente snapshot en JSON corto si se necesita auditoria.

---

## 7. Pendientes / decisiones abiertas

- Una vs varias categorias por producto (definir antes de migraciones).
- Facturacion electronica: campos fiscales en `customer` u otra entidad.
- Historial de precios: fuera de alcance MVP si no es requerido.

---

## Referencias

- `docs/product/core-business-flow-004-customer-management.md`
- `docs/product/core-business-flow-003-purchase.md`
- `docs/architecture/adr/0001-initial-architecture-decision.md`

