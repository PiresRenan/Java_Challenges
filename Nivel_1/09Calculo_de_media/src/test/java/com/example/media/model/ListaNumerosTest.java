package com.example.media.model;

import org.example.media.model.ListaNumeros;
import org.example.media.model.Numero;

import org.junit.Assert;
import org.junit.Test;

public class ListaNumerosTest {
//    Constructor Test
    @Test
    public void testConstructor() {
        ListaNumeros lista = new ListaNumeros();
        Assert.assertEquals(0, lista.getTamanho()); // Check if size is initialized correctly
    }
//    Add and Remove Tests
    @Test
    public void testAdd() {
        ListaNumeros lista = new ListaNumeros();
        lista.addNumero(new Numero(5.2));
        Assert.assertEquals(1, lista.getTamanho());
    }
    @Test
    public void testRemove() {
        ListaNumeros lista = new ListaNumeros();
        Numero n = new Numero(5.2);
        Numero n2 = new Numero(9.5);
        lista.addNumero(n);
        lista.addNumero(n2);
        lista.removeNumero(n);
        Assert.assertEquals(1, lista.getTamanho());
    }
//    Get and Contains Tests
    @Test
    public void testGetNumero() {
        ListaNumeros lista = new ListaNumeros();
        Numero n = new Numero(5.2);
        lista.addNumero(n);
        Assert.assertEquals(n, lista.getNumeros().getFirst());
    }
    @Test
    public void testContains() {
        ListaNumeros lista = new ListaNumeros();
        Numero n = new Numero(10.5);
        Numero n2 = new Numero(20.0);
        lista.addNumero(n);
        lista.addNumero(n2);
        Assert.assertTrue(lista.containsCustom(n));
    }
}
