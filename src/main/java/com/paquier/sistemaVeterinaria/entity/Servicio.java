package com.paquier.sistemaVeterinaria.entity;

import javax.persistence.*;

@Entity
@Table(name = "servicios")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idServicio;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private int precio;
    @Column(nullable = false)
    private String iva;

    public Servicio() {
    }

    public Servicio(long idServicio, String descripcion, int precio, String iva) {
        this.idServicio = idServicio;
        this.descripcion = descripcion;
        this.precio = precio;
        this.iva = iva;
    }

    public long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(long idServicio) {
        this.idServicio = idServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }
}
