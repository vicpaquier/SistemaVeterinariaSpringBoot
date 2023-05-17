package com.paquier.sistemaVeterinaria.dto;

public class ServicioDto {
    private long idServicio;
    private String descripcion;
    private int precio;
    private String iva;

    public ServicioDto() {
    }

    public ServicioDto(long idServicio, String descripcion, int precio, String iva) {
        this.idServicio = idServicio;
        this.descripcion = descripcion;
        this.precio = precio;
        this.iva = iva;
    }

    public long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(long idServicio) {
        this.idServicio = idServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }
}
