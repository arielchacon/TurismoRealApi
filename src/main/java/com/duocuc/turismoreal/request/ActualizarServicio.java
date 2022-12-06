package com.duocuc.turismoreal.request;

public class ActualizarServicio {
    
    private int idServicio;
    private String descripcion;
    private String estado;
    private int monto;
    
    public ActualizarServicio(int idServicio, String descripcion, String estado, int monto) {
        this.idServicio = idServicio;
        this.descripcion = descripcion;
        this.estado = estado;
        this.monto = monto;
    }

    public ActualizarServicio() {
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }   

}
