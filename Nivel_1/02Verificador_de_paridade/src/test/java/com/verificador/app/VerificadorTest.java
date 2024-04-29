package test.java.com.verificador.app;

import main.com.verificador.app.VerificadorPariedade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerificadorTest {
    VerificadorPariedade verificador;

    @Test
    public void testVerificadorPariedade() {
        // Teste para números pares
        Assertions.assertTrue(VerificadorPariedade.verificarParidade(0));
        Assertions.assertTrue(VerificadorPariedade.verificarParidade(2));
        Assertions.assertTrue(VerificadorPariedade.verificarParidade(10));
        Assertions.assertTrue(VerificadorPariedade.verificarParidade(100));
        Assertions.assertTrue(VerificadorPariedade.verificarParidade(1000));

        // Teste para números ímpares
        Assertions.assertFalse(VerificadorPariedade.verificarParidade(1));
        Assertions.assertFalse(VerificadorPariedade.verificarParidade(3));
        Assertions.assertFalse(VerificadorPariedade.verificarParidade(11));
        Assertions.assertFalse(VerificadorPariedade.verificarParidade(101));
        Assertions.assertFalse(VerificadorPariedade.verificarParidade(1001));

        // Teste para números negativos pares e ímpares
        Assertions.assertTrue(VerificadorPariedade.verificarParidade(-2));
        Assertions.assertFalse(VerificadorPariedade.verificarParidade(-3));
        Assertions.assertTrue(VerificadorPariedade.verificarParidade(-10));
        Assertions.assertFalse(VerificadorPariedade.verificarParidade(-11));
    }
}
