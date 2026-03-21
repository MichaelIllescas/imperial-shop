package com.imperialnet.imperalshop.auth.interfaces.mapper;

import com.imperialnet.imperalshop.auth.domain.model.Role;
import com.imperialnet.imperalshop.auth.domain.model.Status;
import com.imperialnet.imperalshop.auth.domain.model.User;
import com.imperialnet.imperalshop.auth.infrastructure.persistence.entity.UserEntity;
import com.imperialnet.imperalshop.auth.interfaces.dto.CreateUserRequest;
import com.imperialnet.imperalshop.auth.interfaces.dto.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    default User toDomain(UserEntity e) {
        if (e == null) return null;
        return new User.Builder()
                .id(e.getId())
                .email(e.getEmail())
                .password(e.getPassword())
                .role(Role.valueOf(e.getRole().name()))
                .status(Status.valueOf(e.getStatus().name()))
                .createdAt(e.getCreatedAt())
                .updatedAt(e.getUpdatedAt())
                .lastLoginAt(e.getLastLoginAt())
                .build();
    }
    default User toDomain(CreateUserRequest r) {
        if (r == null) return null;
        return new User.Builder()
                .email(r.email())
                .password(r.password())
                .role(r.role())
                .status(r.status())
                .build();
    }

    UserEntity toEntity(User user);

    // Domain ↔ DTO
    UserResponse toResponse(User user);

}