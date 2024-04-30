package org.example.buscador.searchEngine;

import org.example.buscador.model.Item;

import java.util.List;
import java.util.Scanner;

public class Buscador {

    private List<Item> listaItens;
    private Filtro filtro;
    private Scanner scanner;

    public Buscador(List<Item> listaItens) {
        this.filtro = new Filtro();
        this.listaItens = listaItens;
    }

    public List<Item> buscar(int filtragem) {
        List<Item> item_filtrado = null;
        scanner = new Scanner(System.in);
        switch (filtragem) {
            case 1:
                System.out.println("Digite o nome a ser buscado:");
                String nome = scanner.nextLine();
                item_filtrado = filtro.filtrarPorNome(listaItens, nome);
                break;
            case 2:
                System.out.println("Digite a descrição a ser buscada:");
                String descricao = scanner.nextLine();
                item_filtrado = filtro.filtrarPorDescricao(listaItens, descricao);
                break;
            case 3:
                System.out.println("Digite o preço mínimo:");
                double precoMin = scanner.nextDouble();
                System.out.println("Digite o preço máximo:");
                double precoMax = scanner.nextDouble();
                item_filtrado = filtro.filtrarPorPreco(listaItens, precoMin, precoMax);
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");

        }
        return item_filtrado;
    }

    public List<Item> buscar_por_preco(double precoMin, double precoMax) {
        return filtro.filtrarPorPreco(listaItens, precoMin, precoMax);
    }
}
