package org.ordenador;

import java.util.List;

public class InsertionSort implements AlgoritmoOrdenacao {

    @Override
    public void ordenar(List<Integer> lista) {
        for (int i = 1; i < lista.size(); i++) {
            int chave = lista.get(i);
            int j = i - 1;

            while (j >= 0 && lista.get(j) > chave) {
                lista.set(j + 1, lista.get(j));
                j = j - 1;
            }
            lista.set(j + 1, chave);
        }
    }
}
