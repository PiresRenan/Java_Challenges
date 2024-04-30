package org.example.buscador.searchEngine;

import org.example.buscador.model.Item;

import java.util.ArrayList;
import java.util.List;

public class Filtro {

    public Filtro(){}

    public List<Item> filtrarPorNome(List<Item> listaItens, String termo) {
        List<Item> resultados = new ArrayList<>();
        for (Item item : listaItens) {
            if (item.getNome().toLowerCase().contains(termo.toLowerCase())) {
                resultados.add(item);
            }
        }
        return resultados;
    }

    public List<Item> filtrarPorDescricao(List<Item> listaItens, String termo) {
        List<Item> resultados = new ArrayList<>();
        for (Item item : listaItens) {
            if (item.getDescricao().toLowerCase().contains(termo.toLowerCase())) {
                resultados.add(item);
            }
        }
        return resultados;
    }

    public List<Item> filtrarPorPreco(List<Item> listaItens, double precoMin, double precoMax) {
        List<Item> resultados = new ArrayList<>();
        for (Item item : listaItens) {
            if (item.getPreco() >= precoMin && item.getPreco() <= precoMax) {
                resultados.add(item);
            }
        }
        return resultados;
    }
}
