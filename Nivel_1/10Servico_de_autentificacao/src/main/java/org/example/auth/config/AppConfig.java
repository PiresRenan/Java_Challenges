package org.example.auth.config;

import org.example.auth.service.AuthService;
import org.example.auth.service.AuthServiceImpl;

import org.example.crud.usuarios.repository.UserDAO;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    private final UserDAO userDAO;

    public AppConfig(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Bean
    public AuthService authService() {
        return new AuthServiceImpl(userDAO);
    }
}