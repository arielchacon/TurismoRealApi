package com.duocuc.turismoreal.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.duocuc.turismoreal.request.RegistroCliente;

public class ClienteService {
    
    @Autowired
    DataSource dataSource;

    public String registrarCliente(RegistroCliente registroCliente){

        try {
            
            SqlParameterSource in = new MapSqlParameterSource().addValue("p_run", registroCliente.getRun())
                                                           .addValue("p_nombre", registroCliente.getNombre())
                                                           .addValue("p_appaterno", registroCliente.getAppaterno())
                                                           .addValue("p_apmaterno", registroCliente.getApmaterno())
                                                           .addValue("p_genero", registroCliente.getGenero())
                                                           .addValue("p_direccion", registroCliente.getDireccion())
                                                           .addValue("p_fecha_nacimiento", registroCliente.getFechaNacimiento())
                                                           .addValue("p_telefono", registroCliente.getTelefono())
                                                           .addValue("p_telefono_2", registroCliente.getTelefono_2())
                                                           .addValue("p_correo", registroCliente.getCorreo())
                                                           .addValue("p_es_frecuente", registroCliente.getEsFrecuente())
                                                           .addValue("p_id_comuna", registroCliente.getIdComuna())
                                                           .addValue("p_nombre_usuario", registroCliente.getNombreUsuario())
                                                           .addValue("p_password", registroCliente.getPassword());

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("SP_CREATE_CLIENT");
        
        jdbcCall.execute(in);

        return "Cliente registrado";

        } catch (Exception e) {
            
            return e.getMessage();

        }

    }

}
