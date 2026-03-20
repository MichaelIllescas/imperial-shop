# SEC-004 - Role Access Control

## Objetivo

Garantizar que cada usuario acceda solo a funciones permitidas por su rol.

## Alcance

- Endpoints backend.
- Rutas/protecciones frontend.
- Operaciones administrativas.

## Controles minimos

- Verificacion de rol en endpoints sensibles.
- Guards/protecciones de rutas en frontend.
- Denegacion por defecto en recursos no autorizados.

## Criterios de aceptacion

- [ ] Usuario cliente no puede acceder a acciones de admin.
- [ ] Usuario admin accede correctamente a panel y APIs admin.
- [ ] Endpoints sensibles validan autenticacion y rol.
- [ ] Accesos denegados quedan registrados.
