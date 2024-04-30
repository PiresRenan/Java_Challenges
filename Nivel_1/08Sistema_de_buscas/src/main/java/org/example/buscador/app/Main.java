package org.example.buscador.app;

import org.example.buscador.model.Item;
import org.example.buscador.searchEngine.Buscador;
import org.example.buscador.searchEngine.Filtro;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Item> itens = new ArrayList<>();
        itens.add(new Item("Produto 1", "Descrição do Produto 1", 10.0));
        itens.add(new Item("Produto 2", "Descrição do Produto 2", 15.0));
        itens.add(new Item("Produto 3", "Descrição do Produto 3", 20.0));
        itens.add(new Item("Produto 4", "Descrição do Produto 4", 25.0));

        Buscador buscador = new Buscador(itens);

        System.out.println("Lista de Itens Disponíveis:");
        for (Item item : itens) {
            System.out.println(item);
        }

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Buscar por nome");
            System.out.println("2. Buscar por descrição");
            System.out.println("3. Buscar por preço");
            System.out.println("4. Sair");

            int opcao = 0;
            boolean cont = true;
            while (cont) {
                try {
                    System.out.println("Digite uma opção (1 a 4):");
                    opcao = scanner.nextInt();
                    if (opcao >= 1 && opcao <= 4) {
                        cont = false;
                    } else {
                        System.err.println("Opção inválida! Digite um número entre 1 e 4.");
                    }
                } catch (Exception e) {
                    System.err.println("Opção inválida! Digite um número entre 1 e 4.");
                    scanner.nextLine(); // Limpa o buffer do scanner
                }
            }

            if(opcao != 4) {
                try {
                    List<Item> resultado = buscador.buscar(opcao);
                    imprimirResultado(resultado);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }else {
                continuar = false;
            }
        }
    }

    private static void imprimirResultado(List<Item> resultado) {
        if (resultado.isEmpty()) {
            System.out.println("Nenhum item encontrado.");
        } else {
            System.out.println("Resultados da busca:");
            for (Item item : resultado) {
                System.out.println(item);
            }
        }
    }
}
