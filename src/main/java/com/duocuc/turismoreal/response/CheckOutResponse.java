package com.duocuc.turismoreal.response;

import java.sql.Date;

public class CheckOutResponse {
    
    private int idCheckOut;
    private Date fecha;
    private int multa;
    private String runFuncionario;
    private int idReserva;
    
    public CheckOutResponse(int idCheckOut, Date fecha, int multa, String runFuncionario, int idReserva) {
        this.idCheckOut = idCheckOut;
        this.fecha = fecha;
        this.multa = multa;
        this.runFuncionario = runFuncionario;
        this.idReserva = idReserva;
    }

    public CheckOutResponse() {
    }

    public int getIdCheckOut() {
        return idCheckOut;
    }

    public void setIdCheckOut(int idCheckOut) {
        this.idCheckOut = idCheckOut;
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
