package com.duocuc.turismoreal.request;

import java.sql.Date;

public class RegistrarReserva {
    
    private int cantDepartamento;
    private Date fechaReserva;
    private int monto;
    private String estado;
    private Date fechaCheckin;
    private int abono;
    private String runFuncionario;
    private Date fechaCheckout;
    private int multa;
    private String runCliente;
    private int idDepartamento;

    public RegistrarReserva () {}

    public RegistrarReserva(int cantDepartamento, Date fechaReserva, int monto, String estado, Date fechaCheckin,
            int abono, String runFuncionario, Date fechaCheckout, int multa, String runCliente, int idDepartamento) {
        this.cantDepartamento = cantDepartamento;
        this.fechaReserva = fechaReserva;
        this.monto = monto;
        this.estado = estado;
        this.fechaCheckin = fechaCheckin;
        this.abono = abono;
        this.runFuncionario = runFuncionario;
        this.fechaCheckout = fechaCheckout;
        this.multa = multa;
        this.runCliente = runCliente;
        this.idDepartamento = idDepartamento;
    }

    public int getCantDepartamento() {
        return cantDepartamento;
    }

    public void setCantDepartamento(int cantDepartamento) {
        this.cantDepartamento = cantDepartamento;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
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

    public Date getFechaCheckin() {
        return fechaCheckin;
    }

    public void setFechaCheckin(Date fechaCheckin) {
        this.fechaCheckin = fechaCheckin;
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

    public Date getFechaCheckout() {
        return fechaCheckout;
    }

    public void setFechaCheckout(Date fechaCheckout) {
        this.fechaCheckout = fechaCheckout;
    }

    public int getMulta() {
        return multa;
    }

    public void setMulta(int multa) {
        this.multa = multa;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getRunCliente() {
        return runCliente;
    }

    public void setRunCliente(String runCliente) {
        this.runCliente = runCliente;
    }

    

}
