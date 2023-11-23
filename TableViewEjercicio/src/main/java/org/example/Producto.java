package org.example;

import java.util.Date;

public class Producto {
    private String nombre;
    private double precio;
    private int stock;
    private double peso;
    private Date fechaVencimiento;
    private String color;
    private String material;
    private String numModelo;

    public Producto(String nombre, double precio, int stock, double peso, Date fechaVencimiento, String color, String material, String numModelo) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.peso = peso;
        this.fechaVencimiento = fechaVencimiento;
        this.color = color;
        this.material = material;
        this.numModelo = numModelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getNumModelo() {
        return numModelo;
    }

    public void setNumModelo(String numModelo) {
        this.numModelo = numModelo;
    }

    public boolean contieneTexto(String filtro){
        return nombre.toLowerCase().contains(filtro.toLowerCase());
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", peso=" + peso +
                ", fechaVencimiento=" + fechaVencimiento +
                ", color='" + color + '\'' +
                ", material='" + material + '\'' +
                ", numModelo='" + numModelo + '\'' +
                '}';
    }
}
