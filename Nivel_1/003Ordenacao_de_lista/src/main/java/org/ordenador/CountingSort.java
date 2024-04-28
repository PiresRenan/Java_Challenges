package org.ordenador;

import java.util.List;

public class CountingSort implements AlgoritmoOrdenacao {

    @Override
    public void ordenar(List<Integer> lista) {
        if (lista.isEmpty()) return;

        int maximo = lista.get(0);
        int minimo = lista.get(0);
        for (int num : lista) {
            if (num > maximo) {
                maximo = num;
            }
            if (num < minimo) {
                minimo = num;
            }
        }

        int[] contagem = new int[maximo - minimo + 1];

        for (int num : lista) {
            contagem[num - minimo]++;
        }

        int indice = 0;
        for (int i = minimo; i <= maximo; i++) {
            while (contagem[i - minimo] > 0) {
                lista.set(indice++, i);
                contagem[i - minimo]--;
            }
        }
    }
}
