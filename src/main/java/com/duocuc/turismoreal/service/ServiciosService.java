package com.duocuc.turismoreal.service;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import com.duocuc.turismoreal.request.RegistroServicio;

@Service
public class ServiciosService {
    
    @Autowired
    DataSource dataSource;

    public String agregarServicio(RegistroServicio registroServicio){

        String message;

        try {

        SqlParameterSource in = new MapSqlParameterSource()
                 .addValue("p_descripcion", registroServicio.getDescripcion(), Types.VARCHAR)
                 .addValue("p_estado",registroServicio.getEstado(), Types.VARCHAR)
                 .addValue("p_monto", registroServicio.getMonto(), Types.INTEGER);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                 .withProcedureName("SP_CREATE_SERVICE")
                 .declareParameters(new SqlParameter("p_descripcion", Types.VARCHAR),
                                    new SqlParameter("p_estado", Types.VARCHAR),
                                    new SqlParameter("p_monto", Types.INTEGER));

        jdbcCall.execute(in);

        message = "Ok";

        return message;
            
        } catch (Exception e) {
           
            message = e.getMessage();

            return message;

        }

    }

}
