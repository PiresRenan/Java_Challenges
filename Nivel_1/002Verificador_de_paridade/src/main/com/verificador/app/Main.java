package main.com.verificador.app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao Verificador de Paridade!");

        while (true) {
            System.out.println("Digite um número inteiro (ou 'sair' para encerrar):");
            String input = scanner.next();

            if (input.equalsIgnoreCase("sair")) {
                System.out.println("Encerrando o Verificador de Paridade. Até logo!");
                break;
            }

            try {
                int numero = Integer.parseInt(input);
                if (VerificadorPariedade.verificarParidade(numero)) {
                    System.out.println(numero + " é um número par.\n");
                } else {
                    System.out.println(numero + " é um número ímpar.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira um número inteiro válido.");
            }
        }
        scanner.close();
    }
}