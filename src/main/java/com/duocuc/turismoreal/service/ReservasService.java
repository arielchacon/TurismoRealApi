package com.duocuc.turismoreal.service;

import java.sql.Blob;
import java.sql.Date;
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
import com.duocuc.turismoreal.request.ActualizarCheckIn;
import com.duocuc.turismoreal.request.ActualizarCheckOut;
import com.duocuc.turismoreal.request.ActualizarReserva;
import com.duocuc.turismoreal.request.RegistrarReserva;
import com.duocuc.turismoreal.request.RegistrarReservaServicio;
import com.duocuc.turismoreal.request.RegistrarServicioTransporte;
import com.duocuc.turismoreal.response.CheckInResponse;
import com.duocuc.turismoreal.response.CheckOutResponse;
import com.duocuc.turismoreal.response.ReservaDepartamentoResponse;
import com.duocuc.turismoreal.response.ReservaResponse;
import com.duocuc.turismoreal.response.ReservaServicioResponse;
import com.duocuc.turismoreal.response.ReservaTransporteResponse;

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

    public void crearReservaTransporte(RegistrarServicioTransporte transporteServicio){

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_in_id_reserva", transporteServicio.getIdReserva(), Types.INTEGER)
                .addValue("p_in_id_transporte", transporteServicio.getIdTransporte(), Types.INTEGER);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_CREATE_TRANSPORTATION_BOOKING")
                .declareParameters(new SqlParameter("p_in_id_reserva", Types.INTEGER),
                        new SqlParameter("p_in_id_transporte", Types.INTEGER));

        jdbcCall.execute(in);

    }

    public List<ReservaTransporteResponse> listarReservaTransporte(int idReserva){

        List<ReservaTransporteResponse> reservas = new ArrayList<>();

        try {

            String query = "SELECT TRANSPORTE.ID_TRANSPORTE, DIRECCION_DESDE, DIRECCION_HASTA, HORA_INICIO, FECHA_INICIO,"
            +"MONTO, ESTADO, ID_VEHICULO, ID_RESERVA FROM TRANSPORTE JOIN TRANSPORTES_RESERVAS ON TRANSPORTE.ID_TRANSPORTE = TRANSPORTES_RESERVAS.ID_TRANSPORTE WHERE ID_RESERVA = ?";

            PreparedStatement stm = dataSource.getConnection().prepareStatement(query);

            stm.setInt(1, idReserva);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                ReservaTransporteResponse reserva = new ReservaTransporteResponse();

                reserva.setIdTransporte(rs.getInt("ID_TRANSPORTE"));
                reserva.setDireccionDesde(rs.getString("DIRECCION_DESDE"));
                reserva.setDireccionHasta(rs.getString("DIRECCION_HASTA"));
                reserva.setHoraInicio(rs.getString("HORA_INICIO"));
                reserva.setFechaInicio(rs.getDate("FECHA_INICIO"));
                reserva.setMonto(rs.getInt("MONTO"));
                reserva.setEstado(rs.getString("ESTADO"));
                reserva.setIdVehiculo(rs.getInt("ID_VEHICULO"));
                reserva.setIdReserva(rs.getInt("ID_RESERVA"));

                reservas.add(reserva);

            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return reservas;

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

    public ReservaResponse buscarReservaPorId(int idReserva) {

        ReservaResponse reserva = new ReservaResponse();

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_in_id_reserva", idReserva, Types.INTEGER)
                .addValue("p_out_id_reserva", Types.INTEGER)
                .addValue("p_out_cant_depto", Types.INTEGER)
                .addValue("p_out_fecha_reserva", Types.DATE)
                .addValue("p_out_monto", Types.INTEGER)
                .addValue("p_out_estado", Types.VARCHAR)
                .addValue("p_out_run_cliente", Types.VARCHAR);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_SEARCH_BOOKING_BY_ID")
                .declareParameters(new SqlParameter("p_in_id_reserva", Types.INTEGER),
                        new SqlOutParameter("p_out_id_reserva", Types.INTEGER),
                        new SqlOutParameter("p_out_cant_depto", Types.INTEGER),
                        new SqlOutParameter("p_out_fecha_reserva", Types.DATE),
                        new SqlOutParameter("p_out_monto", Types.INTEGER),
                        new SqlOutParameter("p_out_estado", Types.VARCHAR),
                        new SqlOutParameter("p_out_run_cliente", Types.VARCHAR));

        Map<String, Object> out = jdbcCall.execute(in);

        if (!out.isEmpty()) {

            reserva.setIdReserva((Integer) out.get("p_in_id_reserva"));
            reserva.setCantDepartamento((Integer) out.get("p_out_cant_depto"));
            reserva.setFechaReserva((Date) out.get("p_out_fecha_reserva"));
            reserva.setMonto((Integer) out.get("p_out_monto"));
            reserva.setEstado((String) out.get("p_out_estado"));
            reserva.setRunCliente((String) out.get("p_out_run_cliente"));

        }

        return reserva;

    }

    public ReservaDepartamentoResponse buscarReservaDepartamento(int idReserva, int idDepartamento) {

        ReservaDepartamentoResponse reservaDepartamento = new ReservaDepartamentoResponse();

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_in_id_reserva", idReserva, Types.INTEGER)
                .addValue("p_in_id_departamento", idDepartamento, Types.INTEGER)
                .addValue("p_out_id_departamento", Types.INTEGER)
                .addValue("p_out_num_depto", Types.INTEGER)
                .addValue("p_out_habitaciones", Types.INTEGER)
                .addValue("p_out_banios", Types.INTEGER)
                .addValue("p_out_estado", Types.VARCHAR)
                .addValue("p_out_valor", Types.INTEGER)
                .addValue("p_out_imagen", Types.BLOB)
                .addValue("p_out_dividendo", Types.INTEGER)
                .addValue("p_out_contribucion", Types.INTEGER)
                .addValue("p_out_disponibilidad", Types.VARCHAR)
                .addValue("p_out_id_edificio", Types.INTEGER)
                .addValue("p_out_funcionario", Types.VARCHAR)
                .addValue("p_out_id_reserva", Types.INTEGER);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_SEARCH_BOOKING_DEPARTMENT")
                .declareParameters(new SqlParameter("p_in_id_reserva", Types.INTEGER),
                        new SqlParameter("p_in_id_departamento", Types.INTEGER),
                        new SqlOutParameter("p_out_id_departamento", Types.INTEGER),
                        new SqlOutParameter("p_out_num_depto", Types.INTEGER),
                        new SqlOutParameter("p_out_habitaciones", Types.INTEGER),
                        new SqlOutParameter("p_out_banios", Types.INTEGER),
                        new SqlOutParameter("p_out_estado", Types.VARCHAR),
                        new SqlOutParameter("p_out_valor", Types.INTEGER),
                        new SqlOutParameter("p_out_imagen", Types.BLOB),
                        new SqlOutParameter("p_out_dividendo", Types.INTEGER),
                        new SqlOutParameter("p_out_contribucion", Types.INTEGER),
                        new SqlOutParameter("p_out_disponibilidad", Types.VARCHAR),
                        new SqlOutParameter("p_out_id_edificio", Types.INTEGER),
                        new SqlOutParameter("p_out_funcionario", Types.VARCHAR),
                        new SqlOutParameter("p_out_id_resreva", Types.INTEGER));

        Map<String, Object> out = jdbcCall.execute(in);

        if (!out.isEmpty()) {

            reservaDepartamento.setIdDepartamento((Integer) out.get("p_out_id_departamento"));
            reservaDepartamento.setNumeroDepartamento((Integer) out.get("p_out_num_depto"));
            reservaDepartamento.setNumeroHabitaciones((Integer) out.get("p_out_habitaciones"));
            reservaDepartamento.setNumeroBanios((Integer) out.get("p_out_banios"));
            reservaDepartamento.setEstado((String) out.get("p_out_estado"));
            reservaDepartamento.setValor((Integer) out.get("p_out_valor"));
            reservaDepartamento.setImagen((Blob) out.get("p_out_imagen"));
            reservaDepartamento.setDividendo((Integer) out.get("p_out_dividendo"));
            reservaDepartamento.setContribucion((Integer) out.get("p_out_contribucion"));
            reservaDepartamento.setDisponibilidad((String) out.get("p_out_disponibilidad"));
            reservaDepartamento.setIdEdificio((Integer) out.get("p_out_id_edificio"));
            reservaDepartamento.setRunFuncinoario((String) out.get("p_out_funcionario"));
            reservaDepartamento.setIdReserva((Integer) out.get("p_out_id_reserva"));

        }

        return reservaDepartamento;

    }

    public ReservaServicioResponse buscarReservaServicio(int idReserva, int idServicio) {

        ReservaServicioResponse reservaServicio = new ReservaServicioResponse();

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_in_id_reserva", idReserva, Types.INTEGER)
                .addValue("p_in_id_servicio", idServicio, Types.INTEGER)
                .addValue("p_out_id_servicio", Types.INTEGER)
                .addValue("p_out_descripcion", Types.VARCHAR)
                .addValue("p_out_estado", Types.VARCHAR)
                .addValue("p_out_monto", Types.INTEGER)
                .addValue("p_out_id_reserva", Types.INTEGER)
                .addValue("p_out_fecha_inicio", Types.DATE)
                .addValue("p_out_hora_inicio", Types.VARCHAR)
                .addValue("p_out_fecha_termino", Types.DATE)
                .addValue("p_out_hora_termino", Types.VARCHAR);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_SEARCH_BOOKING_SERVICE")
                .declareParameters(new SqlParameter("p_in_id_reserva", Types.INTEGER),
                        new SqlParameter("p_in_id_servicio", Types.INTEGER),
                        new SqlOutParameter("p_out_id_servicio", Types.INTEGER),
                        new SqlOutParameter("p_out_descripcion", Types.VARCHAR),
                        new SqlOutParameter("p_out_estado", Types.VARCHAR),
                        new SqlOutParameter("p_out_monto", Types.INTEGER),
                        new SqlOutParameter("p_out_id_reserva", Types.INTEGER),
                        new SqlOutParameter("p_out_fecha_inicio", Types.DATE),
                        new SqlOutParameter("p_out_hora_inicio", Types.VARCHAR),
                        new SqlOutParameter("p_out_fecha_termino", Types.DATE),
                        new SqlOutParameter("p_out_hora_termino", Types.VARCHAR));

        Map<String, Object> out = jdbcCall.execute(in);

        if (!out.isEmpty()) {

            reservaServicio.setIdServicio((Integer) out.get("p_out_id_servicio"));
            reservaServicio.setDescripcion((String) out.get("p_out_descripcion"));
            reservaServicio.setEstado((String) out.get("p_out_estado"));
            reservaServicio.setMonto((Integer) out.get("p_out_monto"));
            reservaServicio.setIdReserva((Integer) out.get("p_out_id_reserva"));
            reservaServicio.setFechaInicio((Date) out.get("p_out_fecha_inicio"));
            reservaServicio.setHoraInicio((String) out.get("p_out_hora_inicio"));
            reservaServicio.setFechaTermino((Date) out.get("p_out_fecha_termino"));
            reservaServicio.setHoraTermino((String) out.get("p_out_hora_termino"));

        }

        return reservaServicio;

    }

    public CheckInResponse buscarCheckIn(int idReserva) {

        CheckInResponse checkInResponse = new CheckInResponse();

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_in_id_reserva", idReserva, Types.INTEGER)
                .addValue("p_out_id_checkin", Types.INTEGER)
                .addValue("p_out_fecha", Types.DATE)
                .addValue("p_out_abono", Types.INTEGER)
                .addValue("p_out_funcionario", Types.VARCHAR)
                .addValue("p_out_id_reserva", Types.INTEGER);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_SEARCH_CHECK_IN_BY_BOOKING")
                .declareParameters(new SqlParameter("p_in_id_reserva", Types.INTEGER),
                        new SqlOutParameter("p_out_id_checkin", Types.INTEGER),
                        new SqlOutParameter("p_out_fecha", Types.DATE),
                        new SqlOutParameter("p_out_abono", Types.INTEGER),
                        new SqlOutParameter("p_out_funcionario", Types.VARCHAR),
                        new SqlOutParameter("p_out_id_reserva", Types.INTEGER));

        Map<String, Object> out = jdbcCall.execute(in);

        if(!out.isEmpty()){

            checkInResponse.setIdCheckIn((Integer) out.get("p_out_id_checkin"));
            checkInResponse.setFecha((Date) out.get("p_out_fecha"));
            checkInResponse.setAbono((Integer) out.get("p_out_abono"));
            checkInResponse.setRunFuncionario((String) out.get("p_out_funcionario"));
            checkInResponse.setIdReserva((Integer) out.get("p_out_id_reserva"));

        }

        return checkInResponse;

    }

    public CheckOutResponse buscarCheckOut(int idReserva){

        CheckOutResponse checkOutResponse = new CheckOutResponse();

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_in_id_reserva", idReserva, Types.INTEGER)
                .addValue("p_out_id_checkout", Types.INTEGER)
                .addValue("p_out_fecha", Types.DATE)
                .addValue("p_out_multa", Types.INTEGER)
                .addValue("p_out_funcionario", Types.VARCHAR)
                .addValue("p_out_id_reserva", Types.INTEGER);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_SEARCH_CHECK_OUT_BY_BOOKING")
                .declareParameters(new SqlParameter("p_in_id_reserva", Types.INTEGER),
                        new SqlOutParameter("p_out_id_checkout", Types.INTEGER),
                        new SqlOutParameter("p_out_fecha", Types.DATE),
                        new SqlOutParameter("p_out_multa", Types.INTEGER),
                        new SqlOutParameter("p_out_funcionario", Types.VARCHAR),
                        new SqlOutParameter("p_out_id_reserva", Types.INTEGER));

        Map<String, Object> out = jdbcCall.execute(in);

        if(!out.isEmpty()){

            checkOutResponse.setIdCheckOut((Integer) out.get("p_out_id_checkout"));
            checkOutResponse.setFecha((Date) out.get("p_out_fecha"));
            checkOutResponse.setMulta((Integer) out.get("p_out_multa"));
            checkOutResponse.setRunFuncionario((String) out.get("p_out_funcionario"));
            checkOutResponse.setIdReserva((Integer) out.get("p_out_id_reserva"));

        }

        return checkOutResponse;

    }

    public List<CheckInResponse> listarCheckIn(){

        List<CheckInResponse> checkins = new ArrayList<>();

        try {

            String query = "SELECT ID_CHECKIN, FECHA, ABONO, FUNCIONARIOS_RUN, RESERVAS_ID_RESERVA FROM CHECK_IN";

            PreparedStatement stm = dataSource.getConnection().prepareStatement(query);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                CheckInResponse checkin = new CheckInResponse();

                checkin.setIdCheckIn(rs.getInt("ID_CHECKIN"));
                checkin.setFecha(rs.getDate("FECHA"));
                checkin.setAbono(rs.getInt("ABONO"));
                checkin.setRunFuncionario(rs.getString("FUNCIONARIOS_RUN"));
                checkin.setIdReserva(rs.getInt("RESERVAS_ID_RESERVA"));

                checkins.add(checkin);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return checkins;

    }

    public List<CheckOutResponse> listarCheckOut(){

        List<CheckOutResponse> checkouts = new ArrayList<>();

        try {

            String query = "SELECT ID_CHECKOUT, FECHA, MULTA, FUNCIONARIOS_RUN, RESERVAS_ID_RESERVA FROM CHECK_OUT";

            PreparedStatement stm = dataSource.getConnection().prepareStatement(query);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                CheckOutResponse checkout = new CheckOutResponse();

                checkout.setIdCheckOut(rs.getInt("ID_CHECKOUT"));
                checkout.setFecha(rs.getDate("FECHA"));
                checkout.setMulta(rs.getInt("MULTA"));
                checkout.setRunFuncionario(rs.getString("FUNCIONARIOS_RUN"));
                checkout.setIdReserva(rs.getInt("RESERVAS_ID_RESERVA"));

                checkouts.add(checkout);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return checkouts;

    }

    public void actualizarCheckIn(ActualizarCheckIn actualizarCheckIn) {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_id_checkin", actualizarCheckIn.getIdCheckin(), Types.INTEGER)
                .addValue("p_fecha",actualizarCheckIn.getFecha(), Types.DATE)
                .addValue("p_abono",actualizarCheckIn.getAbono(), Types.INTEGER)
                .addValue("p_funcionario", actualizarCheckIn.getRunFuncionario(), Types.VARCHAR)
                .addValue("p_id_reserva", actualizarCheckIn.getIdReserva(), Types.INTEGER);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_UPDATE_CHECKIN")
                .declareParameters(new SqlParameter("p_id_checkin", Types.INTEGER),
                        new SqlOutParameter("p_fecha", Types.DATE),
                        new SqlOutParameter("p_abono", Types.INTEGER),
                        new SqlOutParameter("p_funcionario", Types.VARCHAR),
                        new SqlOutParameter("p_id_reserva", Types.INTEGER));

        jdbcCall.execute(in);

    }

    public void actualizarCheckOut(ActualizarCheckOut actualizarCheckOut) {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_id_checkout", actualizarCheckOut.getIdCheckout(), Types.INTEGER)
                .addValue("p_fecha",actualizarCheckOut.getFecha(), Types.DATE)
                .addValue("p_multa",actualizarCheckOut.getMulta(), Types.INTEGER)
                .addValue("p_funcionario", actualizarCheckOut.getRunFuncionario(), Types.VARCHAR)
                .addValue("p_id_reserva", actualizarCheckOut.getIdReserva(), Types.INTEGER);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_UPDATE_CHECKOUT")
                .declareParameters(new SqlParameter("p_id_checkout", Types.INTEGER),
                        new SqlOutParameter("p_fecha", Types.DATE),
                        new SqlOutParameter("p_multa", Types.INTEGER),
                        new SqlOutParameter("p_funcionario", Types.VARCHAR),
                        new SqlOutParameter("p_id_reserva", Types.INTEGER));

        jdbcCall.execute(in);

    }


}
