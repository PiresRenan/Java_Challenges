import org.validator.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class IsPalindromeTest {

    @Test
    public void testEmptyInput() {
        String input = "";
        boolean result = PalindromeValidator.isPalindrome(input);
        assertFalse(result); // Verificar se o resultado é falso para string vazia
    }

    @Test
    public void testSingleCharacterPalindrome() {
        String input = "a";
        boolean result = PalindromeValidator.isPalindrome(input);
        assertTrue(result); // Verificar se o resultado é verdadeiro para palíndromo de um caractere
    }

    @Test
    public void testEvenLengthPalindrome() {
        String input = "abba";
        boolean result = PalindromeValidator.isPalindrome(input);
        assertTrue(result); // Verificar se o resultado é verdadeiro para palíndromo de tamanho par
    }

    @Test
    public void testOddLengthPalindrome() {
        String input = "racecar";
        boolean result = PalindromeValidator.isPalindrome(input);
        assertTrue(result); // Verificar se o resultado é verdadeiro para palíndromo de tamanho ímpar
    }

    @Test
    public void testNotPalindrome() {
        String input = "banana";
        boolean result = PalindromeValidator.isPalindrome(input);
        assertFalse(result); // Verificar se o resultado é falso para string não palíndromo
    }

    @Test
    public void testRemoveSpacesSimpleSpaces() {
        // Teste com espaços simples
        String input = "This is a string";
        String expected = "Thisisastring";
        String result = Utils.removeSpaces(input);
        assertEquals(expected, result);
    }

    @Test
    public void testRemoveSpacesMultipleSpaces() {
        // Teste com múltiplos espaços consecutivos
        String input = "This  has  multiple  spaces";
        String expected = "Thishasmultiplespaces";
        String result = Utils.removeSpaces(input);
        assertEquals(expected, result);
    }

    @Test
    public void testRemoveInInitAndEndSpaces() {
        // Teste com espaços no inicio e no fim
        String input = "  Trim these spaces  ";
        String expected = "Trimthesespaces";
        String result = Utils.removeSpaces(input);
        assertEquals(expected, result);
    }

    @Test
    public void testRemoveSpacesToEmptyStrings() {
        // Teste com múltiplos espaços consecutivos
        String input = "";
        String expected = "";
        String result = Utils.removeSpaces(input);
        assertEquals(expected, result);
    }

    @Test
    public void testToLowerCaseAllLettersUppercase() {
        // Teste com string maiúscula
        String input = "THIS IS ALL UPPERCASE";
        String expected = "this is all uppercase";
        String result = Utils.toLowerCase(input);
        assertEquals(expected, result);

    }

    @Test
    public void testToLowerCaseAllLettersLowercase() {
        // Teste com string minúscula
        String input = "this is already lowercase";
        String expected = "this is already lowercase";
        String result = Utils.toLowerCase(input);
        assertEquals(expected, result);
    }

    @Test
    public void testToLowerCaseMixedLetters() {
        // Teste com string mista
        String input = "MiXeD CaSe StRiNg";
        String expected = "mixed case string";
        String result = Utils.toLowerCase(input);
        assertEquals(expected, result);
    }

    @Test
    public void testToLowerCaseEmptyString() {
        // Teste com string vazia
        String input = "";
        String expected = "";
        String result = Utils.toLowerCase(input);
        assertEquals(expected, result);
    }
}