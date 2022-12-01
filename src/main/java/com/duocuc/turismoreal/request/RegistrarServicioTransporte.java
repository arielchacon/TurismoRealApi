package com.duocuc.turismoreal.request;

public class RegistrarServicioTransporte {
    
    private int idReserva;
    private int idTransporte;

    public RegistrarServicioTransporte() {}

    public RegistrarServicioTransporte(int idReserva, int idTransporte) {
        this.idReserva = idReserva;
        this.idTransporte = idTransporte;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }

}
