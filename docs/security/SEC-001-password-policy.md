# SEC-001 - Password Policy

## Objetivo

Definir y aplicar politica de passwords fuertes para cuentas de la plataforma.

## Alcance

- Registro de cliente.
- Alta/edicion de usuario por admin.
- Cambio o reseteo de password.

## Reglas minimas

- Longitud minima: 8 caracteres.
- Al menos una mayuscula.
- Al menos una minuscula.
- Al menos un numero.
- Al menos un caracter especial.

## Criterios de aceptacion

- [ ] Registro rechaza passwords que no cumplan politica.
- [ ] Cambio/reseteo rechaza passwords debiles.
- [ ] Mensajes de validacion son claros para el usuario.
- [ ] La politica queda documentada para el equipo.
