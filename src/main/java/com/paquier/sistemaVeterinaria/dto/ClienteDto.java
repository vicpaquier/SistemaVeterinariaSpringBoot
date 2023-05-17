package com.paquier.sistemaVeterinaria.dto;

import javax.persistence.Column;

public class ClienteDto {
    private long idCliente;
    private String nombre;
    private String apellido;
    private String ruc;
    private String celular;

    public ClienteDto() {
    }

    public ClienteDto(long idCliente, String nombre, String apellido, String ruc, String celular) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ruc = ruc;
        this.celular = celular;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
