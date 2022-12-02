package com.duocuc.turismoreal.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * RegistroCliente - Clase con la estructura necesaria para el request de registro
 */
public class RegistroCliente {

    @JsonProperty("run")
    private String run;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("appaterno")
    private String appaterno;

    @JsonProperty("appaterno")
    private String apmaterno;
    
    @JsonProperty("genero")
    private String genero;

    @JsonProperty("direccion")
    private String direccion;

    @JsonProperty("fechaNacimiento")
    private Date fechaNacimiento;

    @JsonProperty("telefono")
    private String telefono;

    @JsonProperty("telefono2")
    private String telefono_2;

    @JsonProperty("correo")
    private String correo;

    @JsonProperty("esFrecuente")
    private Boolean esFrecuente;

    @JsonProperty("idComuna")
    private int idComuna;

    @JsonProperty("nombreUsuario")
    private String nombreUsuario;

    @JsonProperty("password")
    private String password;

    public RegistroCliente(String run, String nombre, String appaterno, String apmaterno, String genero,
            String direccion,
            Date fechaNacimiento, String telefono, String telefono_2, String correo, Boolean esFrecuente,
            int idComuna, String nombreUsuario, String password) {
        this.run = run;
        this.nombre = nombre;
        this.appaterno = appaterno;
        this.apmaterno = apmaterno;
        this.genero = genero;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.telefono_2 = telefono_2;
        this.correo = correo;
        this.esFrecuente = esFrecuente;
        this.idComuna = idComuna;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }

    public RegistroCliente(){}
    

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

    public String getAppaterno() {
        return appaterno;
    }

    public void setAppaterno(String appaterno) {
        this.appaterno = appaterno;
    }

    public String getApmaterno() {
        return apmaterno;
    }

    public void setApmaterno(String apmaterno) {
        this.apmaterno = apmaterno;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono_2() {
        return telefono_2;
    }

    public void setTelefono_2(String telefono_2) {
        this.telefono_2 = telefono_2;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Boolean getEsFrecuente() {
        return esFrecuente;
    }

    public void setEsFrecuente(Boolean esFrecuente) {
        this.esFrecuente = esFrecuente;
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
