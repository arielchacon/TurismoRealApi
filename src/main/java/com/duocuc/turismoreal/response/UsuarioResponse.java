package com.duocuc.turismoreal.response;

import java.util.HashSet;
import java.util.Set;

public class UsuarioResponse {

    private int idUsuario;
    private String nombreUsuario;
    private String password;
    private String estado;
    private Set<RolesResponse> roles = new HashSet<>();
    

    public UsuarioResponse() {
        this.idUsuario = 0;
        this.nombreUsuario = "";
        this.password="";
        this.estado = "";
        
    }


    public UsuarioResponse(int idUsuario, String nombreUsuario, String password, String estado,
            Set<RolesResponse> roles) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.estado = estado;
        this.roles = roles;
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


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }


    public Set<RolesResponse> getRoles() {
        return roles;
    }


    public void setRoles(Set<RolesResponse> roles) {
        this.roles = roles;
    }

    

}
