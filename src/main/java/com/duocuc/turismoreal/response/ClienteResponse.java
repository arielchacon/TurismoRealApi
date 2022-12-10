package com.duocuc.turismoreal.response;

import java.sql.Date;

public class ClienteResponse {
    
    private String run;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String genero;
    private String direccion;
    private Date fechaNacimiento;
    private String telefono;
    private String telefono2;
    private String correoElectronico;
    private int idComuna;
    private String nombreUsuario;
    
    public ClienteResponse(String run, String nombre, String apPaterno, String apMaterno, String genero,
            String direccion, Date fechaNacimiento, String telefono, String telefono2, String correoElectronico, int idComuna, String nombreUsuario) {
        this.run = run;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.genero = genero;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.telefono2 = telefono2;
        this.correoElectronico = correoElectronico;
        this.idComuna = idComuna;
        this.nombreUsuario = nombreUsuario;
    }

    public ClienteResponse() {
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public int getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(int idComuna) {
        this.idComuna = idComuna;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    
}
