# Estructura de carpetas (frontend Angular)

Alineada con los modulos de negocio del backend y con `docs/architecture/adr/0002-clean-architecture-approach.md` (separacion por contexto).

## `src/app/core/`

Codigo de aplicacion singleton: no debe importarse desde `features`.

- `guards` — rutas protegidas (admin, cliente autenticado).
- `interceptors` — HTTP (JWT, errores).
- `services` — API base, auth session, etc.
- `models` — tipos/interfaces compartidos solo por core (ej. `User`, `ApiError`).

## `src/app/shared/`

UI y utilidades reutilizables entre features.

- `components` — botones, inputs, cards genericas.
- `directives` / `pipes` — helpers transversales.
- `models` — DTOs o tipos compartidos entre varias features.

## `src/app/layout/`

Layouts de shell (cabecera, menu admin, contenedor principal).

- `components` — `main-layout`, `admin-layout`, etc.

## `src/app/features/`

Una carpeta por contexto. En cada feature:

- `pages` — rutas / smart components (standalone).
- `components` — presentacion especifica del feature.
- `services` — llamadas HTTP y estado local del feature.
- `models` — tipos del dominio de pantalla (DTOs, view models).

### Features

| Carpeta | Rol |
|---------|-----|
| `auth` | Registro, login, logout. |
| `shop` | Tienda publica: home, listado, busqueda, detalle, carrito (visitante). |
| `catalog` | Panel admin: categorias y productos. |
| `customer` | Perfil cliente y direcciones. |
| `order` | Pedidos (historial cliente / gestion admin segun rutas). |
| `payment` | Checkout, integracion visual con pasarela si aplica en front. |

> **Rutas:** agrupar en `app.routes.ts` con `loadChildren` o imports lazy por feature cuando agregues `*.routes.ts` por modulo.

## `src/assets/`

Recursos estaticos servidos en `/assets` (ver `angular.json`).

- `images` / `icons`

## `src/environments/`

Archivos de entorno (`environment.ts`, `environment.prod.ts`) cuando los definas.

## `.gitkeep`

Las carpetas vacias incluyen `.gitkeep` para versionarlas en Git.
