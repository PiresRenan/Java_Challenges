package org.example.auth.service;

import org.example.crud.usuarios.model.User;

import org.example.crud.usuarios.repository.UserDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserDAO userDAO;

    @Autowired
    public AuthServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User authenticate(String email, String password) {
        User user = userDAO.getUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public boolean register(User user) {
        if (userDAO.getUserByEmail(user.getEmail()) == null) {
            userDAO.saveUser(user);
            return true;
        }
        return false;
    }
}
