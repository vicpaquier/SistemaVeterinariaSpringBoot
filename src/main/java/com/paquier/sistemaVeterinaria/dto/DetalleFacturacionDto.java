package com.paquier.sistemaVeterinaria.dto;

import com.paquier.sistemaVeterinaria.entity.Facturacion;
import com.paquier.sistemaVeterinaria.entity.Servicio;


public class DetalleFacturacionDto {
    private long idDetalleFacturacion;
    private int cantidad;
    private Servicio servicio;
    private Facturacion facturacion;

    public DetalleFacturacionDto() {
    }

    public DetalleFacturacionDto(long idDetalleFacturacion, int cantidad, Servicio servicio, Facturacion facturacion) {
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
