package com.duocuc.turismoreal.request;

public class ActualizarVehiculo {
    
    private int idVehiculo;
    private String patente;
    private String annio;
    private int idModelo;
    private int idColor;
    private String nombreConductor;
    
    public ActualizarVehiculo(int idVehiculo, String patente, String annio, int idModelo, int idColor,
            String nombreConductor) {
        this.idVehiculo = idVehiculo;
        this.patente = patente;
        this.annio = annio;
        this.idModelo = idModelo;
        this.idColor = idColor;
        this.nombreConductor = nombreConductor;
    }

    public ActualizarVehiculo() {
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getAnnio() {
        return annio;
    }

    public void setAnnio(String annio) {
        this.annio = annio;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public int getIdColor() {
        return idColor;
    }

    public void setIdColor(int idColor) {
        this.idColor = idColor;
    }

    public String getNombreConductor() {
        return nombreConductor;
    }

    public void setNombreConductor(String nombreConductor) {
        this.nombreConductor = nombreConductor;
    }

    

}
