package com.duocuc.turismoreal.request;

import java.sql.Date;

public class ActualizarCheckOut {
    
    private int idCheckout;
    private Date fecha;
    private int multa;
    private String runFuncionario;
    private int idReserva;
    
    public ActualizarCheckOut(int idCheckout, Date fecha, int multa, String runFuncionario, int idReserva) {
        this.idCheckout = idCheckout;
        this.fecha = fecha;
        this.multa = multa;
        this.runFuncionario = runFuncionario;
        this.idReserva = idReserva;
    }

    public ActualizarCheckOut() {
    }

    public int getIdCheckout() {
        return idCheckout;
    }

    public void setIdCheckout(int idCheckout) {
        this.idCheckout = idCheckout;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getMulta() {
        return multa;
    }

    public void setMulta(int multa) {
        this.multa = multa;
    }

    public String getRunFuncionario() {
        return runFuncionario;
    }

    public void setRunFuncionario(String runFuncionario) {
        this.runFuncionario = runFuncionario;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

}
