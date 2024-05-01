package org.example.crud.usuarios.model;


public class User {

    private int id;
    private String name;
    private String email;
    private String password;

    public User() {}

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

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

    // Setters
    public void setId(int id) {
        this.id = id;
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
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario: id= " + id + ", name= " + name + ", email= " + email + ", password= " + password;
    }
}