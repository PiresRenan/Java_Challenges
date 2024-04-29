package org.ordenador;

import java.util.Collections;
import java.util.List;

public class RadixSort implements AlgoritmoOrdenacao {

    @Override
    public void ordenar(List<Integer> lista) {
        if (lista.isEmpty()) return;
        int max = Collections.max(lista);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(lista, exp);
        }
    }

    private void countingSort(List<Integer> lista, int exp) {
        int n = lista.size();
        int[] saida = new int[n];
        int[] contador = new int[10];

        for (int i = 0; i < n; i++) {
            contador[(lista.get(i) / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            contador[i] += contador[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            saida[contador[(lista.get(i) / exp) % 10] - 1] = lista.get(i);
            contador[(lista.get(i) / exp) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            lista.set(i, saida[i]);
        }
    }
}

