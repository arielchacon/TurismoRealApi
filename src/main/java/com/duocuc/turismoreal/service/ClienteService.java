package com.duocuc.turismoreal.service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import com.duocuc.turismoreal.request.ActualizarCliente;
import com.duocuc.turismoreal.request.RegistroCliente;
import com.duocuc.turismoreal.response.ClienteResponse;
import com.duocuc.turismoreal.response.InfoClienteResponse;

/**
 * ClienteService - Clase con la logica de invocacion a los procedimientos para
 * la mantencion de clientes
 */
@Service
public class ClienteService {

        @Autowired
        DataSource dataSource;

        public void registrarCliente(RegistroCliente registroCliente) {

                SqlParameterSource in = new MapSqlParameterSource()
                                .addValue("p_run", registroCliente.getRun(), Types.VARCHAR)
                                .addValue("p_nombre", registroCliente.getNombre(), Types.VARCHAR)
                                .addValue("p_appaterno", registroCliente.getAppaterno(), Types.VARCHAR)
                                .addValue("p_apmaterno", registroCliente.getApmaterno(), Types.VARCHAR)
                                .addValue("p_genero", registroCliente.getGenero(), Types.VARCHAR)
                                .addValue("p_direccion", registroCliente.getDireccion(), Types.VARCHAR)
                                .addValue("p_fecha_nacimiento", registroCliente.getFechaNacimiento(), Types.DATE)
                                .addValue("p_telefono", registroCliente.getTelefono(), Types.VARCHAR)
                                .addValue("p_telefono_2", registroCliente.getTelefono_2(), Types.VARCHAR)
                                .addValue("p_correo", registroCliente.getCorreo(), Types.VARCHAR)
                                .addValue("p_es_frecuente", registroCliente.getEsFrecuente(), Types.CHAR)
                                .addValue("p_id_comuna", registroCliente.getIdComuna(), Types.INTEGER)
                                .addValue("p_nombre_usuario", registroCliente.getNombreUsuario(), Types.VARCHAR)
                                .addValue("p_password", registroCliente.getPassword(), Types.VARCHAR);

                SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                                .withProcedureName("SP_CREATE_CLIENT")
                                .declareParameters(new SqlParameter("p_run", Types.VARCHAR),
                                                new SqlParameter("p_nombre", Types.VARCHAR),
                                                new SqlParameter("p_appaterno", Types.VARCHAR),
                                                new SqlParameter("p_apmaterno", Types.VARCHAR),
                                                new SqlParameter("p_genero", Types.VARCHAR),
                                                new SqlParameter("p_direccion", Types.VARCHAR),
                                                new SqlParameter("p_fecha_nacimiento", Types.DATE),
                                                new SqlParameter("p_telefono", Types.VARCHAR),
                                                new SqlParameter("p_telefono_2", Types.VARCHAR),
                                                new SqlParameter("p_correo", Types.VARCHAR),
                                                new SqlParameter("p_es_frecuente", Types.CHAR),
                                                new SqlParameter("p_id_comuna", Types.INTEGER),
                                                new SqlParameter("p_nombre_usuario", Types.VARCHAR),
                                                new SqlParameter("p_password", Types.VARCHAR));

                jdbcCall.execute(in);

        }

        public void borrarCliente(String run) {

                SqlParameterSource in = new MapSqlParameterSource()
                                .addValue("p_run", run, Types.VARCHAR);

                SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                                .withProcedureName("SP_DELETE_CLIENT")
                                .declareParameters(new SqlParameter("p_run", Types.VARCHAR));

                jdbcCall.execute(in);

        }

        public void actualizarCliente(String run, ActualizarCliente actualizarCliente) {

                SqlParameterSource in = new MapSqlParameterSource()
                                .addValue("p_run", run, Types.VARCHAR)
                                .addValue("p_nombre", actualizarCliente.getNombre(), Types.VARCHAR)
                                .addValue("p_appaterno", actualizarCliente.getAppaterno(), Types.VARCHAR)
                                .addValue("p_apmaterno", actualizarCliente.getApmaterno(), Types.VARCHAR)
                                .addValue("p_genero", actualizarCliente.getGenero(), Types.VARCHAR)
                                .addValue("p_direccion", actualizarCliente.getDireccion(), Types.VARCHAR)
                                .addValue("p_fecha_nacimiento", actualizarCliente.getFechaNacimiento(), Types.DATE)
                                .addValue("p_telefono", actualizarCliente.getTelefono(), Types.VARCHAR)
                                .addValue("p_telefono_2", actualizarCliente.getTelefono_2(), Types.VARCHAR)
                                .addValue("p_correo", actualizarCliente.getCorreo(), Types.VARCHAR)
                                .addValue("p_es_frecuente", actualizarCliente.getEsFrecuente(), Types.CHAR)
                                .addValue("p_id_comuna", actualizarCliente.getIdComuna(), Types.INTEGER);

                SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                                .withProcedureName("SP_CREATE_CLIENT")
                                .declareParameters(new SqlParameter("p_run", Types.VARCHAR),
                                                new SqlParameter("p_nombre", Types.VARCHAR),
                                                new SqlParameter("p_appaterno", Types.VARCHAR),
                                                new SqlParameter("p_apmaterno", Types.VARCHAR),
                                                new SqlParameter("p_genero", Types.VARCHAR),
                                                new SqlParameter("p_direccion", Types.VARCHAR),
                                                new SqlParameter("p_fecha_nacimiento", Types.DATE),
                                                new SqlParameter("p_telefono", Types.VARCHAR),
                                                new SqlParameter("p_telefono_2", Types.VARCHAR),
                                                new SqlParameter("p_correo", Types.VARCHAR),
                                                new SqlParameter("p_es_frecuente", Types.CHAR),
                                                new SqlParameter("p_id_comuna", Types.INTEGER));

                jdbcCall.execute(in);

        }

        public InfoClienteResponse buscarInformacionCliente(String nombreUsuario) {

                InfoClienteResponse info = new InfoClienteResponse();

                try {

                        String query = "SELECT RUN, NOMBRE_USUARIO, ES_FRECUENTE FROM CLIENTES WHERE NOMBRE_USUARIO = ?";

                        PreparedStatement stm = dataSource.getConnection().prepareStatement(query);

                        stm.setString(1, nombreUsuario);

                        ResultSet rs = stm.executeQuery();

                        while (rs.next()) {

                                info.setRun(rs.getString("RUN"));
                                info.setNombreUsuario(rs.getString("NOMBRE_USUARIO"));
                                info.setEsFrecuente(rs.getBoolean("ES_FRECUENTE"));

                        }

                } catch (Exception e) {

                        e.printStackTrace();
                }

                return info;

        }

        public ClienteResponse buscarCliente(String nombreUsuario) {

                ClienteResponse cliente = new ClienteResponse();

                SqlParameterSource in = new MapSqlParameterSource()
                                .addValue("p_nombre_usuario", nombreUsuario, Types.VARCHAR)
                                .addValue("p_out_run", Types.VARCHAR)
                                .addValue("p_out_nombre", Types.VARCHAR)
                                .addValue("p_out_appaterno", Types.VARCHAR)
                                .addValue("p_out_apmaterno", Types.VARCHAR)
                                .addValue("p_out_genero", Types.VARCHAR)
                                .addValue("p_out_direccion", Types.VARCHAR)
                                .addValue("p_out_fecha_nacimiento", Types.DATE)
                                .addValue("p_out_telefono", Types.VARCHAR)
                                .addValue("p_out_telefono_2", Types.VARCHAR)
                                .addValue("p_out_correo", Types.VARCHAR)
                                .addValue("p_out_id_comuna", Types.INTEGER)
                                .addValue("p_out_nombre_usuario", Types.VARCHAR);

                SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                                .withProcedureName("SP_SEARCH_CLIENT")
                                .declareParameters(new SqlParameter("p_nombre_usuario", Types.VARCHAR),
                                                new SqlOutParameter("p_out_run", Types.VARCHAR),
                                                new SqlOutParameter("p_out_nombre", Types.VARCHAR),
                                                new SqlOutParameter("p_out_appaterno", Types.VARCHAR),
                                                new SqlOutParameter("p_out_apmaterno", Types.VARCHAR),
                                                new SqlOutParameter("p_out_genero", Types.VARCHAR),
                                                new SqlOutParameter("p_out_direccion", Types.VARCHAR),
                                                new SqlOutParameter("p_out_fecha_nacimiento", Types.DATE),
                                                new SqlOutParameter("p_out_telefono", Types.VARCHAR),
                                                new SqlOutParameter("p_out_telefono_2", Types.VARCHAR),
                                                new SqlOutParameter("p_out_correo", Types.VARCHAR),
                                                new SqlOutParameter("p_out_id_comuna", Types.INTEGER),
                                                new SqlOutParameter("p_out_nombre_usuario", Types.VARCHAR));

                Map<String, Object> out = jdbcCall.execute(in);

                if (!out.isEmpty()) {

                        cliente.setRun((String) out.get("p_out_run"));
                        cliente.setNombre((String) out.get("p_out_nombre"));
                        cliente.setApPaterno((String) out.get("p_out_appaterno"));
                        cliente.setApMaterno((String) out.get("p_out_apmaterno"));
                        cliente.setGenero((String) out.get("p_out_genero"));
                        cliente.setDireccion((String) out.get("p_out_direccion"));
                        cliente.setFechaNacimiento((Date) out.get("p_out_fecha_nacimiento"));
                        cliente.setTelefono((String) out.get("p_out_telefono"));
                        cliente.setTelefono2((String) out.get("p_out_telefono_2"));
                        cliente.setCorreoElectronico((String) out.get("p_out_correo"));
                        cliente.setIdComuna((Integer) out.get("p_out_id_comuna"));
                        cliente.setNombreUsuario((String) out.get("p_out_nombre_usuario"));

                }

                return cliente;

        }

}
