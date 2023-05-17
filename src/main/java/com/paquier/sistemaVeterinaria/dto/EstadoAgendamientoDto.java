package com.paquier.sistemaVeterinaria.dto;

public class EstadoAgendamientoDto {
    private long idEstadoAgendamiento;
    private String descripcion;

    public EstadoAgendamientoDto() {
    }

    public EstadoAgendamientoDto(long idEstadoAgendamiento, String descripcion) {
        this.idEstadoAgendamiento = idEstadoAgendamiento;
        this.descripcion = descripcion;
    }

    public long getIdEstadoAgendamiento() {
        return idEstadoAgendamiento;
    }

    public void setIdEstadoAgendamiento(long idEstadoAgendamiento) {
        this.idEstadoAgendamiento = idEstadoAgendamiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

