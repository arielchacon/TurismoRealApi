package com.duocuc.turismoreal.response;

public class UsuarioResponse {

    private int idUsuario;
    private String nombreUsuario;
    private String estado;
    private String rol;

    public UsuarioResponse() {
        this.idUsuario = 0;
        this.nombreUsuario = "";
        this.estado = "";
        this.rol = "";
    }

    public UsuarioResponse(int idUsuario, String nombreUsuario, String estado, String rol) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.estado = estado;
        this.rol = estado;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol){
        this.rol = rol;
    }

}
