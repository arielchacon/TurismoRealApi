package com.duocuc.turismoreal.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import com.duocuc.turismoreal.request.RegistroServicio;
import com.duocuc.turismoreal.response.ServicioResponse;

@Service
public class ServiciosService {
    
    @Autowired
    DataSource dataSource;

    public void agregarServicio(RegistroServicio registroServicio){

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

    }

    public void borrarServicio(int idServicio){

        SqlParameterSource in = new MapSqlParameterSource()
                 .addValue("p_id_servicio", idServicio, Types.INTEGER);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                 .withProcedureName("SP_DELETE_SERVICE")
                 .declareParameters(new SqlParameter("p_id_servicio", Types.VARCHAR));

        jdbcCall.execute(in);

    }

    public List<ServicioResponse> listarServicios(){

        List<ServicioResponse> servicios = new ArrayList<>();

        try {
            
            String query = "SELECT ID_SERVICIO, DESCRIPCION, ESTADO, MONTO FROM SERVICIOS";

            PreparedStatement stm = dataSource.getConnection().prepareStatement(query);
            ResultSet rs = stm.executeQuery();

            while(rs.next()){

                ServicioResponse servicio = new ServicioResponse(rs.getInt("ID_SERVICIO"), 
                                                                 rs.getString("DESCRIPCION"),
                                                                 rs.getString("ESTADO"),
                                                                 rs.getInt("MONTO"));

                servicios.add(servicio);

            }

            rs.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return servicios;

    }

}
