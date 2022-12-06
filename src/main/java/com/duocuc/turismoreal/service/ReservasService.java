package com.duocuc.turismoreal.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import com.duocuc.turismoreal.dto.ReservaDTO;
import com.duocuc.turismoreal.request.ActualizarReserva;
import com.duocuc.turismoreal.request.RegistrarReserva;
import com.duocuc.turismoreal.request.RegistrarReservaServicio;
import com.duocuc.turismoreal.response.ReservaResponse;

@Service
public class ReservasService {

    @Autowired
    DataSource dataSource;

    public ReservaDTO crearReserva(RegistrarReserva registrarReserva) {

        ReservaDTO reserva = new ReservaDTO(0);

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_in_cant_depto", registrarReserva.getCantDepartamento(), Types.INTEGER)
                .addValue("p_in_fecha_reserva", registrarReserva.getFechaReserva(), Types.DATE)
                .addValue("p_in_monto", registrarReserva.getMonto(), Types.INTEGER)
                .addValue("p_estado", registrarReserva.getEstado(), Types.VARCHAR)
                .addValue("p_in_fecha_checkin", registrarReserva.getFechaCheckin(), Types.DATE)
                .addValue("p_in_abono", registrarReserva.getAbono(), Types.INTEGER)
                .addValue("p_in_funcionario", registrarReserva.getRunFuncionario(), Types.VARCHAR)
                .addValue("p_in_fecha_checkout", registrarReserva.getFechaCheckout(), Types.DATE)
                .addValue("p_in_multa", registrarReserva.getMulta(), Types.INTEGER)
                .addValue("p_in_id_departamento", registrarReserva.getIdDepartamento(), Types.INTEGER)
                .addValue("p_out_id_reserva", Types.INTEGER);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_CREATE_BOOKING")
                .declareParameters(new SqlParameter("p_in_cant_depto", Types.INTEGER),
                        new SqlParameter("p_in_fecha_reserva", Types.DATE),
                        new SqlParameter("p_in_monto", Types.INTEGER),
                        new SqlParameter("p_estado", Types.VARCHAR),
                        new SqlParameter("p_in_fecha_checkin", Types.DATE),
                        new SqlParameter("p_in_abono", Types.INTEGER),
                        new SqlParameter("p_in_funcionario", Types.VARCHAR),
                        new SqlParameter("p_in_fecha_checkout", Types.DATE),
                        new SqlParameter("p_in_multa", Types.INTEGER),
                        new SqlParameter("p_in_id_departamento", Types.INTEGER),
                        new SqlOutParameter("p_out_id_reserva", Types.INTEGER));

        Map<String, Object> out = jdbcCall.execute(in);

        if (!out.isEmpty()) {

            reserva.setIdReserva((Integer) out.get("p_out_id_reserva"));

        }

        return reserva;

    }

    public void crearReservaServicio(RegistrarReservaServicio reservaServicio) {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_in_id_servicio", reservaServicio.getIdServicio(), Types.INTEGER)
                .addValue("p_in_id_reserva", reservaServicio.getIdReserva(), Types.INTEGER)
                .addValue("p_in_fecha_inicio", reservaServicio.getFechaInicio(), Types.DATE)
                .addValue("p_in_hora_inicio", reservaServicio.getHoraInicio(), Types.VARCHAR)
                .addValue("p_in_fecha_termino", reservaServicio.getFechaTermino(), Types.DATE)
                .addValue("p_in_hora_termino", reservaServicio.getHoraTermino(), Types.VARCHAR);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_CREATE_SERVICE_BOOKING")
                .declareParameters(new SqlParameter("p_in_id_servicio", Types.INTEGER),
                        new SqlParameter("p_in_id_reserva", Types.INTEGER),
                        new SqlParameter("p_in_fecha_inicio", Types.DATE),
                        new SqlParameter("p_in_hora_inicio", Types.VARCHAR),
                        new SqlParameter("p_in_fecha_termino", Types.DATE),
                        new SqlParameter("p_in_hora_termino", Types.VARCHAR));

        jdbcCall.execute(in);

    }

    public List<ReservaResponse> listarReservasCliente(String runCliente) {

        List<ReservaResponse> reservas = new ArrayList<>();

        try {

            String query = "SELECT RC.CLIENTES_RUN, R.ID_RESERVA, R.FECHA_RESERVA, R.MONTO, R.CANT_DEPARTAMENTOS, R.ESTADO FROM RESERVAS R JOIN RESERVAS_CLIENTE RC ON R.ID_RESERVA = RC.ID_RESERVA"
                    + " " + "WHERE RC.CLIENTES_RUN = ?";

            PreparedStatement stm = dataSource.getConnection().prepareStatement(query);

            stm.setString(1, runCliente);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                ReservaResponse reserva = new ReservaResponse();

                reserva.setRunCliente(rs.getString("CLIENTES_RUN"));
                reserva.setIdReserva(rs.getInt("ID_RESERVA"));
                reserva.setFechaReserva(rs.getDate("FECHA_RESERVA"));
                reserva.setMonto(rs.getInt("MONTO"));
                reserva.setCantDepartamento(rs.getInt("CANT_DEPARTAMENTOS"));
                reserva.setEstado(rs.getString("ESTADO"));

                reservas.add(reserva);

            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return reservas;

    }

    public List<ReservaResponse> listarReservas() {

        List<ReservaResponse> reservas = new ArrayList<>();

        try {

            String query = "SELECT RC.CLIENTES_RUN, R.ID_RESERVA, R.FECHA_RESERVA, R.CANT_DEPARTAMENTOS, R.MONTO, R.ESTADO FROM RESERVAS R JOIN RESERVAS_CLIENTE RC ON R.ID_RESERVA = RC.ID_RESERVA";

            PreparedStatement stm = dataSource.getConnection().prepareStatement(query);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                ReservaResponse reserva = new ReservaResponse();

                reserva.setRunCliente(rs.getString("CLIENTES_RUN"));
                reserva.setIdReserva(rs.getInt("ID_RESERVA"));
                reserva.setFechaReserva(rs.getDate("FECHA_RESERVA"));
                reserva.setCantDepartamento(rs.getInt("CANT_DEPARTAMENTOS"));
                reserva.setMonto(rs.getInt("MONTO"));
                reserva.setEstado(rs.getString("ESTADO"));

                reservas.add(reserva);

            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return reservas;

    }

    public void borrarReserva(int idReserva) {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_id_reserva", idReserva, Types.INTEGER);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_DELETE_BOOKING")
                .declareParameters(new SqlParameter("p_id_reserva", Types.INTEGER));

        jdbcCall.execute(in);

    }

    public void actualizarReserva(ActualizarReserva actualizarReserva) {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_id_reserva", actualizarReserva.getIdReserva(), Types.INTEGER)
                .addValue("p_fecha_reserva", actualizarReserva.getFechaReserva(), Types.DATE)
                .addValue("p_cant_depto", actualizarReserva.getCantDeptos(), Types.INTEGER)
                .addValue("p_monto", actualizarReserva.getMonto(), Types.INTEGER)
                .addValue("p_estado", actualizarReserva.getEstado(), Types.VARCHAR);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_UPDATE_BOOKING")
                .declareParameters(new SqlParameter("p_id_reserva", Types.INTEGER),
                        new SqlParameter("p_fecha_reserva", Types.DATE),
                        new SqlParameter("p_cant_depto", Types.INTEGER),
                        new SqlParameter("p_monto", Types.INTEGER),
                        new SqlParameter("p_estado", Types.VARCHAR));

        jdbcCall.execute(in);

    }
}
