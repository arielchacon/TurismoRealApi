package com.duocuc.turismoreal.request;

import java.sql.Date;

public class RegistrarInventario {

    private String observacion;
    private Date fechaInventario;
    private String estado;
    private int idDepartamento;

    public RegistrarInventario(String observacion, Date fechaInventario, String estado, int idDepartamento) {
        this.observacion = observacion;
        this.fechaInventario = fechaInventario;
        this.estado = estado;
        this.idDepartamento = idDepartamento;
    }

    public RegistrarInventario(){}

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFechaInventario() {
        return fechaInventario;
    }

    public void setFechaInventario(Date fechaInventario) {
        this.fechaInventario = fechaInventario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    
}
