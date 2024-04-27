package test.java.com.calculator.app;

import main.com.calculator.app.Calculadora;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    Calculadora calculadora = new Calculadora();

    @Test
    public void testSomar() {
        // Valores
        double[] valoresA = {2.5, 3.123, 5.006, 0.500, 3.499, 0.499, 0.001, 4.675, 999.5, -0.001};
        double[] valoresB = {3.25, 4.115, 5.006, 0.501, 3.500, 0.500, 0.004, 4.674, 0.5, 0.001};
        double[] resultadosEsperados = {5.75, 7.238, 10.012, 1.001, 6.999, 0.999, 0.005, 9.349, 1000.0, 0.0};

        for (int i = 0; i < valoresA.length; i++) {
            double resultado = calculadora.soma(valoresA[i], valoresB[i]);
            Assertions.assertEquals(resultadosEsperados[i], resultado);
        }
    }

    @Test
    public void testSubtracao() {
        double[] valoresA = {2.5, 3.123, 5.006, 0.500, 3.499, 0.499, 0.001, 4.675, 999.5, -0.001};
        double[] valoresB = {3.25, 4.115, 5.006, 0.501, 3.500, 0.500, 0.004, 4.674, 0.5, 0.001};
        double[] resultadosEsperadosSubtracao = {-0.75, -0.992, 0.0, -0.001, -0.001, -0.001, -0.003, 0.001, 999.0, -0.002};

        for (int i = 0; i < valoresA.length; i++) {
            double resultado = calculadora.subtracao(valoresA[i], valoresB[i]);
            Assertions.assertEquals(resultadosEsperadosSubtracao[i], resultado);
        }
    }

    @Test
    public void testMultiplicacao() {
        double[] valoresA = {2.5, 3.123, 5.006, 0.500, 3.499, 0.499, 0.001, 4.675, 999.5, -0.001};
        double[] valoresB = {3.25, 4.115, 5.006, 0.501, 3.500, 0.500, 0.004, 4.674, 0.5, 0.001};
        double[] resultadosEsperadosMultiplicacao = {8.125, 12.851, 25.06, 0.251, 12.247, 0.25, 0.0, 21.851, 499.75, 0.0};

        for (int i = 0; i < valoresA.length; i++) {
            double resultado = calculadora.multiplicacao(valoresA[i], valoresB[i]);
            Assertions.assertEquals(resultadosEsperadosMultiplicacao[i], resultado);
        }
    }

    @Test
    public void testDivisao() {
        double[] valoresA = {2.5, 3.123, 5.006, 0.500, 3.499, 0.499, 0.001, 4.675, 999.5, -0.001};
        double[] valoresB = {3.25, 4.115, 5.006, 0.501, 3.500, 0.500, 0.004, 4.674, 0.5, 0.001};
        double[] resultadosEsperadosDivisao = {0.769, 0.759, 1.0, 0.998, 1.0, 0.998, 0.25, 1.0, 1999.0, -1.0};

        for (int i = 0; i < valoresA.length; i++) {
            double resultado = calculadora.divisao(valoresA[i], valoresB[i]);
            Assertions.assertEquals(resultadosEsperadosDivisao[i], resultado);
        }
    }

}