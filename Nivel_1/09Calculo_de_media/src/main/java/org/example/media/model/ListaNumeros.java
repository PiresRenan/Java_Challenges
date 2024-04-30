package org.example.media.model;

import java.util.ArrayList;
import java.util.List;

public class ListaNumeros {

    private List<Numero> numeros;

    public ListaNumeros() {
        this.numeros = new ArrayList<>();
    }

    public ListaNumeros(List<Numero> numerosInicial) {
        this.numeros = numerosInicial;
    }

    public void addNumero(Numero numero) {
        this.numeros.add(numero);
    }

    public void removeNumero(Numero numero) { this.numeros.remove(numero); }

    public double obterMedia(){
        if (numeros.isEmpty()){
            throw new RuntimeException("A lista está vazia!");
        }
        double soma = 0;
        for (Numero numero : numeros){
            soma += numero.getValor();
        }
        return soma/numeros.size();
    }

    public int getTamanho(){
        return numeros.size();
    }

    public List<Numero> getNumeros() {
        return new ArrayList<>(numeros);
    }

    public boolean containsCustom(Numero numero) {
        for (Numero elemento : numeros) {
            if (elemento.equals(numero)) {
                return true;
            }
        }
        return false;
    }

}
