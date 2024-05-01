package org.example.auth;

import org.example.auth.service.AuthService;
import org.example.auth.service.AuthServiceImpl;
import org.example.crud.usuarios.model.User;
import org.example.crud.usuarios.repository.UserDAO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AuthServiceImplTest {
    @Mock
    private UserDAO userDAO;

    private AuthService authService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        authService = new AuthServiceImpl(userDAO);
    }

    @Test
    void testAuthenticate_Success() {
        // Mock de um usuário existente no banco de dados
        User mockUser = new User("username", "teste@teste.com", "password");
        when(userDAO.getUserByEmail("teste@teste.com")).thenReturn(mockUser);

        // Tentativa de autenticação
        User authenticatedUser = authService.authenticate("teste@teste.com", "password");

        // Verifica se a autenticação foi bem-sucedida
        assertNotNull(authenticatedUser);
        assertEquals(mockUser, authenticatedUser);
    }

    @Test
    void testAuthenticate_Failure() {
        // Mock de um usuário inexistente no banco de dados
        when(userDAO.getUserByEmail("username")).thenReturn(null);

        // Tentativa de autenticação com credenciais inválidas
        User authenticatedUser = authService.authenticate("username", "password");

        // Verifica se a autenticação falhou
        assertNull(authenticatedUser);
    }
}
