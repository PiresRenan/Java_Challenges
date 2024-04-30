package org.example.media.model;

public class Numero implements Comparable<Numero> {
    private double valor;
    public Numero(){
        this.valor = 0;
    }
    public Numero(double valor){
        this.valor = valor;
    }
    public double getValor(){
        return valor;
    }
    public void setValor(double valor){
        this.valor = valor;
    }

    @Override
    public int compareTo(Numero o) {
        return Double.compare(this.valor, o.valor);
    }
}
