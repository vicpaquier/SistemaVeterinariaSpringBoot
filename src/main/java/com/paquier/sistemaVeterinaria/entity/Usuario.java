package com.paquier.sistemaVeterinaria.entity;

import javax.persistence.*;

@Table(name = "usuarios")
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUsuario;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String contra;

    @ManyToOne
    private Empleado empleado;

    public Usuario() {
    }

    public Usuario(long idUsuario, String tipo, String login, String contra, Empleado empleado) {
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
}