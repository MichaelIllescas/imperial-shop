package com.imperialnet.imperalshop.auth.application.usecase;

import com.imperialnet.imperalshop.auth.domain.model.User;

public interface GetUserByIdUseCase {
    User getUserById(String id);
}
