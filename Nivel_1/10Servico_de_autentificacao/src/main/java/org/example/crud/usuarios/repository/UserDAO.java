package org.example.crud.usuarios.repository;

import org.example.crud.usuarios.model.User;

import java.util.List;

public interface UserDAO {

    User getUserById(int id);

    List<User> getAllUsers();

    void saveUser(User user);

    void updateUser(String variable, int where, String email);

    boolean deleteUser(int id);
}