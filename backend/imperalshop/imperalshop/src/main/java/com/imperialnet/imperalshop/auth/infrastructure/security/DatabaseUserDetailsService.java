package com.imperialnet.imperalshop.auth.infrastructure.security;

import com.imperialnet.imperalshop.auth.infrastructure.persistence.entity.UserEntity;
import com.imperialnet.imperalshop.auth.infrastructure.persistence.repository.UserRepositoryJPA;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DatabaseUserDetailsService implements UserDetailsService {

    private final UserRepositoryJPA userRepository;

    public DatabaseUserDetailsService(UserRepositoryJPA userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        boolean enabled = user.getStatus().name().equals("ACTIVE");

        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole().name())
                .disabled(!enabled)
                .build();
    }
}
