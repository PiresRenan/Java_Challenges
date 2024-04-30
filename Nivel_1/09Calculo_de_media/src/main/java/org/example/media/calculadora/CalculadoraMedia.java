package org.example.media.calculadora;

import org.example.media.model.ListaNumeros;

public class CalculadoraMedia {

    private final ListaNumeros numeros;

    public CalculadoraMedia(ListaNumeros numeros) {
        this.numeros = numeros;
    }
    public double calcularMedia() {
        return Estatisticas.calcularMedia(numeros);
    }
    public double calcMediana(){
        return Estatisticas.calcularMediana(numeros);
    }
    public double calcModa(){
        return Estatisticas.calcularModa(numeros).getValor();
    }
    public double calcVarianca(){
        return Estatisticas.calcularVarianca(numeros);
    }
    public double calcDesvioPadrao(){
        return Estatisticas.calcularDesvioPadrao(numeros);
    }

}
