package com.imperialnet.imperalshop.auth.domain.service;

import com.imperialnet.imperalshop.auth.domain.exception.UserDomainException;
import com.imperialnet.imperalshop.auth.domain.model.Role;
import com.imperialnet.imperalshop.auth.domain.model.Status;

import java.util.regex.Pattern;

public class ValidateUserService {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    private  ValidateUserService() {}

    public static  void validateEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new UserDomainException("El email es obligatorio");
        }

        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new UserDomainException("El formato del email no es válido");
        }
    }

    public static void validatePassword(String password) {
        if (password == null || password.isBlank()) {
            throw new UserDomainException("La contraseña es obligatoria");
        }

        if (password.length() < 6) {
            throw new UserDomainException("La contraseña debe tener al menos 6 caracteres");
        }
    }

    public static void validateRole(Role role) {
        if (role == null) {
            throw new UserDomainException("El rol es obligatorio");
        }
    }

    public static void validateStatus(Status status) {
        if (status == null) {
            throw new UserDomainException("El estado es obligatorio");
        }
    }
}