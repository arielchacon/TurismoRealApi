package com.duocuc.turismoreal.response;

public class EdificioResponse {
    
    private int idEdificio;
    private String nombre;
    private String direccion;
    private int idComuna;
    private String estado;
    
    public EdificioResponse(int idEdificio, String nombre, String direccion, int idComuna, String estado) {
        this.idEdificio = idEdificio;
        this.nombre = nombre;
        this.direccion = direccion;
        this.idComuna = idComuna;
        this.estado = estado;
    }

    public int getIdEdificio() {
        return idEdificio;
    }

    public void setIdEdificio(int idEdificio) {
        this.idEdificio = idEdificio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(int idComuna) {
        this.idComuna = idComuna;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    

}
