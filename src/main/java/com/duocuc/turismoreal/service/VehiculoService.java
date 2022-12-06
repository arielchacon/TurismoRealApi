package com.duocuc.turismoreal.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duocuc.turismoreal.request.ActualizarVehiculo;
import com.duocuc.turismoreal.request.RegistrarVehiculo;
import com.duocuc.turismoreal.response.VehiculoResponse;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

@Service
public class VehiculoService {

    @Autowired
    DataSource dataSource;

    public void crearVehiculo(RegistrarVehiculo registrarVehiculo) {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_in_patente", registrarVehiculo.getPatente(), Types.VARCHAR)
                .addValue("p_in_annio", registrarVehiculo.getAnnio(), Types.VARCHAR)
                .addValue("p_in_id_modelo", registrarVehiculo.getIdModelo(), Types.INTEGER)
                .addValue("p_in_id_color", registrarVehiculo.getIdColor(), Types.INTEGER)
                .addValue("p_in_nombre_conductor", registrarVehiculo.getNombreConductor(), Types.VARCHAR);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_CREATE_VEHICLE")
                .declareParameters(new SqlParameter("p_in_patente", Types.VARCHAR),
                        new SqlParameter("p_in_annio", Types.VARCHAR),
                        new SqlParameter("p_in_id_modelo", Types.INTEGER),
                        new SqlParameter("p_in_id_color", Types.INTEGER),
                        new SqlParameter("p_in_nombre_conductor", Types.VARCHAR));

        jdbcCall.execute(in);

    }

    public void actualizarVehiculo(ActualizarVehiculo actualizarVehiculo) {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_in_id_vehiculo", actualizarVehiculo.getIdVehiculo(), Types.INTEGER)
                .addValue("p_in_patente", actualizarVehiculo.getPatente(), Types.VARCHAR)
                .addValue("p_in_annio", actualizarVehiculo.getAnnio(), Types.VARCHAR)
                .addValue("p_in_id_modelo", actualizarVehiculo.getIdModelo(), Types.INTEGER)
                .addValue("p_in_id_color", actualizarVehiculo.getIdColor(), Types.INTEGER)
                .addValue("p_in_nombre_conductor", actualizarVehiculo.getNombreConductor(), Types.VARCHAR);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_UPDATE_VEHICLE")
                .declareParameters(new SqlParameter("p_in_id_vehiculo", Types.INTEGER),
                        new SqlParameter("p_in_patente", Types.VARCHAR),
                        new SqlParameter("p_in_annio", Types.VARCHAR),
                        new SqlParameter("p_in_id_modelo", Types.INTEGER),
                        new SqlParameter("p_in_id_color", Types.INTEGER),
                        new SqlParameter("p_in_nombre_conductor", Types.VARCHAR));

        jdbcCall.execute(in);

    }

    public VehiculoResponse buscarVehiculo(String patente) {

        VehiculoResponse vehiculo = new VehiculoResponse();

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_in_patente", patente, Types.VARCHAR)
                .addValue("p_out_id_vehiculo", Types.INTEGER)
                .addValue("p_out_patente", Types.VARCHAR)
                .addValue("p_out_annio", Types.VARCHAR)
                .addValue("p_out_id_modelo", Types.INTEGER)
                .addValue("p_out_id_color", Types.INTEGER)
                .addValue("p_out_nombre_conductor", Types.VARCHAR);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_SEARCH_VEHICLE")
                .declareParameters(new SqlParameter("p_in_patente", Types.VARCHAR),
                        new SqlOutParameter("p_out_id_vehiculo", Types.INTEGER),
                        new SqlOutParameter("p_out_patente", Types.VARCHAR),
                        new SqlOutParameter("p_out_annio", Types.VARCHAR),
                        new SqlOutParameter("p_out_id_modelo", Types.INTEGER),
                        new SqlOutParameter("p_out_id_color", Types.INTEGER),
                        new SqlOutParameter("p_out_nombre_conductor", Types.VARCHAR));

        Map<String, Object> out = jdbcCall.execute(in);

        if (!out.isEmpty()) {

            vehiculo.setIdVehiculo((Integer) out.get("p_out_id_vehiculo"));
            vehiculo.setPatente((String) out.get("p_out_patente"));
            vehiculo.setAnnio((String) out.get("p_out_annio"));
            vehiculo.setIdModelo((Integer) out.get("p_out_id_modelo"));
            vehiculo.setIdColor((Integer) out.get("p_out_id_color"));
            vehiculo.setNombreConductor((String) out.get("p_out_nombre_conductor"));

        }

        return vehiculo;

    }

    public void borrarVehiculo(int idVehiculo) {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_id_vehiculo", idVehiculo, Types.INTEGER);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_DELETE_VEHICLE")
                .declareParameters(new SqlParameter("p_id_vehiculo", Types.INTEGER));

        jdbcCall.execute(in);

    }

    public List<VehiculoResponse> listarVehiculos() {

        List<VehiculoResponse> vehiculos = new ArrayList<>();

        try {

            String query = "SELECT ID_VEHICULO, PATENTE, ANNIO, ID_MODELO, ID_COLOR, NOMBRE_CONDUCTOR FROM VEHICULOS";

            PreparedStatement stm = dataSource.getConnection().prepareStatement(query);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                VehiculoResponse vehiculo = new VehiculoResponse();

                vehiculo.setIdVehiculo(rs.getInt("ID_VEHICULO"));
                vehiculo.setPatente(rs.getString("PATENTE"));
                vehiculo.setAnnio(rs.getString("ANNIO"));
                vehiculo.setIdModelo(rs.getInt("ID_MODELO"));
                vehiculo.setIdColor(rs.getInt("ID_COLOR"));
                vehiculo.setNombreConductor(rs.getString("NOMBRE_CONDUCTOR"));

                vehiculos.add(vehiculo);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return vehiculos;

    }

}
