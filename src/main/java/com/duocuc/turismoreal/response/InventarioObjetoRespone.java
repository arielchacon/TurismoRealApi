package com.duocuc.turismoreal.response;

import java.util.List;

public class InventarioObjetoRespone {
    
    private int idInventario;
    private List<ObjetoResponse> objetos;

    public InventarioObjetoRespone(int idInventario, List<ObjetoResponse> objetos) {
        this.idInventario = idInventario;
        this.objetos = objetos;
    }

    public InventarioObjetoRespone() {
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public List<ObjetoResponse> getObjetos() {
        return objetos;
    }

    public void setObjetos(List<ObjetoResponse> objetos) {
        this.objetos = objetos;
    }

}
