package org.example.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.example.media.model.ListaNumeros;
import org.example.media.model.Numero;
import org.example.media.calculadora.CalculadoraMedia;


public class App {

    public static void main(String[] args) {

        ListaNumeros listaNumeros = new ListaNumeros();
        listaNumeros.addNumero(new Numero(10));
        listaNumeros.addNumero(new Numero(5));
        listaNumeros.addNumero(new Numero(30));


        CalculadoraMedia calculadoraMedia = new CalculadoraMedia(listaNumeros);
        double media = calculadoraMedia.calcularMedia();
        double mediana = calculadoraMedia.calcMediana();
        double moda = calculadoraMedia.calcModa();
        double varianca = calculadoraMedia.calcVarianca();
        double desvioPadro = calculadoraMedia.calcDesvioPadrao();

        System.out.println("\nResultados das estatísticas:");
        System.out.println("Média: " + media);
        System.out.println("Mediana: " + mediana);
        System.out.println("Moda: " + moda);
        System.out.println("Variância: " + varianca);
        System.out.println("Desvio Padrão: " + desvioPadro);
    }
}