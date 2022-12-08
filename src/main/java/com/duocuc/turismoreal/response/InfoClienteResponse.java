package com.duocuc.turismoreal.response;

public class InfoClienteResponse {
    
    private String run;
    private String nombreUsuario;
    private boolean esFrecuente;
    
    public InfoClienteResponse(String run, String nombreUsuario, boolean esFrecuente) {
        this.run = run;
        this.nombreUsuario = nombreUsuario;
        this.esFrecuente = esFrecuente;
    }

    public InfoClienteResponse() {
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public boolean isEsFrecuente() {
        return esFrecuente;
    }

    public void setEsFrecuente(boolean esFrecuente) {
        this.esFrecuente = esFrecuente;
    }

    

}
