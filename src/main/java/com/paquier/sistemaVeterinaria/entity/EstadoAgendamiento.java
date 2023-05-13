package com.paquier.sistemaVeterinaria.entity;

import javax.persistence.*;

@Table(name = "estado_agendamiento")
@Entity
public class EstadoAgendamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEstadoAgendamiento;

    private String descripcion;

    public EstadoAgendamiento() {
    }

    public EstadoAgendamiento(long idEstadoAgendamiento, String descripcion) {
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
