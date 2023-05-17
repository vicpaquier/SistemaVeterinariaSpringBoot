package com.paquier.sistemaVeterinaria.dto;

import com.paquier.sistemaVeterinaria.entity.Cliente;

import java.time.LocalDate;

public class MascotaDto {
    private long idMascota;
    private String especie;
    private String raza;
    private String colorPelo;
    private LocalDate fechaNacimiento;
    private Cliente cliente;

    public MascotaDto() {
    }

    public MascotaDto(long idMascota, String especie, String raza, String colorPelo, LocalDate fechaNacimiento, Cliente cliente) {
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
