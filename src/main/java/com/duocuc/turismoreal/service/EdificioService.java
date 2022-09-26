package com.duocuc.turismoreal.service;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import com.duocuc.turismoreal.request.ActualizarEdificio;
import com.duocuc.turismoreal.request.RegistroEdificio;

@Service
public class EdificioService {

    @Autowired
    DataSource dataSource;

    public void crearEdificio(RegistroEdificio registroEdificio) {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_direccion", registroEdificio.getDireccion(), Types.VARCHAR)
                .addValue("p_estado", registroEdificio.getEstado(), Types.VARCHAR)
                .addValue("p_id_comuna", registroEdificio.getId_comuna(), Types.INTEGER);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_CREATE_BUILDING")
                .declareParameters(new SqlParameter("p_direccion", Types.VARCHAR),
                        new SqlParameter("p_estado", Types.VARCHAR),
                        new SqlParameter("p_id_comuna", Types.INTEGER));

        jdbcCall.execute(in);

    }

    public void actualizarEdificio(int idEdificio, ActualizarEdificio actualizarEdificio) {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_id_edificio", idEdificio, Types.INTEGER)
                .addValue("p_direccion", actualizarEdificio.getDireccion(), Types.VARCHAR)
                .addValue("p_estado", actualizarEdificio.getEstado(), Types.VARCHAR)
                .addValue("p_id_comuna", actualizarEdificio.getId_comuna(), Types.INTEGER);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_UPDATE_BUILDING")
                .declareParameters(new SqlParameter("p_id_edificio", Types.INTEGER),
                        new SqlParameter("p_direccion", Types.VARCHAR),
                        new SqlParameter("p_estado", Types.VARCHAR),
                        new SqlParameter("p_id_comuna", Types.INTEGER));

        jdbcCall.execute(in);

    }

    public void eliminarEdificio(int idEdificio) {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_id_edificio", idEdificio, Types.INTEGER);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_DELETE_BUILDING")
                .declareParameters(new SqlParameter("p_id_edificio", Types.INTEGER));

        jdbcCall.execute(in);

    }

}
