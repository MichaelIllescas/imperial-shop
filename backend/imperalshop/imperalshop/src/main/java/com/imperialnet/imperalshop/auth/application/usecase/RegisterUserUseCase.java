package com.imperialnet.imperalshop.auth.application.usecase;

import com.imperialnet.imperalshop.auth.domain.model.User;

public interface RegisterUserUseCase {
    User registerUser(User user);
}
