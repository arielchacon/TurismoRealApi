package com.duocuc.turismoreal.request;

import java.sql.Date;

public class RegistrarReservaServicio {
    
    private int idServicio;
    private int idReserva;
    private Date fechaInicio;
    private String horaInicio;
    private Date fechaTermino;
    private String horaTermino;

    public RegistrarReservaServicio () {}

    public RegistrarReservaServicio(int idServicio, int idReserva, Date fechaInicio, String horaInicio,
            Date fechaTermino, String horaTermino) {
        this.idServicio = idServicio;
        this.idReserva = idReserva;
        this.fechaInicio = fechaInicio;
        this.horaInicio = horaInicio;
        this.fechaTermino = fechaTermino;
        this.horaTermino = horaTermino;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public String getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(String horaTermino) {
        this.horaTermino = horaTermino;
    }

    
}
