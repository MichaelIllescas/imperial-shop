package com.imperialnet.imperalshop.auth.application.usecase;

import com.imperialnet.imperalshop.auth.domain.model.User;

public interface DeleteUserUseCase {
    void deleteUser(User user);
}
