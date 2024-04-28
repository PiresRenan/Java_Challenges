package org.ordenador;

import java.util.List;

public class ShellSort implements AlgoritmoOrdenacao {

    @Override
    public void ordenar(List<Integer> lista) {
        int tamanho = lista.size();
        int intervalo = tamanho / 2;

        while (intervalo > 0) {
            for (int i = intervalo; i < tamanho; i++) {
                int chave = lista.get(i);
                int j = i;

                while (j >= intervalo && lista.get(j - intervalo) > chave) {
                    lista.set(j, lista.get(j - intervalo));
                    j = j - intervalo;
                }
                lista.set(j, chave);
            }
            intervalo = intervalo / 2;
        }
    }
}
