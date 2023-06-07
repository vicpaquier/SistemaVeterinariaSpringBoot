package com.paquier.sistemaVeterinaria.dto;

import com.paquier.sistemaVeterinaria.entity.Usuario;

import java.time.LocalDateTime;

public class CobroDto {
    private long idCobro;
    private LocalDateTime fecha;
    private Usuario usuario;

    public CobroDto() {
    }
    public CobroDto(long idCobro, LocalDateTime fecha, Usuario usuario) {
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
