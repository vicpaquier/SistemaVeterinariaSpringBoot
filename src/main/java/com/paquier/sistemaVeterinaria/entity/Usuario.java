package com.paquier.sistemaVeterinaria.entity;

import javax.persistence.*;

@Table(name = "usuarios")
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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

    public Usuario(long id, String tipo, String login, String contra) {
        this.id = id;
        this.tipo = tipo;
        this.login = login;
        this.contra = contra;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
