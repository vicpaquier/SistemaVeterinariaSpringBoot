package com.paquier.sistemaVeterinaria.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "agendamientos")
public class Agendamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAgendamiento;
    @Column(nullable = false)
    private LocalDateTime fecha;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Empleado empleado;
    @ManyToOne
    private EstadoAgendamiento estadoAgendamiento;

    public Agendamiento() {
    }

    public Agendamiento(long idAgendamiento, LocalDateTime fecha, Cliente cliente, Empleado empleado, EstadoAgendamiento estadoAgendamiento) {
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
}
