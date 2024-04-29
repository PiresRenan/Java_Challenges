package org.validator;

public class PalindromeValidator {
    public static boolean isPalindrome(String input) {
        // Validação e conversão da entrada (remover espaços, minúsculas)
        String normalizedInput = normalizeInput(input);

        // Chamar o validador de palíndromo
        return PalindromeValidator.checkPalindrome(normalizedInput);
    }

    public static boolean checkPalindrome(String input) {
        // Verificar se a string é vazia ou nula
        if (input == null || input.isEmpty()) {
            return false;
        }

        // Converter a string para um array de caracteres
        char[] chars = input.toCharArray();

        // Comparar caracteres do início e do fim da string
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }

        // Se todos os caracteres forem iguais, é um palíndromo
        return true;
    }

    public static String normalizeInput(String input) {
        // Remover espaços em branco
        String normalizedInput = Utils.removeSpaces(input);

        // Converter para minúsculas
        normalizedInput = Utils.toLowerCase(normalizedInput);

        return normalizedInput;
    }

}
