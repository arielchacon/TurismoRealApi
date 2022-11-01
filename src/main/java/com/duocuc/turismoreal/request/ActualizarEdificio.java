package com.duocuc.turismoreal.request;

public class ActualizarEdificio {

    private String direccion;
    private String estado;
    private int id_comuna;
    private String nombre;
    
    public ActualizarEdificio(String direccion, String estado, int id_comuna, String nombre) {
        this.direccion = direccion;
        this.estado = estado;
        this.id_comuna = id_comuna;
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
        return id_comuna;
    }

    public void setId_comuna(int id_comuna) {
        this.id_comuna = id_comuna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
}
