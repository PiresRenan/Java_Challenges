package org.example.auth.presentation;

import org.example.crud.usuarios.model.User;
import org.example.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class AuthApp {
    private final AuthService authService;

    @Autowired
    public AuthApp(AuthService authService) {
        this.authService = authService;
    }

    public void login(String email, String password) {
        User user = authService.authenticate(email, password);
        if (user != null) {
            System.out.println("Login bem-sucedido para o usuário: " + user.getName());
        } else {
            System.out.println("Falha ao fazer login. Verifique suas credenciais.");
        }
    }

    public void register(String name, String email, String password) {
        User user = new User(name, email, password);
        if (authService.register(user)) {
            System.out.println("Usuário registrado com sucesso: " + user.getName());
        } else {
            System.out.println("Erro ao registrar usuário. O usuário já existe.");
        }
    }
}
