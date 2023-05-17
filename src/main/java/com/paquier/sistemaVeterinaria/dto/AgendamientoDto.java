package com.paquier.sistemaVeterinaria.dto;

import com.paquier.sistemaVeterinaria.entity.Cliente;
import com.paquier.sistemaVeterinaria.entity.Empleado;
import com.paquier.sistemaVeterinaria.entity.EstadoAgendamiento;

import java.time.LocalDateTime;

public class AgendamientoDto {
    private long idAgendamiento;
    private LocalDateTime fecha;
    private Cliente cliente;
    private Empleado empleado;
    private EstadoAgendamiento estadoAgendamiento;

    public AgendamientoDto() {
    }

    public AgendamientoDto(long idAgendamiento, LocalDateTime fecha, Cliente cliente, Empleado empleado, EstadoAgendamiento estadoAgendamiento) {
        this.idAgendamiento = idAgendamiento;
        this.fecha = fecha;
        this.cliente = cliente;
        this.empleado = empleado;
        this.estadoAgendamiento = estadoAgendamiento;
    }

    public long getIdAgendamiento() {
        return idAgendamiento;
    }

    public void setIdAgendamiento(long idAgendamiento) {
        this.idAgendamiento = idAgendamiento;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public EstadoAgendamiento getEstadoAgendamiento() {
        return estadoAgendamiento;
    }

    public void setEstadoAgendamiento(EstadoAgendamiento estadoAgendamiento) {
        this.estadoAgendamiento = estadoAgendamiento;
    }

    @Override
    public String toString() {
        return "AgendamientoDto{" +
                "idAgendamiento=" + idAgendamiento +
                ", fecha=" + fecha +
                ", cliente=" + cliente +
                ", empleado=" + empleado +
                ", estadoAgendamiento=" + estadoAgendamiento +
                '}';
    }
}
