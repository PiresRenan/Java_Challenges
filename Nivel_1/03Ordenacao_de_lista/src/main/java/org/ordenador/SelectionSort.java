package org.ordenador;

import java.util.List;

public class SelectionSort implements AlgoritmoOrdenacao {

    @Override
    public void ordenar(List<Integer> lista) {
        int tamanho = lista.size();

        for (int i = 0; i < tamanho - 1; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < tamanho; j++) {
                if (lista.get(j) < lista.get(indiceMenor)) {
                    indiceMenor = j;
                }
            }

            int temp = lista.get(indiceMenor);
            lista.set(indiceMenor, lista.get(i));
            lista.set(i, temp);
        }
    }
}

