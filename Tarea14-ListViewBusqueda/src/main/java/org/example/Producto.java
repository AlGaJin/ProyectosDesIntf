package org.example;

public class Producto {
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock){
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public boolean contieneTexto(String filtro){
        return  nombre.toLowerCase().contains(filtro.toLowerCase());
    }

    public boolean contieneStock(int filto){
        return stock >= filto;
    }

    @Override
    public String toString() {
        return nombre + " - " + precio + "€ - " + stock + " uds.";
    }
}
