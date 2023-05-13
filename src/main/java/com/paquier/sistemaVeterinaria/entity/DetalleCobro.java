package com.paquier.sistemaVeterinaria.entity;

import javax.persistence.*;

@Entity
@Table(name = "detalle_cobros")
public class DetalleCobro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDetalleCobro;
    @Column(nullable = false)
    private int total;
    @Column(nullable = false)
    private String metodoPago;
    @ManyToOne
    private Facturacion facturacion;
    @ManyToOne
    private Cobro idCobro;

    public DetalleCobro() {
    }

    public DetalleCobro(long idDetalleCobro, int total, String metodoPago, Facturacion facturacion, Cobro idCobro) {
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
