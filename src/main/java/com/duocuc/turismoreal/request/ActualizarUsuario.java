package com.duocuc.turismoreal.request;

public class ActualizarUsuario {
    
    private String nombreUsuario;
    private String oldPassword;
    private String newPassword;
    
    public ActualizarUsuario(String nombreUsuario, String oldPassword, String newPassword) {
        this.nombreUsuario = nombreUsuario;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
    
    
}
