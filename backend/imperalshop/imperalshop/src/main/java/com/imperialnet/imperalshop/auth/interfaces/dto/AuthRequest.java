package com.imperialnet.imperalshop.auth.interfaces.dto;


public record AuthRequest(
        String username,
        String password
) {}