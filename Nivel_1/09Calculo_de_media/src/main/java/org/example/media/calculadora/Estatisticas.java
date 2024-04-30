package org.example.media.calculadora;

import org.example.media.model.ListaNumeros;
import org.example.media.model.Numero;

import java.util.*;

public class Estatisticas {

    public static double calcularMedia(ListaNumeros listaNumeros){
        if (listaNumeros.getTamanho() == 0){
            throw new RuntimeException("A lista está vazia!");
        }
        double soma = 0;
        for (Numero numero : listaNumeros.getNumeros()){
            soma += numero.getValor();
        }
        return soma / listaNumeros.getTamanho();
    }

    public static double calcularMediana(ListaNumeros numeros) {
        if (numeros.getTamanho() == 0) {
            throw new RuntimeException("A lista está vazia!");
        }

        Collections.sort(numeros.getNumeros());

        int indiceMediana = numeros.getTamanho() / 2;
        if (numeros.getTamanho() % 2 == 0) {
            return (numeros.getNumeros().get(indiceMediana - 1).getValor() + numeros.getNumeros().get(indiceMediana).getValor()) / 2;
        } else {
            return numeros.getNumeros().get(indiceMediana).getValor();
        }
    }

    public static Numero calcularModa(ListaNumeros numeros) {
        if (numeros.getTamanho() == 0) {
            throw new RuntimeException("A lista está vazia!");
        }

        Map<Numero, Integer> contagemValores = new HashMap<>();
        for (Numero numero : numeros.getNumeros()) {
            int count = contagemValores.getOrDefault(numero, 0);
            contagemValores.put(numero, count + 1);
        }

        Numero moda = null;
        int maxCount = 0;
        for (Map.Entry<Numero, Integer> entry : contagemValores.entrySet()) {
            int count = entry.getValue();
            if (count > maxCount) {
                maxCount = count;
                moda = entry.getKey();
            }
        }
        return moda;
    }

    public static double calcularVarianca(ListaNumeros numeros) {
        if (numeros.getTamanho() == 0) {
            throw new RuntimeException("A lista está vazia!");
        }

        double media = calcularMedia(numeros);
        double somaDesviosQuadrados = 0;
        for (Numero numero : numeros.getNumeros()) {
            double desvio = numero.getValor() - media;
            somaDesviosQuadrados += desvio * desvio;
        }

        return somaDesviosQuadrados / numeros.getTamanho(); // Dividir por N
    }

    public static double calcularDesvioPadrao(ListaNumeros numeros) {
        double varianca = calcularVarianca(numeros);
        return Math.sqrt(varianca);
    }
}
