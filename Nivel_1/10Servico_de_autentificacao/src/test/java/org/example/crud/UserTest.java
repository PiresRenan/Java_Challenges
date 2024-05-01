package org.example.crud;

import org.example.crud.usuarios.model.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testUserCreation() {
        int id = 1;
        String name = "John Doe";
        String email = "john.doe@example.com";
        String password = "secretpassword";

        User user = new User(id, name, email, password);

        assertEquals(id, user.getId());
        assertEquals(name, user.getName());
        assertEquals(email, user.getEmail());
        assertEquals(password, user.getPassword());
    }

    @Test
    public void testSetNameValidation() {
        User user = new User();

        assertThrows(IllegalArgumentException.class, () -> user.setName(null));
        assertThrows(IllegalArgumentException.class, () -> user.setName(""));
    }

    @Test
    public void testSetEmailValidation() {
        User user = new User();

        assertThrows(IllegalArgumentException.class, () -> user.setEmail(null));
        assertThrows(IllegalArgumentException.class, () -> user.setEmail(""));
    }

    @Test
    public void testSetPasswordValidation() {
        User user = new User();

        assertThrows(IllegalArgumentException.class, () -> user.setPassword(null));
        assertThrows(IllegalArgumentException.class, () -> user.setPassword(""));
        assertThrows(IllegalArgumentException.class, () -> user.setPassword("short"));
    }

}