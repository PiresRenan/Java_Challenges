package com.example.media.model;

import org.example.media.model.Numero;
import org.junit.Assert;
import org.junit.Test;

public class NumeroTest {
//    Constructor Test
    @Test
    public void testConstructor() {
        Numero numero = new Numero(10.5);
        Assert.assertEquals(10.5, numero.getValor(), 0.001); // Check if valor is set correctly
    }
//    Getter and Setter Tests
    @Test
    public void testGetValor() {
        Numero numero = new Numero(10.5);
        Assert.assertEquals(10.5, numero.getValor(), 0.001);
    }

    @Test
    public void testSetValor() {
        Numero numero = new Numero(5.2);
        numero.setValor(12.8);
        Assert.assertEquals(12.8, numero.getValor(), 0.001);
    }
//    Equality Test
    @Test
    public void testEquals() {
        Numero numero1 = new Numero(10.5);
        Numero numero2 = new Numero(10.5);
        Assert.assertEquals(numero1.getValor(), numero2.getValor(), 0.001);
    }
}
