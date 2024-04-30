package org.example.auth.domain;

import java.util.Objects;
import java.util.Set;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private Set<Permissao> permissoes;

    public Usuario() {}

    public Usuario(String nome, String email, String senha, Set<Permissao> permissoes) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.permissoes = permissoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(Set<Permissao> permissoes) {
        this.permissoes = permissoes;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nome, usuario.nome) && Objects.equals(email, usuario.email) && Objects.equals(senha, usuario.senha) && Objects.equals(permissoes, usuario.permissoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, email, senha, permissoes);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", permissoes=" + permissoes +
                '}';
    }
}
