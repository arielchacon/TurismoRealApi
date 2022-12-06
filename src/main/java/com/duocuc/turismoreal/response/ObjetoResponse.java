package com.duocuc.turismoreal.response;

public class ObjetoResponse {
    
    private String sku;
    private String nombreObjeto;
    private int precio;
    private int cantidad;
    private String estado;
    private int idMarca;
    
    public ObjetoResponse(String sku, String nombreObjeto, int precio, int cantidad, String estado, int idMarca) {
        this.sku = sku;
        this.nombreObjeto = nombreObjeto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.estado = estado;
        this.idMarca = idMarca;
    }

    public ObjetoResponse() {
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNombreObjeto() {
        return nombreObjeto;
    }

    public void setNombreObjeto(String nombreObjeto) {
        this.nombreObjeto = nombreObjeto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    

}
