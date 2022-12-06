package com.duocuc.turismoreal.response;

import java.sql.Blob;

public class ReservaDepartamentoResponse {
    
    private int idDepartamento;
    private int numeroDepartamento;
    private int numeroHabitaciones;
    private int numeroBanios;
    private String estado;
    private int valor;
    private Blob imagen;
    private int dividendo;
    private int contribucion;
    private String disponibilidad;
    private int idEdificio;
    private String runFuncinoario;
    private int idReserva;
    
    public ReservaDepartamentoResponse(int idDepartamento, int numeroDepartamento, int numeroHabitaciones,
            int numeroBanios, String estado, int valor, Blob imagen, int dividendo, int contribucion,
            String disponibilidad, int idEdificio, String runFuncinoario, int idReserva) {
        this.idDepartamento = idDepartamento;
        this.numeroDepartamento = numeroDepartamento;
        this.numeroHabitaciones = numeroHabitaciones;
        this.numeroBanios = numeroBanios;
        this.estado = estado;
        this.valor = valor;
        this.imagen = imagen;
        this.dividendo = dividendo;
        this.contribucion = contribucion;
        this.disponibilidad = disponibilidad;
        this.idEdificio = idEdificio;
        this.runFuncinoario = runFuncinoario;
        this.idReserva = idReserva;
    }

    public ReservaDepartamentoResponse() {
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public int getNumeroDepartamento() {
        return numeroDepartamento;
    }

    public void setNumeroDepartamento(int numeroDepartamento) {
        this.numeroDepartamento = numeroDepartamento;
    }

    public int getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public void setNumeroHabitaciones(int numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public int getNumeroBanios() {
        return numeroBanios;
    }

    public void setNumeroBanios(int numeroBanios) {
        this.numeroBanios = numeroBanios;
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

    public String getRunFuncinoario() {
        return runFuncinoario;
    }

    public void setRunFuncinoario(String runFuncinoario) {
        this.runFuncinoario = runFuncinoario;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    

}
