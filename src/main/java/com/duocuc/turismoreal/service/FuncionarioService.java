package com.duocuc.turismoreal.service;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import com.duocuc.turismoreal.request.ActualizarFuncionario;
import com.duocuc.turismoreal.request.RegistroFuncionario;

/**
 * FuncionarioService - Clase con la logica de invocacion a los procedimientos para la mantencion de funcionarios
 */
@Service
public class FuncionarioService {

        @Autowired
        DataSource dataSource;

        public void registrarFuncionario(RegistroFuncionario registroFuncionario) {

                SqlParameterSource in = new MapSqlParameterSource()
                                .addValue("p_run", registroFuncionario.getRun(), Types.VARCHAR)
                                .addValue("p_nombre", registroFuncionario.getNombre(), Types.VARCHAR)
                                .addValue("p_appaterno", registroFuncionario.getAppaterno(), Types.VARCHAR)
                                .addValue("p_apmaterno", registroFuncionario.getApmaterno(), Types.VARCHAR)
                                .addValue("p_genero", registroFuncionario.getGenero(), Types.VARCHAR)
                                .addValue("p_direccion", registroFuncionario.getDireccion(), Types.VARCHAR)
                                .addValue("p_fecha_nacimiento", registroFuncionario.getFechaNacimiento(), Types.DATE)
                                .addValue("p_telefono", registroFuncionario.getTelefono(), Types.VARCHAR)
                                .addValue("p_correo", registroFuncionario.getCorreo(), Types.VARCHAR)
                                .addValue("p_cargo", registroFuncionario.getCargo(), Types.VARCHAR)
                                .addValue("p_estado", registroFuncionario.getCargo(), Types.VARCHAR)
                                .addValue("p_id_comuna", registroFuncionario.getIdComuna(), Types.INTEGER)
                                .addValue("p_nombre_usuario", registroFuncionario.getNombreUsuario(), Types.VARCHAR)
                                .addValue("p_password", registroFuncionario.getPassword(), Types.VARCHAR);

                SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                                .withProcedureName("SP_CREATE_EMPLOYEE")
                                .declareParameters(new SqlParameter("p_run", Types.VARCHAR),
                                                new SqlParameter("p_nombre", Types.VARCHAR),
                                                new SqlParameter("p_appaterno", Types.VARCHAR),
                                                new SqlParameter("p_apmaterno", Types.VARCHAR),
                                                new SqlParameter("p_genero", Types.VARCHAR),
                                                new SqlParameter("p_direccion", Types.VARCHAR),
                                                new SqlParameter("p_fecha_nacimiento", Types.DATE),
                                                new SqlParameter("p_telefono", Types.VARCHAR),
                                                new SqlParameter("p_correo", Types.VARCHAR),
                                                new SqlParameter("p_cargo", Types.VARCHAR),
                                                new SqlParameter("p_estado", Types.VARCHAR),
                                                new SqlParameter("p_id_comuna", Types.INTEGER),
                                                new SqlParameter("p_nombre_usuario", Types.VARCHAR),
                                                new SqlParameter("p_password", Types.VARCHAR));

                jdbcCall.execute(in);
        }

        public void borrarFuncionario(String run) {

                SqlParameterSource in = new MapSqlParameterSource()
                                .addValue("p_run", run, Types.VARCHAR);

                SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                                .withProcedureName("SP_DELETE_EMPLOYEE")
                                .declareParameters(new SqlParameter("p_run", Types.VARCHAR));

                jdbcCall.execute(in);

        }

        public void actualizarFuncionario(String run, ActualizarFuncionario actualizarFuncionario) {

                SqlParameterSource in = new MapSqlParameterSource()
                                .addValue("p_run", run, Types.VARCHAR)
                                .addValue("p_nombre", actualizarFuncionario.getNombre(), Types.VARCHAR)
                                .addValue("p_appaterno", actualizarFuncionario.getAppaterno(), Types.VARCHAR)
                                .addValue("p_apmaterno", actualizarFuncionario.getApmaterno(), Types.VARCHAR)
                                .addValue("p_genero", actualizarFuncionario.getGenero(), Types.VARCHAR)
                                .addValue("p_direccion", actualizarFuncionario.getDireccion(), Types.VARCHAR)
                                .addValue("p_fecha_nacimiento", actualizarFuncionario.getFechaNacimiento(), Types.DATE)
                                .addValue("p_telefono", actualizarFuncionario.getTelefono(), Types.VARCHAR)
                                .addValue("p_correo", actualizarFuncionario.getCorreo(), Types.VARCHAR)
                                .addValue("p_cargo", actualizarFuncionario.getCargo(), Types.VARCHAR)
                                .addValue("p_estado", actualizarFuncionario.getCargo(), Types.VARCHAR)
                                .addValue("p_id_comuna", actualizarFuncionario.getIdComuna(), Types.INTEGER);

                SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                                .withProcedureName("SP_UPDATE_EMPLOYEE")
                                .declareParameters(new SqlParameter("p_run", Types.VARCHAR),
                                                new SqlParameter("p_nombre", Types.VARCHAR),
                                                new SqlParameter("p_appaterno", Types.VARCHAR),
                                                new SqlParameter("p_apmaterno", Types.VARCHAR),
                                                new SqlParameter("p_genero", Types.VARCHAR),
                                                new SqlParameter("p_direccion", Types.VARCHAR),
                                                new SqlParameter("p_fecha_nacimiento", Types.DATE),
                                                new SqlParameter("p_telefono", Types.VARCHAR),
                                                new SqlParameter("p_correo", Types.VARCHAR),
                                                new SqlParameter("p_cargo", Types.VARCHAR),
                                                new SqlParameter("p_estado", Types.VARCHAR),
                                                new SqlParameter("p_id_comuna", Types.INTEGER));

                jdbcCall.execute(in);
        }

}
