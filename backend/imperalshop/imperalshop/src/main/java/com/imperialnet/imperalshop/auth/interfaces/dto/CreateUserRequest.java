package com.imperialnet.imperalshop.auth.interfaces.dto;

import com.imperialnet.imperalshop.auth.domain.model.Role;
import com.imperialnet.imperalshop.auth.domain.model.Status;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateUserRequest(
        @NotBlank(message = "El email es obligatorio")
        @Email(message = "El email no es valido")
        String email,

        @NotBlank(message = "La password es obligatoria")
        @Size(min = 8, message = "La password debe tener al menos 8 caracteres")
        String password,

        @NotNull(message = "El rol es obligatorio")
        Role role,

        @NotNull(message = "El estado es obligatorio")
        Status status
) {
}
