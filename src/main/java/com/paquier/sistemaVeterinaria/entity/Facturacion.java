package com.paquier.sistemaVeterinaria.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Facturacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFacturacion;
    @Column(nullable = false)
    private String condicion;
    @Column(nullable = false)
    private LocalDateTime fecha;
    @Column(nullable = false)
    private String numero;
    @Column(nullable = false)
    private String estado;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Cliente cliente;

    public Facturacion() {
    }

    public Facturacion(long idFacturacion, String condicion, LocalDateTime fecha, String numero, String estado, Usuario usuario, Cliente cliente) {
        this.idFacturacion = idFacturacion;
        this.condicion = condicion;
        this.fecha = fecha;
        this.numero = numero;
        this.estado = estado;
        this.usuario = usuario;
        this.cliente = cliente;
    }

    public long getIdFacturacion() {
        return idFacturacion;
    }

    public void setIdFacturacion(long idFacturacion) {
        this.idFacturacion = idFacturacion;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
