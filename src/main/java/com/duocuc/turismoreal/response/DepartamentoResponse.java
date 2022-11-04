package com.duocuc.turismoreal.response;

import java.sql.Blob;

public class DepartamentoResponse {
    
    private int idDepartamento;
    private int numDepartamento;
    private int numHabitaciones;
    private int numBanios;
    private String estado;
    private int valor;
    private Blob imagen;
    private int dividendo;
    private int contribucion;
    private String disponibilidad;
    private int idEdificio;
    private String runFuncionario;

    public DepartamentoResponse() {

        this.idDepartamento=0;
        this.numDepartamento=0;
        this.numHabitaciones=0;
        this.numBanios=0;
        this.estado="";
        this.valor=0;
        this.dividendo=0;
        this.contribucion=0;
        this.disponibilidad="";
        this.idEdificio=0;
        this.runFuncionario="";

    }

    public DepartamentoResponse(int idDepartamento, int numDepartamento, int numHabitaciones, int numBanios,
            String estado, int valor, Blob imagen, int dividendo, int contribucion, String disponibilidad,
            int idEdificio, String runFuncionario) {
        this.idDepartamento = idDepartamento;
        this.numDepartamento = numDepartamento;
        this.numHabitaciones = numHabitaciones;
        this.numBanios = numBanios;
        this.estado = estado;
        this.valor = valor;
        this.imagen = imagen;
        this.dividendo = dividendo;
        this.contribucion = contribucion;
        this.disponibilidad = disponibilidad;
        this.idEdificio = idEdificio;
        this.runFuncionario = runFuncionario;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public int getNumDepartamento() {
        return numDepartamento;
    }

    public void setNumDepartamento(int numDepartamento) {
        this.numDepartamento = numDepartamento;
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

    public int getIdEdificio() {
        return idEdificio;
    }

    public void setIdEdificio(int idEdificio) {
        this.idEdificio = idEdificio;
    }

    public String getRunFuncionario() {
        return runFuncionario;
    }

    public void setRunFuncionario(String runFuncionario) {
        this.runFuncionario = runFuncionario;
    }

}
