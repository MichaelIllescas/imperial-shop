package com.imperialnet.imperalshop.auth.application.usecase;

import com.imperialnet.imperalshop.auth.domain.model.User;

import java.util.List;

public interface GetAllUsersUseCase {
    List<User> getAllUsers();
}
