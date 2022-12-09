package com.duocuc.turismoreal.service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duocuc.turismoreal.request.ActualizarMantenimiento;
import com.duocuc.turismoreal.request.RegistrarMantenimiento;
import com.duocuc.turismoreal.response.MantenimientoResponse;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

@Service
public class MantenimientoService {

    @Autowired
    DataSource dataSource;

    public void crearMantenimiento(RegistrarMantenimiento registrarMantenimiento) {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_in_descripcion", registrarMantenimiento.getDescripcion(), Types.VARCHAR)
                .addValue("p_in_estado", registrarMantenimiento.getEstado(), Types.VARCHAR)
                .addValue("p_in_fecha_mantencion", registrarMantenimiento.getFechaMantencion(), Types.DATE)
                .addValue("p_in_costo", registrarMantenimiento.getCosto(), Types.INTEGER)
                .addValue("p_in_depto", registrarMantenimiento.getIdDepartamento(), Types.INTEGER);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_CREATE_MAINTENANCE")
                .declareParameters(new SqlParameter("p_in_descripcion", Types.VARCHAR),
                        new SqlParameter("p_in_estado", Types.VARCHAR),
                        new SqlParameter("p_in_fecha_mantencion", Types.DATE),
                        new SqlParameter("p_in_costo", Types.INTEGER),
                        new SqlParameter("p_in_depto", Types.INTEGER));

        jdbcCall.execute(in);

    }

    public void actualizarMantenimiento(ActualizarMantenimiento actualizarMantenimiento) {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_in_id_mantencion", actualizarMantenimiento.getIdMantenimiento(), Types.INTEGER)
                .addValue("p_in_descripcion", actualizarMantenimiento.getDescripcion(), Types.VARCHAR)
                .addValue("p_in_estado", actualizarMantenimiento.getEstado(), Types.VARCHAR)
                .addValue("p_in_fecha_mantencion", actualizarMantenimiento.getFechaMantencion(), Types.DATE)
                .addValue("p_in_costo", actualizarMantenimiento.getCosto(), Types.INTEGER)
                .addValue("p_in_depto", actualizarMantenimiento.getIdDepartamento(), Types.INTEGER);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_UPDATE_MAINTENANCE")
                .declareParameters(new SqlParameter("p_in_id_mantencion", Types.INTEGER),
                        new SqlParameter("p_in_descripcion", Types.VARCHAR),
                        new SqlParameter("p_in_estado", Types.VARCHAR),
                        new SqlParameter("p_in_fecha_mantencion", Types.DATE),
                        new SqlParameter("p_in_costo", Types.INTEGER),
                        new SqlParameter("p_in_depto", Types.INTEGER));

        jdbcCall.execute(in);

    }

    public void eliminarMantenimiento(int idMantenimiento) {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_in_id_mantencion", idMantenimiento, Types.INTEGER);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_DELETE_MAINTENANCE")
                .declareParameters(new SqlParameter("p_in_id_mantencion", Types.INTEGER));

        jdbcCall.execute(in);

    }

    public List<MantenimientoResponse> listarMantenimientos(){

        List<MantenimientoResponse> mantenimientos = new ArrayList<>();

        try {

                String query = "SELECT ID_MANTENCION, DESCRIPCION, ESTADO, FECHA_MANTENCION, COSTO, ID_DEPARTAMENTO FROM MANTENCIONES";
    
                PreparedStatement stm = dataSource.getConnection().prepareStatement(query);
                ResultSet rs = stm.executeQuery();
    
                while (rs.next()) {
    
                    MantenimientoResponse mantencion = new MantenimientoResponse();

                    mantencion.setIdMantencion(rs.getInt("ID_MANTENCION"));
                    mantencion.setDescripcion(rs.getString("DESCRIPCION"));
                    mantencion.setEstado(rs.getString("ESTADO"));
                    mantencion.setFechaMantencion(rs.getDate("FECHA_MANTENCION"));
                    mantencion.setCosto(rs.getInt("COSTO"));
                    mantencion.setIdDepartamento(rs.getInt("ID_DEPARTAMENTO"));

                    mantenimientos.add(mantencion);
    
                }
    
                rs.close();
    
            } catch (Exception e) {
    
                e.printStackTrace();
    
            }

        return mantenimientos;

    }

    public MantenimientoResponse buscarMantenimiento(int idMantencion) {

        MantenimientoResponse mantenimiento = new MantenimientoResponse();

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_in_id_mantencion", idMantencion, Types.INTEGER)
                .addValue("p_out_id_mantencion", Types.INTEGER)
                .addValue("p_out_descripcion", Types.VARCHAR)
                .addValue("p_out_estado", Types.VARCHAR)
                .addValue("p_out_fecha_mantencion", Types.DATE)
                .addValue("p_out_costo", Types.INTEGER)
                .addValue("p_out_id_depto", Types.INTEGER);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_SEARCH_MAINTENANCE")
                .declareParameters(new SqlParameter("p_in_id_mantencion", Types.INTEGER),
                        new SqlOutParameter("p_out_id_mantencion", Types.INTEGER),
                        new SqlOutParameter("p_out_descripcion", Types.VARCHAR),
                        new SqlOutParameter("p_out_estado", Types.VARCHAR),
                        new SqlOutParameter("p_out_fecha_mantencion", Types.DATE),
                        new SqlOutParameter("p_out_costo", Types.INTEGER),
                        new SqlOutParameter("p_out_id_depto", Types.INTEGER));

        Map<String, Object> out = jdbcCall.execute(in);

        if(!out.isEmpty()){

            mantenimiento.setIdMantencion((Integer) out.get("p_out_id_mantencion"));
            mantenimiento.setDescripcion((String) out.get("p_out_descripcion"));
            mantenimiento.setEstado((String) out.get("p_out_estado"));
            mantenimiento.setFechaMantencion((Date) out.get("p_out_fecha_mantencion"));
            mantenimiento.setCosto((Integer) out.get("p_out_costo"));
            mantenimiento.setIdDepartamento((Integer) out.get("p_out_id_depto"));

        }

        return mantenimiento;

    }

}
