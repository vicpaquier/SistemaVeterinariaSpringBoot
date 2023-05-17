package com.paquier.sistemaVeterinaria.dto;

import com.paquier.sistemaVeterinaria.entity.Empleado;

public class UsuarioDto {
    private long idUsuario;
    private String tipo;
    private String login;
    private String contra;
    private Empleado empleado;

    public UsuarioDto() {
    }

    public UsuarioDto(long idUsuario, String tipo, String login, String contra, Empleado empleado) {
        this.idUsuario = idUsuario;
        this.tipo = tipo;
        this.login = login;
        this.contra = contra;
        this.empleado = empleado;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "UsuarioDto{" +
                "idUsuario=" + idUsuario +
                ", tipo='" + tipo + '\'' +
                ", login='" + login + '\'' +
                ", contra='" + contra + '\'' +
                ", empleado=" + empleado +
                '}';
    }
}
