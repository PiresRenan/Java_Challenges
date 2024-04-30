package org.example.auth.services;

import org.example.auth.domain.Usuario;
import org.example.auth.exceptions.AuthException;
import org.example.auth.repositories.UserRepository;

public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registrarUsuario(Usuario usuario) throws AuthException {
        // 1. Validate user data (email, password, etc.)
        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new AuthException("Email do usuário não pode ser vazio.");
        }

        if (!isValidEmail(usuario.getEmail())) {
            throw new AuthException("Email do usuário inválido.");
        }

        if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
            throw new AuthException("Senha do usuário não pode ser vazia.");
        }


        // 2. Save user to the database
        try {
            userRepository.salvar(usuario);
        } catch (Exception e) {
            throw new AuthException("Erro ao salvar usuário: " + e.getMessage());
        }

        // 3. Handle successful registration (optional)
        System.out.println("Usuário registrado com sucesso!");
    }


    public Usuario autenticarUsuario(String email, String senha) throws AuthException {
        // 1. Fetch user from the database by email
        Usuario usuario = userRepository.buscarPorEmail(email);

        // 2. Check if the user exists
        if (usuario == null) {
            throw new AuthException("Usuário não encontrado.");
        }

        // 3. Verify the password
        if (!verificarSenha(usuario.getSenha(), senha)) {
            throw new AuthException("Senha incorreta.");
        }

        // 4. Return the authenticated user
        return usuario;
    }

    private boolean isValidEmail(String email) {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,}$";
        return email.matches(regex);
    }

    private boolean verificarSenha(String senhaArmazenada, String senhaInformada) {
        return senhaArmazenada.equals(senhaInformada);
    }

}
