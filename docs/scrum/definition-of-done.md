# Definition of Done (DoD) - Imperial Shop

Una historia se considera terminada solo si cumple todos los puntos.

## 1) Funcionalidad

- [ ] Cumple criterios de aceptacion de la US.
- [ ] No rompe funcionalidades existentes del flujo relacionado.
- [ ] Maneja casos de error esperados.

## 2) Calidad tecnica

- [ ] Codigo revisado por al menos una persona.
- [ ] Build y lint sin errores.
- [ ] Pruebas ejecutadas y verdes (unitarias/integracion segun aplique).
- [ ] No hay logs con informacion sensible.

## 3) Seguridad (obligatorio)

- [ ] Validaciones de entrada implementadas.
- [ ] Control de acceso por rol aplicado en endpoints y vistas.
- [ ] Credenciales/passwords protegidas (hash seguro, nunca texto plano).
- [ ] Eventos de seguridad relevantes auditados (login, bloqueos, cambios de rol).
- [ ] No se introducen secretos hardcodeados en codigo o repositorio.

## 4) Datos y operacion

- [ ] Persistencia consistente (sin romper integridad de datos).
- [ ] Errores operativos informan mensaje claro al usuario.
- [ ] Configuracion requerida documentada (si aplica).

## 5) Documentacion

- [ ] US actualizada con cambios relevantes.
- [ ] Core flow referenciado sigue vigente o fue ajustado.
- [ ] Si hubo decision tecnica relevante, se registra en ADR.

## 6) Criterio final

Si falta un item, la historia vuelve a `In Progress`.
