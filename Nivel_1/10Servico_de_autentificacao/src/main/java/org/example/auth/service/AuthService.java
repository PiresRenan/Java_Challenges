package org.example.auth.service;

import org.example.crud.usuarios.model.User;

public interface AuthService {
    User authenticate(String email, String password);
    boolean register(User user);
}
