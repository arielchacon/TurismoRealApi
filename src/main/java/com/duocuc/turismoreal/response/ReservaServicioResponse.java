package com.duocuc.turismoreal.response;

import java.sql.Date;

public class ReservaServicioResponse {
    
    private int idServicio;
    private String descripcion;
    private String estado;
    private int monto;
    private int idReserva;
    private Date fechaInicio;
    private String horaInicio;
    private Date fechaTermino;
    private String horaTermino;
    
    public ReservaServicioResponse(int idServicio, String descripcion, String estado, int monto, int idReserva,
            Date fechaInicio, String horaInicio, Date fechaTermino, String horaTermino) {
        this.idServicio = idServicio;
        this.descripcion = descripcion;
        this.estado = estado;
        this.monto = monto;
        this.idReserva = idReserva;
        this.fechaInicio = fechaInicio;
        this.horaInicio = horaInicio;
        this.fechaTermino = fechaTermino;
        this.horaTermino = horaTermino;
    }

    public ReservaServicioResponse() {
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
