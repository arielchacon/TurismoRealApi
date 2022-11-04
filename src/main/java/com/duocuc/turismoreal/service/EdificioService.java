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

import com.duocuc.turismoreal.request.ActualizarEdificio;
import com.duocuc.turismoreal.request.RegistroEdificio;
import com.duocuc.turismoreal.response.EdificioResponse;

@Service
public class EdificioService {

        @Autowired
        DataSource dataSource;

        public void crearEdificio(RegistroEdificio registroEdificio) {

                SqlParameterSource in = new MapSqlParameterSource()
                                .addValue("p_direccion", registroEdificio.getDireccion(), Types.VARCHAR)
                                .addValue("p_estado", registroEdificio.getEstado(), Types.VARCHAR)
                                .addValue("p_id_comuna", registroEdificio.getId_comuna(), Types.INTEGER)
                                .addValue("p_nombre", registroEdificio.getNombre(), Types.VARCHAR);

                SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                                .withProcedureName("SP_CREATE_BUILDING")
                                .declareParameters(new SqlParameter("p_direccion", Types.VARCHAR),
                                                new SqlParameter("p_estado", Types.VARCHAR),
                                                new SqlParameter("p_id_comuna", Types.INTEGER),
                                                new SqlParameter("p_nombre", Types.VARCHAR));

                jdbcCall.execute(in);

        }

        public void actualizarEdificio(int idEdificio, ActualizarEdificio actualizarEdificio) {

                SqlParameterSource in = new MapSqlParameterSource()
                                .addValue("p_id_edificio", idEdificio, Types.INTEGER)
                                .addValue("p_direccion", actualizarEdificio.getDireccion(), Types.VARCHAR)
                                .addValue("p_estado", actualizarEdificio.getEstado(), Types.VARCHAR)
                                .addValue("p_id_comuna", actualizarEdificio.getId_comuna(), Types.INTEGER)
                                .addValue("p_nombre", actualizarEdificio.getNombre(), Types.VARCHAR);

                SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                                .withProcedureName("SP_UPDATE_BUILDING")
                                .declareParameters(new SqlParameter("p_id_edificio", Types.INTEGER),
                                                new SqlParameter("p_direccion", Types.VARCHAR),
                                                new SqlParameter("p_estado", Types.VARCHAR),
                                                new SqlParameter("p_id_comuna", Types.INTEGER),
                                                new SqlParameter("p_nombre", Types.VARCHAR));

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

        public List<EdificioResponse> listarEdificios(int idComuna) {

                List<EdificioResponse> edificios = new ArrayList<>();

                try {

                        String query = "SELECT ID_EDIFICIO, DIRECCION, ESTADO, ID_COMUNA, NOMBRE FROM EDIFICIOS WHERE ID_COMUNA= ?";
                        PreparedStatement stm = dataSource.getConnection().prepareStatement(query);

                        stm.setInt(1, idComuna);

                        ResultSet rs = stm.executeQuery();

                        while (rs.next()) {

                                EdificioResponse edificio = new EdificioResponse(rs.getInt("ID_EDIFICIO"), 
                                rs.getString("NOMBRE"), rs.getString("DIRECCION"), rs.getInt("ID_COMUNA"), 
                                rs.getString("ESTADO"));

                                edificios.add(edificio);
                        }

                } catch (Exception e) {

                        e.printStackTrace();
                }

                return edificios;

        }

}
