package com.paquier.sistemaVeterinaria.dto;

public class UsuarioDto {
    private long idUsuario;
    private String tipo;
    private String login;
    private String contra;

    public UsuarioDto() {
    }

    public UsuarioDto(long idUsuario, String tipo, String login, String contra) {
        this.idUsuario = idUsuario;
        this.tipo = tipo;
        this.login = login;
        this.contra = contra;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long id) {
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
}
