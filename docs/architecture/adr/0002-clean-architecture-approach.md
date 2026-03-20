# ADR-0002 - Clean Architecture Approach (Pragmatic)

## Estado

Aprobado

## Fecha

2026-03-20

## Contexto

`Imperial Shop` adopta monolito modular y requiere:

- alta velocidad de entrega para MVP,
- base mantenible y testeable,
- seguridad fuerte desde el inicio,
- bajo nivel de acoplamiento entre dominio y framework.

Aplicar Clean Architecture completa con exceso de capas puede ralentizar la entrega temprana.

## Decision

Se adopta **Clean Architecture pragmatica** por modulo de negocio, usando cuatro capas:

- `domain`
- `application`
- `infrastructure`
- `interfaces` (o `web`)

La regla principal es mantener el dominio aislado de detalles de framework.

## Estructura objetivo por modulo

Ejemplo para modulo `catalog`:

```text
catalog/
  domain/
    model/
    service/
  application/
    usecase/
    port/
  infrastructure/
    persistence/
    external/
  interfaces/
    http/
    dto/
    mapper/
```

## Reglas de dependencia

- `domain` no depende de Spring, JPA ni APIs externas.
- `application` depende de `domain` y define puertos (interfaces).
- `infrastructure` implementa puertos de `application`.
- `interfaces` expone endpoints y transforma DTOs.

Direccion permitida de dependencias:

`interfaces -> application -> domain`  
`infrastructure -> application/domain`

## Guardrails para evitar sobre-ingenieria

- No crear interfaces si no existe necesidad real de variacion.
- No duplicar mappers/capas sin valor funcional.
- Un caso de uso por accion relevante de negocio.
- Refactorizar a mayor separacion solo cuando aparezca dolor real.

## Consecuencias positivas

- Mejor mantenibilidad y testabilidad.
- Menor acoplamiento a framework.
- Facilita evolucion futura del monolito modular.
- Soporta controles de seguridad de forma transversal y consistente.

## Consecuencias negativas / trade-offs

- Leve costo inicial de estructura y disciplina.
- Riesgo de inconsistencia si no se respetan fronteras por modulo.
- Puede sentirse mas lento al principio comparado con enfoque anemico directo a controller/repository.

## Alternativas consideradas

1. **Arquitectura por capas clasica sin limites claros**
   - Pros: implementacion rapida inicial.
   - Contras: acoplamiento alto y deuda tecnica temprana.
   - Resultado: descartada.

2. **Clean Architecture estricta completa**
   - Pros: maximo aislamiento.
   - Contras: overhead excesivo para etapa MVP.
   - Resultado: descartada por costo de implementacion temprana.

## Criterios de cumplimiento

Se considera cumplido cuando:

- cada modulo principal (`auth`, `catalog`, `customer`, `order`, `payment`) respeta capas base,
- no hay dependencias de framework en `domain`,
- casos de uso criticos se pueden testear sin infraestructura real.

## Revision futura

Revisar esta decision si:

- crece significativamente el equipo,
- aumenta complejidad de integraciones,
- aparecen cuellos de mantenimiento por modulo.
