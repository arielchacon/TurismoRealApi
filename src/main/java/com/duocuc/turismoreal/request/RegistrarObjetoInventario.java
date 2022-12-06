package com.duocuc.turismoreal.request;

public class RegistrarObjetoInventario {
    
    private int idInventario;
    private String sku;
    
    public RegistrarObjetoInventario(int idInventario, String sku) {
        this.idInventario = idInventario;
        this.sku = sku;
    }

    public RegistrarObjetoInventario(){}

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

}
