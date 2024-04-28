package org.ordenador;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements AlgoritmoOrdenacao {

    @Override
    public void ordenar(List<Integer> lista) {
        mergeSort(lista, lista.size());
    }

    public void mergeSort(List<Integer> lista, int tamanho_lista) {
        if (tamanho_lista < 2) return;

        int meio = tamanho_lista / 2;

        List<Integer> esquerda = new ArrayList<>(lista.subList(0, meio));
        List<Integer> direita = new ArrayList<>(lista.subList(meio, tamanho_lista));

        mergeSort(esquerda, meio);
        mergeSort(direita, tamanho_lista - meio);

        merge(lista, esquerda, direita);
    }

    private void merge(List<Integer> lista, List<Integer> esquerda, List<Integer> direita) {
        int i = 0, j = 0, k = 0;
        while (i < esquerda.size() && j < direita.size()) {
            if (esquerda.get(i) <= direita.get(j)) {
                lista.set(k++, esquerda.get(i++));
            } else {
                lista.set(k++, direita.get(j++));
            }
        }
        while (i < esquerda.size()) {
            lista.set(k++, esquerda.get(i++));
        }
        while (j < direita.size()) {
            lista.set(k++, direita.get(j++));
        }
    }

}