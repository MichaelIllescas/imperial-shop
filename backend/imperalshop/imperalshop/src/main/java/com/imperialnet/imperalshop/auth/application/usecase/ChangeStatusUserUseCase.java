package com.imperialnet.imperalshop.auth.application.usecase;

import com.imperialnet.imperalshop.auth.domain.model.User;

public interface ChangeStatusUserUseCase {
    User changeStatus(User user, String status);
}
