package com.imperialnet.imperalshop.auth.interfaces.http;
import com.imperialnet.imperalshop.auth.interfaces.dto.AuthRequest;
import com.imperialnet.imperalshop.auth.interfaces.dto.AuthResponse;
import com.imperialnet.imperalshop.auth.infrastructure.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager,
                          JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        // validar usuario y contraseña
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );

        // 🔑 generar JWT
        String token = jwtService.generateToken(request.username());

        return new AuthResponse(token);
    }
}