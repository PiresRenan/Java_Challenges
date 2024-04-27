package main.com.calculator.app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculadora calculator = new Calculadora();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo à Calculadora! Digite 'sair' a qualquer momento para encerrar!");
        while (true){

            double numero_1 = calculator.obterNumero(scanner, "Digite o primeiro numero:");
            if (numero_1 == Double.MIN_VALUE) break;

            double numero_2 = calculator.obterNumero(scanner, "Digite o segundo numero:");
            if (numero_2 == Double.MIN_VALUE) break;

            System.out.println("Escolha a operação:");
            System.out.println("1. Soma");
            System.out.println("2. Subtração");
            System.out.println("3. Multiplicação");
            System.out.println("4. Divisão");
            System.out.println("Digite 'sair' para encerrar.");

            String operacao = scanner.next();
            double resultado = 0;

            switch (operacao) {
                case "1":
                    resultado = calculator.soma(numero_1, numero_2);
                    break;
                case "2":
                    resultado = calculator.subtracao(numero_1, numero_2);
                    break;
                case "3":
                    resultado = calculator.multiplicacao(numero_1, numero_2);
                    break;
                case "4":
                    resultado = calculator.divisao(numero_1, numero_2);
                    break;
                case "sair":
                    System.out.println("Encerrando a Calculadora.");
                    break;
                default:
                    System.out.println("Operação inválida!");
            }

            System.out.println("Resultado: " + resultado);
        }

    }
}
