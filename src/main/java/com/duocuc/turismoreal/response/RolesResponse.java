package com.duocuc.turismoreal.response;

public class RolesResponse {
    
    private int rolId;
    private String rol;
    
    public RolesResponse(){
        this.rolId = 0;
        this.rol="";
        }

    public RolesResponse(int rolId, String rol) {
        this.rolId = rolId;
        this.rol = rol;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    

}
