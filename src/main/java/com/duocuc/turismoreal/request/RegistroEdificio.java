package com.duocuc.turismoreal.request;

public class RegistroEdificio {

    private String direccion;
    private String estado;
    private int idComuna;
    private String nombre;
    
    public RegistroEdificio(String direccion, String estado, int idComuna, String nombre) {
        this.direccion = direccion;
        this.estado = estado;
        this.idComuna = idComuna;
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_comuna() {
        return idComuna;
    }

    public void setId_comuna(int id_comuna) {
        this.idComuna = id_comuna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

}
