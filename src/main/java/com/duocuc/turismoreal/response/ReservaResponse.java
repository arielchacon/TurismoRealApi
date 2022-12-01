package com.duocuc.turismoreal.response;

import java.sql.Date;

public class ReservaResponse {
    
    private String runCliente;
    private int idReserva;
    private Date fechaReserva;
    private int monto;
    private String estado;

    public ReservaResponse() {}

    public ReservaResponse(String runCliente, int idReserva, Date fechaReserva, int monto, String estado) {
        this.runCliente = runCliente;
        this.idReserva = idReserva;
        this.fechaReserva = fechaReserva;
        this.monto = monto;
        this.estado = estado;
    }

    public String getRunCliente() {
        return runCliente;
    }

    public void setRunCliente(String runCliente) {
        this.runCliente = runCliente;
    }

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
