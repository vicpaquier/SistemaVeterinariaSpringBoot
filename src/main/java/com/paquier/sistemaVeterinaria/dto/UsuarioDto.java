package com.paquier.sistemaVeterinaria.dto;

public class UsuarioDto {
    private long id;
    private String tipo;
    private String login;
    private String contra;

    public UsuarioDto() {
    }

    public UsuarioDto(long id, String tipo, String login, String contra) {
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