package org.example.buscador;

import org.example.buscador.model.Item;
import org.example.buscador.searchEngine.Buscador;

import org.example.buscador.searchEngine.Filtro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuscadorTest {

    private List<Item> itens;

    @BeforeEach
    void setUp(){
        itens = new ArrayList<>();
        itens.add(new Item("Produto 1", "Descrição do Produto 1", 10.0));
        itens.add(new Item("Produto 2", "Descrição do Produto 2", 15.0));
        itens.add(new Item("Produto 3", "Descrição do Produto 3", 20.0));
        itens.add(new Item("Produto 4", "Descrição do Produto 4", 25.0));
    }

    @Test
    void testeBuscaPorNome() {
        // Teste de busca por nome
        Filtro buscador = new Filtro();
        List<Item> resultado = buscador.filtrarPorNome(itens, "Produto 3");
        assertEquals(1, resultado.size());
        assertEquals("Produto 3", resultado.get(0).getNome());
    }

    @Test
    void testeBuscaPorDescricao() {
        // Teste de busca por descrição
        Filtro buscador = new Filtro();
        List<Item> resultado = buscador.filtrarPorDescricao(itens, "Descrição do Produto 2");
        assertEquals(1, resultado.size());
        assertEquals("Produto 2", resultado.get(0).getNome());
    }

    @Test
    void testeBuscaPorPreco() {
        Filtro buscador = new Filtro();
        List<Item> resultado = buscador.filtrarPorPreco(itens, 25.0, 50.0);
        assertEquals(1, resultado.size());
        assertEquals(itens.get(3), resultado.get(0));
    }
}
