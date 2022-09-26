package com.duocuc.turismoreal.response;

public class UsuarioResponse {

    private int idUsuario;
    private String nombreUsuario;
    private String estado;

    public UsuarioResponse() {
        this.idUsuario = 0;
        this.nombreUsuario = "";
        this.estado = "";
    }

    public UsuarioResponse(int idUsuario, String nombreUsuario, String estado) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.estado = estado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
