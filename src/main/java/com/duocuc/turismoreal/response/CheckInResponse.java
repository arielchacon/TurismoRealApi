package com.duocuc.turismoreal.response;

import java.sql.Date;

public class CheckInResponse {
    
    private int idCheckIn;
    private Date fecha;
    private int abono;
    private String runFuncionario;
    private int idReserva;
    
    public CheckInResponse(int idCheckIn, Date fecha, int abono, String runFuncionario, int idReserva) {
        this.idCheckIn = idCheckIn;
        this.fecha = fecha;
        this.abono = abono;
        this.runFuncionario = runFuncionario;
        this.idReserva = idReserva;
    }

    public CheckInResponse() {
    }

    public int getIdCheckIn() {
        return idCheckIn;
    }

    public void setIdCheckIn(int idCheckIn) {
        this.idCheckIn = idCheckIn;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getAbono() {
        return abono;
    }

    public void setAbono(int abono) {
        this.abono = abono;
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
