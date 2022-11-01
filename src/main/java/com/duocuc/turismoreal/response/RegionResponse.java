package com.duocuc.turismoreal.response;

public class RegionResponse {
    
    private int idRegion;
    private String nombre;
    
    public RegionResponse(int idRegion, String nombre) {
        this.idRegion = idRegion;
        this.nombre = nombre;
    }

    public RegionResponse() {
        this.idRegion=0;
        this.nombre="";
    }

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

}
