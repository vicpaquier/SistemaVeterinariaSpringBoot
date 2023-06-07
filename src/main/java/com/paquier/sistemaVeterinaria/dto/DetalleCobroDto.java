package com.paquier.sistemaVeterinaria.dto;

import com.paquier.sistemaVeterinaria.entity.Cobro;
import com.paquier.sistemaVeterinaria.entity.Facturacion;

public class DetalleCobroDto {
    private long idDetalleCobro;
    private int total;
    private String metodoPago;
    private Facturacion facturacion;
    private Cobro idCobro;

    public DetalleCobroDto() {
    }

    public DetalleCobroDto(long idDetalleCobro, int total, String metodoPago, Facturacion facturacion, Cobro idCobro) {
        this.idDetalleCobro = idDetalleCobro;
        this.total = total;
        this.metodoPago = metodoPago;
        this.facturacion = facturacion;
        this.idCobro = idCobro;
    }

    public long getIdDetalleCobro() {
        return idDetalleCobro;
    }

    public void setIdDetalleCobro(long idDetalleCobro) {
        this.idDetalleCobro = idDetalleCobro;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Facturacion getFacturacion() {
        return facturacion;
    }

    public void setFacturacion(Facturacion facturacion) {
        this.facturacion = facturacion;
    }

    public Cobro getIdCobro() {
        return idCobro;
    }

    public void setIdCobro(Cobro idCobro) {
        this.idCobro = idCobro;
    }
}
