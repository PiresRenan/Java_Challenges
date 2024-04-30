package org.example.buscador.model;

public class Item {

    private String nome;
    private String descricao;
    private double preco;

    public Item(String nome, String descricao, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }
//    Getters
    public String getNome() { return nome; }

    public String getDescricao() { return descricao; }

    public double getPreco() { return preco; }

//    Setters

    public void setNome(String nome) { this.nome = nome; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public void setPreco(double preco) { this.preco = preco; }

//    toString
    @Override
    public String toString() {
        return "Item{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }
}
