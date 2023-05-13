package com.paquier.sistemaVeterinaria.entity;

import jdk.jfr.Enabled;

import javax.persistence.*;

@Enabled
public class DetalleFacturacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDetalleFacturacion;
    @Column(nullable = false)
    private int cantidad;
    @ManyToOne
    private Servicio servicio;
    @ManyToOne
    private Facturacion facturacion;

    public DetalleFacturacion() {
    }

    public DetalleFacturacion(long idDetalleFacturacion, int cantidad, Servicio servicio, Facturacion facturacion) {
        this.idDetalleFacturacion = idDetalleFacturacion;
        this.cantidad = cantidad;
        this.servicio = servicio;
        this.facturacion = facturacion;
    }

    public long getIdDetalleFacturacion() {
        return idDetalleFacturacion;
    }

    public void setIdDetalleFacturacion(long idDetalleFacturacion) {
        this.idDetalleFacturacion = idDetalleFacturacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Facturacion getFacturacion() {
        return facturacion;
    }

    public void setFacturacion(Facturacion facturacion) {
        this.facturacion = facturacion;
    }
}
