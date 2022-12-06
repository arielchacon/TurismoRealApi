package com.duocuc.turismoreal.response;

import java.sql.Date;

public class MantenimientoResponse {
    
    private int idMantencion;
    private String descripcion;
    private String estado;
    private Date fechaMantencion;
    private int costo;
    private int idDepartamento;
    
    public MantenimientoResponse(int idMantencion, String descripcion, String estado, Date fechaMantencion, int costo,
            int idDepartamento) {
        this.idMantencion = idMantencion;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaMantencion = fechaMantencion;
        this.costo = costo;
        this.idDepartamento = idDepartamento;
    }

    public MantenimientoResponse() {
    }

    public int getIdMantencion() {
        return idMantencion;
    }

    public void setIdMantencion(int idMantencion) {
        this.idMantencion = idMantencion;
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

    public Date getFechaMantencion() {
        return fechaMantencion;
    }

    public void setFechaMantencion(Date fechaMantencion) {
        this.fechaMantencion = fechaMantencion;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    

}
