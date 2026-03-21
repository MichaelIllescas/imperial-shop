package com.imperialnet.imperalshop.auth.infrastructure.persistence.adapter;

import com.imperialnet.imperalshop.auth.application.port.out.UserRepositoryPort;
import com.imperialnet.imperalshop.auth.domain.model.User;
import com.imperialnet.imperalshop.auth.infrastructure.persistence.repository.UserRepositoryJPA;
import com.imperialnet.imperalshop.auth.interfaces.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserRepositoryJPA  userRepositoryJPA;
    private final UserMapper userMapper;

    public  UserRepositoryAdapter(UserRepositoryJPA userRepositoryJPA, UserMapper userMapper) {
        this.userRepositoryJPA = userRepositoryJPA;
        this.userMapper = userMapper;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepositoryJPA.findByEmail(email)
                .map(userMapper::toDomain);
    }
}
