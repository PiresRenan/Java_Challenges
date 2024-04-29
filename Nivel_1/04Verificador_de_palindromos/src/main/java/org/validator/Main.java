package org.validator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Digite uma palavra ('sair' ou 'exit' para encerrar): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("sair") || input.equalsIgnoreCase("exit")) {
                System.out.println("Deseja realmente sair? (S/N)");
                String confirmation = scanner.nextLine();
                if (confirmation.equalsIgnoreCase("s") || confirmation.equalsIgnoreCase("sim")) {
                    break;
                }
            }
            String result = PalindromeValidator.isPalindrome(input) ? "palíndromo" : "NÃO é palíndromo";
            System.out.println(input + " é " + result);
        }

        scanner.close();
    }
}