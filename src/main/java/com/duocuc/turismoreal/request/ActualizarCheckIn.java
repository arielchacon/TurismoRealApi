package com.duocuc.turismoreal.request;

import java.sql.Date;

public class ActualizarCheckIn {
    
    private int idCheckin;
    private Date fecha;
    private int abono;
    private String runFuncionario;
    private int idReserva;

    public ActualizarCheckIn(int idCheckin, Date fecha, int abono, String runFuncionario, int idReserva) {
        this.idCheckin = idCheckin;
        this.fecha = fecha;
        this.abono = abono;
        this.runFuncionario = runFuncionario;
        this.idReserva = idReserva;
    }

    public ActualizarCheckIn() {
    }

    public int getIdCheckin() {
        return idCheckin;
    }

    public void setIdCheckin(int idCheckin) {
        this.idCheckin = idCheckin;
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
