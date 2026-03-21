package com.imperialnet.imperalshop.auth.interfaces.dto;

import com.imperialnet.imperalshop.auth.domain.model.Role;
import com.imperialnet.imperalshop.auth.domain.model.Status;

import java.time.LocalDateTime;

public record UserResponse(
        Long id,
        String email,
        Role role,
        Status status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        LocalDateTime lastLoginAt
) {
}
