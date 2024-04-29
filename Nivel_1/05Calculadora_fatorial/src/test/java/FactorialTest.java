import org.example.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class FactorialTest {
    @Test
    public void testCalculateFactorialOfZero_ShouldReturnOne() {
        // Teste do cálculo do fatorial de zero, que deve ser igual a 1.
        FactorialCalculator calculator = new FactorialCalculator();
        long factorial = calculator.calculateFactorial(0);
        assertEquals(1, factorial);
    }

    @Test
    public void testCalculateFactorialOfPositiveNumber_ShouldReturnCorrectFactorial() {
        // Teste do cálculo do fatorial de um número positivo (5), que deve ser igual a 120.
        FactorialCalculator calculator = new FactorialCalculator();
        long factorial = calculator.calculateFactorial(5);
        assertEquals(120, factorial);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateFactorialOfNegativeNumber_ShouldThrowIllegalArgumentException() {
        // Teste de comportamento da função quando um número negativo é passado como argumento, esperando que uma exceção `IllegalArgumentException` seja lançada.
        FactorialCalculator calculator = new FactorialCalculator();
        calculator.calculateFactorial(-5);
    }

    @Test
    public void testIsValidNumberForPositiveNumber_ShouldBeValid() {
        // Teste da validação de um número positivo (5), que deve ser considerado válido.
        FactorialValidator validator = new FactorialValidator();
        boolean isValid = validator.isValidNumber(5);
        assertTrue(isValid);
    }

    @Test
    public void testIsValidNumberForZero_ShouldBeValid() {
        // Teste da validação do zero, que também deve ser considerado válido.
        FactorialValidator validator = new FactorialValidator();
        boolean isValid = validator.isValidNumber(0);
        assertTrue(isValid);
    }

    @Test
    public void testIsValidNumberForNegativeNumber_ShouldBeInvalid() {
        // Teste da validação de um número negativo (-5), que deve ser considerado inválido.
        FactorialValidator validator = new FactorialValidator();
        boolean isValid = validator.isValidNumber(-5);
        assertFalse(isValid);
    }
}