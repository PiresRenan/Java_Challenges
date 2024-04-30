package com.example.auth;

import org.example.auth.domain.Usuario;
import org.example.auth.exceptions.AuthException;
import org.example.auth.repositories.UserRepository;
import org.example.auth.services.AuthService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class AuthServiceTest {

    @Mock
    private UserRepository userRepositoryMock;

    private AuthService authService;

    @BeforeEach
    public void setUp() {
        authService = new AuthService(userRepository);
    }

    @Test
    public void testRegistrarUsuarioComSucesso() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setEmail("teste@email.com");
        usuario.setSenha("Senha123");

        Mockito.when(userRepositoryMock.salvar(usuario)).thenReturn(null);

        authService.registrarUsuario(usuario);

        Mockito.verify(userRepositoryMock).salvar(usuario);
    }

//    @Test
//    public void testRegistrarUsuarioComEmailInvalido() {
//        // Criar um usuário com email inválido
//        Usuario usuario = new Usuario();
//        usuario.setEmail("invalido@email");
//        usuario.setSenha("Senha123");
//
//        // Tentar registrar o usuário
//        assertThrows(AuthException.class, () -> authService.registrarUsuario(usuario));
//
//        // Verificar se o UserRepository não foi chamado
//        Mockito.verify(userRepositoryMock, Mockito.never()).salvarUsuario(usuario);
//    }
//
//    @Test
//    public void testRegistrarUsuarioComSenhaInvalida() {
//        // Criar um usuário com senha inválida
//        Usuario usuario = new Usuario();
//        usuario.setEmail("teste@email.com");
//        usuario.setSenha(""); // Senha vazia
//
//        // Tentar registrar o usuário
//        assertThrows(AuthException.class, () -> authService.registrarUsuario(usuario));
//
//        // Verificar se o UserRepository não foi chamado
//        Mockito.verify(userRepositoryMock, Mockito.never()).salvarUsuario(usuario);
//    }
//
//    @Test
//    public void testAutenticarUsuarioComSucesso() throws Exception {
//        // Criar um usuário de teste
//        Usuario usuario = new Usuario();
//        usuario.setEmail("teste@email.com");
//        usuario.setSenha("Senha123");
//
//        // Configurar o mock do UserRepository para retornar o usuário ao buscar por email
//        Mockito.when(userRepositoryMock.buscarUsuarioPorEmail("teste@email.com")).thenReturn(usuario);
//
//        // Autenticar o usuário
//        Usuario usuarioAutenticado = authService.autenticarUsuario("teste@email.com", "Senha123");
//
//        // Verificar se o usuário autenticado é o mesmo que o usuário de teste
//        assertEquals(usuario, usuarioAutenticado);
//
//        // Verificar se o UserRepository foi chamado para buscar o usuário
//        Mockito.verify(userRepositoryMock).buscarUsuarioPorEmail("teste@email.com");
//    }
//
//    @Test
//    public void testAutenticarUsuarioComEmailInvalido() {
//        // Tentar autenticar com email inválido
//        assertThrows(AuthException.class, () -> authService.autenticarUsuario("invalido@email", "Senha123"));
//
//        // Verificar se o UserRepository não foi chamado
//        Mockito.verify(userRepositoryMock, Mockito.never()).buscarUsuarioPorEmail(anyString());
//    }
//    @Test
//    public void testAutenticarUsuarioComSenhaIncorreta() throws Exception {
//        // Criar um usuário de teste
//        Usuario usuario = new Usuario();
//        usuario.setEmail("teste@email.com");
//        usuario.setSenha("Senha123");
//
//        // Configurar o mock do UserRepository para retornar o usuário ao buscar por email
//        Mockito.when(userRepositoryMock.buscarUsuarioPorEmail("teste@email.com")).thenReturn(usuario);
//
//        // Tentar autenticar com senha incorreta
//        assertThrows(AuthException.class, () -> authService.autenticarUsuario("teste@email.com", "SenhaErrada"));
//
//        // Verificar se o UserRepository foi chamado para buscar o usuário
//        Mockito.verify(userRepositoryMock).buscarUsuarioPorEmail("teste@email.com");
//    }
//    @Test
//    public void testRegistrarUsuarioComErroNoBancoDeDados() {
//        // Criar um usuário de teste
//        Usuario usuario = new Usuario();
//        usuario.setEmail("teste@email.com");
//        usuario.setSenha("Senha123");
//
//        // Configurar o mock do UserRepository para lançar uma exceção ao salvar o usuário
//        Mockito.when(userRepositoryMock.salvarUsuario(usuario)).thenThrow(new RuntimeException("Erro no banco de dados"));
//
//        // Tentar registrar o usuário
//        assertThrows(Exception.class, () -> authService.registrarUsuario(usuario));
//
//        // Verificar se o UserRepository foi chamado para salvar o usuário
//        Mockito.verify(userRepositoryMock).salvarUsuario(usuario);
//    }
//    @Test
//    public void testAutenticarUsuarioComUsuarioNaoEncontrado() {
//        // Tentar autenticar com um email inexistente
//        assertThrows(AuthException.class, () -> authService.autenticarUsuario("naoexiste@email.com", "Senha123"));
//
//        // Verificar se o UserRepository foi chamado para buscar o usuário
//        Mockito.verify(userRepositoryMock).buscarUsuarioPorEmail("naoexiste@email.com");
//    }
}
