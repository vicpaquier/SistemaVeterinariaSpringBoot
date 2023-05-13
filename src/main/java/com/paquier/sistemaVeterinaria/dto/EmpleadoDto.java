package com.paquier.sistemaVeterinaria.dto;

public class EmpleadoDto {
    private long idEmpleado;
    private String nombre;
    private String apellido;
    private String ruc;
    private String celular;

    public EmpleadoDto() {
    }

    public EmpleadoDto(long idEmpleado, String nombre, String apellido, String ruc, String celular) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ruc = ruc;
        this.celular = celular;
    }

    public long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(long idEmpleado) {
        this.idEmpleado = idEmpleado;
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
