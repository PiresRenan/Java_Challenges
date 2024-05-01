package org.example.crud.usuarios.model;

import java.io.Serial;
import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Objects;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String email;
    private String password;


    public User() {}

    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");
        this.name = name;
    }

    public void setEmail(String email) {
        if (email == null || email.isEmpty()) throw new IllegalArgumentException("Email cannot be null or empty");
        this.email = email;
    }

    public void setPassword(String password) {
        if (password == null || password.isEmpty()) throw new IllegalArgumentException("Password cannot be null or empty");
        if (password.length() < 8) throw new IllegalArgumentException("Password must be at least 8 characters long");
        this.password = hashPassword(password);
    }

    public static String hashPassword(String password) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    public boolean verifyPassword(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }
        return BCrypt.checkpw(password, this.password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getEmail(), user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail());
    }


    @Override
    public String toString() {
        return "Usuario: id= " + id + ", name= " + name + ", email= " + email + ", password= " + password;
    }
}