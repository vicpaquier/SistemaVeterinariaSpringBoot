package com.paquier.sistemaVeterinaria.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "mascotas")
public class Mascota{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMascota;
    @Column(nullable = false)
    private String especie;
    @Column(nullable = false)
    private String raza;
    @Column(nullable = false)
    private String colorPelo;
    @Column(nullable = false)
    private LocalDate fechaNacimiento;
    @ManyToOne
    private Cliente cliente;

    public Mascota() {
    }

    public Mascota(long idMascota, String especie, String raza, String colorPelo, LocalDate fechaNacimiento, Cliente cliente) {
        this.idMascota = idMascota;
        this.especie = especie;
        this.raza = raza;
        this.colorPelo = colorPelo;
        this.fechaNacimiento = fechaNacimiento;
        this.cliente = cliente;
    }

    public long getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(long idMascota) {
        this.idMascota = idMascota;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColorPelo() {
        return colorPelo;
    }

    public void setColorPelo(String colorPelo) {
        this.colorPelo = colorPelo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
