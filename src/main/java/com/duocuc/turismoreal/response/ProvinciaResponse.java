package com.duocuc.turismoreal.response;

public class ProvinciaResponse {
    
    private int idProvincia;
    private String nombre;
    private int idRegion;
    
    public ProvinciaResponse(int idProvincia, String nombre, int idRegion) {
        this.idProvincia = idProvincia;
        this.nombre = nombre;
        this.idRegion = idRegion;
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

}
