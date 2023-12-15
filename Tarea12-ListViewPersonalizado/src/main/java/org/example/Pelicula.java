package org.example;

import java.util.Date;

public class Pelicula {
    private String titulo;
    private String autor;
    private int anio;
    private String url;

    public Pelicula(String titulo, String autor, int anio, String url) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.url = url;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anio=" + anio +
                ", url='" + url + '\'' +
                '}';
    }
}
