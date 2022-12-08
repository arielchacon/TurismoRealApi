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

import com.duocuc.turismoreal.request.ActualizarServicio;
import com.duocuc.turismoreal.request.RegistrarTransporte;
import com.duocuc.turismoreal.request.RegistroServicio;
import com.duocuc.turismoreal.response.ServicioResponse;

@Service
public class ServiciosService {

    @Autowired
    DataSource dataSource;

    public void agregarServicio(RegistroServicio registroServicio) {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_descripcion", registroServicio.getDescripcion(), Types.VARCHAR)
                .addValue("p_estado", registroServicio.getEstado(), Types.VARCHAR)
                .addValue("p_monto", registroServicio.getMonto(), Types.INTEGER);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_CREATE_SERVICE")
                .declareParameters(new SqlParameter("p_descripcion", Types.VARCHAR),
                        new SqlParameter("p_estado", Types.VARCHAR),
                        new SqlParameter("p_monto", Types.INTEGER));

        jdbcCall.execute(in);

    }

    public void actualizarServicio(ActualizarServicio actualizarServicio) {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_id_servicio", actualizarServicio.getIdServicio(), Types.INTEGER)
                .addValue("p_descripcion", actualizarServicio.getDescripcion(), Types.VARCHAR)
                .addValue("p_estado", actualizarServicio.getEstado(), Types.VARCHAR)
                .addValue("p_monto", actualizarServicio.getMonto(), Types.INTEGER);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_UPDATE_SERVICE")
                .declareParameters(new SqlParameter("p_id_servicio", Types.INTEGER),
                        new SqlParameter("p_descripcion", Types.VARCHAR),
                        new SqlParameter("p_estado", Types.VARCHAR),
                        new SqlParameter("p_monto", Types.INTEGER));

        jdbcCall.execute(in);

    }

    public void borrarServicio(int idServicio) {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_id_servicio", idServicio, Types.INTEGER);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_DELETE_SERVICE")
                .declareParameters(new SqlParameter("p_id_servicio", Types.VARCHAR));

        jdbcCall.execute(in);

    }

    public List<ServicioResponse> listarServicios() {

        List<ServicioResponse> servicios = new ArrayList<>();

        try {

            String query = "SELECT ID_SERVICIO, DESCRIPCION, ESTADO, MONTO FROM SERVICIOS";

            PreparedStatement stm = dataSource.getConnection().prepareStatement(query);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

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

    public void registrarTransporte(RegistrarTransporte registrarTransporte) {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_in_direccion_desde", registrarTransporte.getDireccionDesde(), Types.VARCHAR)
                .addValue("p_in_direccion_hasta", registrarTransporte.getDireccionHasta(), Types.VARCHAR)
                .addValue("p_in_hora_inicio", registrarTransporte.getHoraInicio(), Types.VARCHAR)
                .addValue("p_in_fecha_inicio", registrarTransporte.getFechaInicio(), Types.DATE)
                .addValue("p_in_monto", registrarTransporte.getMonto(), Types.INTEGER)
                .addValue("p_in_estado", registrarTransporte.getEstado(), Types.VARCHAR)
                .addValue("p_in_id_vehiculo", registrarTransporte.getIdVehiculo(), Types.INTEGER)
                .addValue("p_in_id_reserva", registrarTransporte.getIdReserva());

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_CREATE_TRANSPORTATION")
                .declareParameters(new SqlParameter("p_in_direccion_desde", Types.VARCHAR),
                        new SqlParameter("p_in_direccion_hasta", Types.VARCHAR),
                        new SqlParameter("p_in_hora_inicio", Types.VARCHAR),
                        new SqlParameter("p_in_fecha_inicio", Types.DATE),
                        new SqlParameter("p_in_monto", Types.INTEGER),
                        new SqlParameter("p_in_estado", Types.VARCHAR),
                        new SqlParameter("p_in_id_vehiculo", Types.INTEGER),
                        new SqlParameter("p_in_id_reserva", Types.INTEGER));

        jdbcCall.execute(in);

    }

}
