package com.duocuc.turismoreal.request;

import java.sql.Date;

public class ActualizarReserva {
    
    private int idReserva;
    private Date fechaReserva;
    private int cantDeptos;
    private int monto;
    private String estado;

    public ActualizarReserva(int idReserva, Date fechaReserva, int cantDeptos, int monto, String estado) {
        this.idReserva = idReserva;
        this.fechaReserva = fechaReserva;
        this.cantDeptos = cantDeptos;
        this.monto = monto;
        this.estado = estado;
    }

    public ActualizarReserva(){}

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public int getCantDeptos() {
        return cantDeptos;
    }

    public void setCantDeptos(int cantDeptos) {
        this.cantDeptos = cantDeptos;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
}
