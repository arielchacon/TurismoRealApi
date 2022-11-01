package com.duocuc.turismoreal.service;

import java.sql.Types;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import com.duocuc.turismoreal.request.ActualizarUsuario;
import com.duocuc.turismoreal.response.RolesResponse;
import com.duocuc.turismoreal.response.UsuarioResponse;

@Service
public class UsuarioService {

    @Autowired
    DataSource dataSource;

    public void actualizarPassword(ActualizarUsuario actualizarUsuario) {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_nombre_usuario", actualizarUsuario.getNombreUsuario(), Types.VARCHAR)
                .addValue("p_old_password", actualizarUsuario.getOldPassword(), Types.VARCHAR)
                .addValue("p_new_password", actualizarUsuario.getNewPassword(), Types.VARCHAR);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_UPDATE_USER")
                .declareParameters(new SqlParameter("p_nombre_usuario", Types.VARCHAR),
                        new SqlParameter("p_old_password", Types.VARCHAR),
                        new SqlParameter("p_new_password", Types.VARCHAR));

        jdbcCall.execute(in);

    }

    public UsuarioResponse getByNombre(String nombreUsuario){

        UsuarioResponse usuario = new UsuarioResponse();
        Set<RolesResponse> roles= new HashSet<>();
        RolesResponse rol = new RolesResponse();

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_nombre_usuario", nombreUsuario, Types.VARCHAR)
                .addValue("p_out_id_usuario", Types.INTEGER)
                .addValue("p_out_nombre_usuario", Types.VARCHAR)
                .addValue("p_out_password", Types.VARCHAR)
                .addValue("p_out_estado", Types.VARCHAR)
                .addValue("p_out_rol_id", Types.INTEGER)
                .addValue("p_out_rol", Types.VARCHAR);

                SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource)
                .withProcedureName("SP_VALIDA_NOMBRE_USUARIO")
                .declareParameters(new SqlParameter("p_nombre_usuario", Types.VARCHAR),
                                   new SqlOutParameter("p_out_id_usuario", Types.INTEGER),
                                   new SqlOutParameter("p_out_nombre_usuario", Types.VARCHAR),
                                   new SqlOutParameter("p_out_password", Types.VARCHAR),
                                   new SqlOutParameter("p_out_estado", Types.VARCHAR),
                                   new SqlOutParameter("p_out_rol_id", Types.INTEGER),
                                   new SqlOutParameter("p_out_rol", Types.VARCHAR));
                        
        Map<String, Object> out = jdbcCall.execute(in);

        System.out.println(out.toString());

        if(!out.isEmpty()){

            usuario.setIdUsuario((Integer) out.get("p_out_id_usuario"));
            usuario.setNombreUsuario((String) out.get("p_out_nombre_usuario"));
            usuario.setPassword((String) out.get("p_out_password"));
            usuario.setEstado((String) out.get("p_out_estado"));
            rol.setRolId((Integer) out.get("p_out_rol_id"));
            rol.setRol((String) out.get("p_out_rol"));
            roles.add(rol);
            usuario.setRoles(roles);

        }

        return usuario;

    }
    

}
