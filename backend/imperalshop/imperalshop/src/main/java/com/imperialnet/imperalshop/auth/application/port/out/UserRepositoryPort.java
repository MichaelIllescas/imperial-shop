package com.imperialnet.imperalshop.auth.application.port.out;

import com.imperialnet.imperalshop.auth.domain.model.User;

import java.util.Optional;

public interface UserRepositoryPort {

    Optional<User> findByEmail(String email);


}
