package com.duocuc.turismoreal.response;

public class ComunaResponse {
    
    private int idComuna;
    private String nombre;
    private int idProvincia;
    
    public ComunaResponse(int idComuna, String nombre, int idProvincia) {
        this.idComuna = idComuna;
        this.nombre = nombre;
        this.idProvincia = idProvincia;
    }

    public int getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(int idComuna) {
        this.idComuna = idComuna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

}
