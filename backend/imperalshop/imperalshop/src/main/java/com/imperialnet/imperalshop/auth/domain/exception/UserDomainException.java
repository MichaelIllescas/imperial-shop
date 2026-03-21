package com.imperialnet.imperalshop.auth.domain.exception;

import com.imperialnet.imperalshop.shared.exception.BadRequestException;

public class UserDomainException extends BadRequestException {
    public UserDomainException(String message) {
        super(message);
    }
}
