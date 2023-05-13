package com.paquier.sistemaVeterinaria.entity;

import javax.persistence.*;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;

@Entity
@Table(name = "cobros")
public class Cobro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCobro;
    @Column(nullable = false)
    private LocalDateTime fecha;
    @ManyToOne
    private Usuario usuario;

    public Cobro() {
    }

    public Cobro(long idCobro, LocalDateTime fecha, Usuario usuario) {
        this.idCobro = idCobro;
        this.fecha = fecha;
        this.usuario = usuario;
    }

    public long getIdCobro() {
        return idCobro;
    }

    public void setIdCobro(long idCobro) {
        this.idCobro = idCobro;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
