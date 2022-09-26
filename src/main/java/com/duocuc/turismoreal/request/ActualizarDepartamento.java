package com.duocuc.turismoreal.request;

import java.sql.Blob;

public class ActualizarDepartamento {
    
    private int numDepto;
    private int numHabitaciones;
    private int numBanios;
    private String estado;
    private int valor;
    private Blob imagen;
    private int dividendo;
    private int contribucion;
    private String disponibilidad;
    private String runFuncionario;
    
    public ActualizarDepartamento(int numDepto, int numHabitaciones, int numBanios, String estado, int valor,
            Blob imagen, int dividendo, int contribucion, String disponibilidad, String runFuncionario) {
        this.numDepto = numDepto;
        this.numHabitaciones = numHabitaciones;
        this.numBanios = numBanios;
        this.estado = estado;
        this.valor = valor;
        this.imagen = imagen;
        this.dividendo = dividendo;
        this.contribucion = contribucion;
        this.disponibilidad = disponibilidad;
        this.runFuncionario = runFuncionario;
    }

    public int getNumDepto() {
        return numDepto;
    }

    public void setNumDepto(int numDepto) {
        this.numDepto = numDepto;
    }

    public int getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public int getNumBanios() {
        return numBanios;
    }

    public void setNumBanios(int numBanios) {
        this.numBanios = numBanios;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Blob getImagen() {
        return imagen;
    }

    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }

    public int getDividendo() {
        return dividendo;
    }

    public void setDividendo(int dividendo) {
        this.dividendo = dividendo;
    }

    public int getContribucion() {
        return contribucion;
    }

    public void setContribucion(int contribucion) {
        this.contribucion = contribucion;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getRunFuncionario() {
        return runFuncionario;
    }

    public void setRunFuncionario(String runFuncionario) {
        this.runFuncionario = runFuncionario;
    }  

}
