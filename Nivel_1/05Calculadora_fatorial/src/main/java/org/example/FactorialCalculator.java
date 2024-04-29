package org.example;

public class FactorialCalculator {
    public long calculateFactorial(int number) {
        if (number < 0){
            throw new IllegalArgumentException("Número deve ser maior que zero");
        }
        long factorial = 1L;
        for (int i = 1; i <= number; i++){
            factorial *= i;
        }
        return factorial;
    }
}
