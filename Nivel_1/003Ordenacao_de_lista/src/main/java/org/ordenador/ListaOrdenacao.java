package org.ordenador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaOrdenacao {
    private List<Integer> lista;

    public ListaOrdenacao() {
        this.lista = new ArrayList<>();
    }

    public void lerEntrada() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite os números inteiros separados por espaço ou vírgula: ");
        String entrada = sc.nextLine().replaceAll("[^0-9, ]", "");

        if (entrada.trim().isEmpty()) {
            System.out.println("Nenhum número fornecido. Por favor, tente novamente.");
            return;
        }

        String[] numeros = entrada.split("[,\\s]+");
        System.out.println("Foram fornecidos " + numeros.length + " números.");
        for (String numero : numeros) {
            try {
                lista.add(Integer.parseInt(numero));
            } catch (NumberFormatException e) {
                System.out.println("Erro ao converter número: " + numero + ". Ignorando...");
            }
        }
    }

    public void ordenarLista(AlgoritmoOrdenacao algoritmo){
        algoritmo.ordenar(lista);
    }

    public void imprimirLista() {
        System.out.println("Lista ordenada: " + lista + "\n");
    }

    public List<Integer> getLista() {
        return lista;
    }

}
