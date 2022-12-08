package com.duocuc.turismoreal.response;

import java.sql.Date;

public class ReservaTransporteResponse {
    
    private int idTransporte;
    private String direccionDesde;
    private String direccionHasta;
    private String horaInicio;
    private Date fechaInicio;
    private int monto;
    private String estado;
    private int idVehiculo;
    private int idReserva;
    
    public ReservaTransporteResponse(int idTransporte, String direccionDesde, String direccionHasta, String horaInicio,
            Date fechaInicio, int monto, String estado, int idVehiculo, int idReserva) {
        this.idTransporte = idTransporte;
        this.direccionDesde = direccionDesde;
        this.direccionHasta = direccionHasta;
        this.horaInicio = horaInicio;
        this.fechaInicio = fechaInicio;
        this.monto = monto;
        this.estado = estado;
        this.idVehiculo = idVehiculo;
        this.idReserva = idReserva;
    }

    public ReservaTransporteResponse() {
    }

    public int getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }

    public String getDireccionDesde() {
        return direccionDesde;
    }

    public void setDireccionDesde(String direccionDesde) {
        this.direccionDesde = direccionDesde;
    }

    public String getDireccionHasta() {
        return direccionHasta;
    }

    public void setDireccionHasta(String direccionHasta) {
        this.direccionHasta = direccionHasta;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
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

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    

}
