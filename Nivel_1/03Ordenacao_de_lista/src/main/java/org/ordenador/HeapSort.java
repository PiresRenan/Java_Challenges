package org.ordenador;

import java.util.List;

public class HeapSort implements AlgoritmoOrdenacao {

    @Override
    public void ordenar(List<Integer> lista) {
        int tamanho = lista.size();

        for (int i = tamanho / 2 - 1; i >= 0; i--) {
            heapify(lista, tamanho, i);
        }

        for (int i = tamanho - 1; i > 0; i--) {

            int temp = lista.get(0);
            lista.set(0, lista.get(i));
            lista.set(i, temp);

            heapify(lista, i, 0);
        }
    }

    private void heapify(List<Integer> lista, int tamanho, int indiceRaiz) {
        int maior = indiceRaiz; // Inicializa o maior como raiz
        int filhoEsquerda = 2 * indiceRaiz + 1;
        int filhoDireita = 2 * indiceRaiz + 2;

        if (filhoEsquerda < tamanho && lista.get(filhoEsquerda) > lista.get(maior)) {
            maior = filhoEsquerda;
        }

        if (filhoDireita < tamanho && lista.get(filhoDireita) > lista.get(maior)) {
            maior = filhoDireita;
        }

        if (maior != indiceRaiz) {
            int troca = lista.get(indiceRaiz);
            lista.set(indiceRaiz, lista.get(maior));
            lista.set(maior, troca);

            heapify(lista, tamanho, maior);
        }
    }
}
