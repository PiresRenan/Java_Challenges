//package org.example.auth.repositories;
//
//import org.example.auth.domain.Usuario;
//import org.example.auth.repositories.UserRepository;
//import java.util.HashMap;
//import java.util.Map;
//
//public class UserRepositoryImpl implements UserRepository {
//
//    private final Map<String, Usuario> usuarios = new HashMap<>();
//
//    @Override
//    public void salvar(Usuario usuario) {
//        usuarios.put(usuario.getEmail(), usuario);
//    }
//
//    @Override
//    public Usuario buscarPorEmail(String email) {
//        return usuarios.get(email);
//    }
//
//}
