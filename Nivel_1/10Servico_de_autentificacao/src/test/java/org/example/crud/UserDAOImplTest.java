package org.example.crud;

import java.util.ArrayList;
import java.util.List;

import org.example.crud.usuarios.model.User;
import org.example.crud.usuarios.repository.UserDAOImpl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOImplTest {

    private final UserDAOImpl userDao = new UserDAOImpl();
    private final User user1 = new User(1, "João da Silva", "fulanodetal@exemplo.com", "senhasegura");
    private final User user2 = new User(2, "Maria Oliveira", "maria.oliveira@exemplo.com", "senhaforte");
    private final User user3 = new User(3, "Pedro Souza", "pedro.souza@exemplo.com", "outrasenha");

    @Test
    void testSaveUser() {
        userDao.saveUser(user1);
    }

    @Test
    void testGetUserById() {
        User user = userDao.getUserById(4);

        assertEquals(user.getName(), user1.getName());
        assertEquals(user.getEmail(), user1.getEmail());
        assertEquals(user.getPassword(), user1.getPassword());
    }

    @Test
    void testGetAllUsers() {
        List<User> userEsperados = new ArrayList<>();
        userEsperados.add(user1);
        userEsperados.add(user2);
        userEsperados.add(user3);

        List<User> users = userDao.getAllUsers();
        assertFalse(users.isEmpty());

        int i = 1;
        for (User userEsperado: userEsperados){
            User user = userDao.getUserById(i);

            assertEquals(user.getId(), userEsperado.getId());
            assertEquals(user.getName(), userEsperado.getName());
            assertEquals(user.getEmail(), userEsperado.getEmail());
            assertEquals(user.getPassword(), userEsperado.getPassword());

            i++;
        }
    }

    @Test
    void testUpdateUserId() {
        userDao.updateUser("5", 1, "fulanodetal@exemplo.com");
        User updatedUser = userDao.getUserById(5);
        assertEquals(5, updatedUser.getId());
        userDao.updateUser("1", 1, "fulanodetal@exemplo.com");
        updatedUser = userDao.getUserById(1);
        assertEquals(1, updatedUser.getId());
    }

    @Test
    void testUpdateUserName() {
        userDao.updateUser("NovoNome", 2, "fulanodetal@exemplo.com");
        User updatedUser = userDao.getUserById(1);
        assertEquals("NovoNome", updatedUser.getName());
        userDao.updateUser("João da Silva", 2, "fulanodetal@exemplo.com");
        updatedUser = userDao.getUserById(1);
        assertEquals("João da Silva", updatedUser.getName());
    }

    @Test
    void testUpdateUserEmail() {
        userDao.updateUser("novoteste@example.com", 3, "fulanodetal@exemplo.com");
        User updatedUser = userDao.getUserById(4);
        assertEquals("novoteste@example.com", updatedUser.getEmail());
        userDao.updateUser("fulanodetal@exemplo.com", 3, "novoteste@example.com");
        updatedUser = userDao.getUserById(4);
        assertEquals("fulanodetal@exemplo.com", updatedUser.getEmail());
    }

    @Test
    void testUpdateUserPassword() {
        userDao.updateUser("novasenha", 4, "fulanodetal@exemplo.com");
        User updatedUser = userDao.getUserById(4);
        assertEquals("novasenha", updatedUser.getPassword());
        userDao.updateUser("senhasegura", 4, "fulanodetal@exemplo.com");
        updatedUser = userDao.getUserById(4);
        assertEquals("senhasegura", updatedUser.getPassword());
    }

    @Test
    void testDeleteUser() {
        List<User> users = userDao.getAllUsers();
        for (int i = 0 ; i < 2; i++){
            if (users.size() == 3){
                userDao.deleteUser(1);
                List<User> usersTest = userDao.getAllUsers();
                assertEquals(2, usersTest.size());
            }else {
                userDao.saveUser(user1);
            }
        }
    }

}