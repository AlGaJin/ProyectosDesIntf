package org.example;

import java.util.Date;

public class Noticia {
    private String titular;
    private String cuerpo;
    private Date fechaPublicacion;

    public Noticia(String titular, String cuerpo, Date fechaPublicacion) {
        this.titular = titular;
        this.cuerpo = cuerpo;
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    @Override
    public String toString() {
        return "Noticia{" +
                "titular='" + titular + '\'' +
                ", cuerpo='" + cuerpo + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                '}';
    }
}
