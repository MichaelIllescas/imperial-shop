package com.imperialnet.imperalshop.auth.infrastructure.config;

import com.imperialnet.imperalshop.auth.infrastructure.persistence.entity.RoleEntity;
import com.imperialnet.imperalshop.auth.infrastructure.persistence.entity.UserEntity;
import com.imperialnet.imperalshop.auth.infrastructure.persistence.entity.UserStatusEntity;
import com.imperialnet.imperalshop.auth.infrastructure.persistence.repository.UserRepositoryJPA;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminUserSeeder implements CommandLineRunner {

    private final UserRepositoryJPA userRepositoryJPA;
    private final PasswordEncoder passwordEncoder;

    @Value("${app.seed.admin.enabled:true}")
    private boolean enabled;

    @Value("${app.seed.admin.email:admin@imperial.local}")
    private String email;

    @Value("${app.seed.admin.password:admin123}")
    private String password;

    @Value("${app.seed.admin.role:ADMIN}")
    private String role;

    @Value("${app.seed.admin.status:ACTIVE}")
    private String status;

    public AdminUserSeeder(UserRepositoryJPA userRepositoryJPA, PasswordEncoder passwordEncoder) {
        this.userRepositoryJPA = userRepositoryJPA;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (!enabled) {
            return;
        }

        if (userRepositoryJPA.findByEmail(email).isPresent()) {
            return;
        }

        UserEntity admin = UserEntity.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .role(RoleEntity.valueOf(role.toUpperCase()))
                .status(UserStatusEntity.valueOf(status.toUpperCase()))
                .build();

        userRepositoryJPA.save(admin);
    }
}
