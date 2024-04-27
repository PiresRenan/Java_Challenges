package main.com.calculator.app;

import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculadora {

    public double obterNumero(Scanner sc, String mensagem) {
        System.out.println(mensagem);
        try {
            String input = sc.next();
            if (input.equalsIgnoreCase("sair")) {
                return Double.MIN_VALUE;
            }
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Por favor, insira um número válido.");
            return obterNumero(sc, mensagem);
        }
    }

    public double soma(double a, double b) { return arredondar(a + b); }
    public double subtracao(double a, double b) { return arredondar(a - b); }
    public double multiplicacao(double a, double b) { return arredondar(a * b); }
    public double divisao(double a, double b) { return arredondar(a / b); }

    private double arredondar(double numero) {
        BigDecimal bd = new BigDecimal(Double.toString(numero));
        bd = bd.setScale(3, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}

