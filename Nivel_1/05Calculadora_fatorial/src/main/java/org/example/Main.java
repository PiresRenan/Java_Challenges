package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Digite um número inteiro não negativo (ou 'sair' para finalizar): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("sair")) {
                System.out.println("Programa finalizado.");
                break;
            }

            int number;
            try {
                number = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                continue;
            }

            FactorialValidator validator = new FactorialValidator();
            if (!validator.isValidNumber(number)) {
                System.out.println("Número inválido. Digite um número inteiro não negativo.");
                continue;
            }

            FactorialCalculator calculator = new FactorialCalculator();
            long factorial = calculator.calculateFactorial(number);
            System.out.println("Fatorial de " + number + ": " + factorial);
        }
        scanner.close();
    }
}