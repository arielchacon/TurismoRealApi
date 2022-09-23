package com.duocuc.turismoreal.service;

import java.sql.Types;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import com.duocuc.turismoreal.request.RegistroCliente;

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

}
