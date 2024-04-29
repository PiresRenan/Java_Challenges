package org.ordenador;

import java.util.List;

public class QuickSort implements AlgoritmoOrdenacao {

    @Override
    public void ordenar(List<Integer> lista) {
        quickSort(lista, 0, lista.size() - 1);
    }

    private void quickSort(List<Integer> lista, int inicio, int fim) {
        if (inicio < fim) {
            int pivoIndex = particionar(lista, inicio, fim);
            quickSort(lista, inicio, pivoIndex - 1);
            quickSort(lista, pivoIndex + 1, fim);
        }
    }

    private int particionar(List<Integer> lista, int inicio, int fim) {
        int pivo = lista.get(fim);
        int i = inicio - 1;
        for (int j = inicio; j < fim; j++) {
            if (lista.get(j) < pivo) {
                i++;
                trocar(lista, i, j);
            }
        }
        trocar(lista, i + 1, fim);
        return i + 1;
    }

    private void trocar(List<Integer> lista, int i, int j) {
        int temp = lista.get(i);
        lista.set(i, lista.get(j));
        lista.set(j, temp);
    }
}

