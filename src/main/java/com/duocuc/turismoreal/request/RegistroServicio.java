package com.duocuc.turismoreal.request;

public class RegistroServicio {
    
    private String descripcion;
    private String estado;
    private int monto;
    
    public RegistroServicio(String descripcion, String estado, int monto) {
        this.descripcion = descripcion;
        this.estado = estado;
        this.monto = monto;
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
