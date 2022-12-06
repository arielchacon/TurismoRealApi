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
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.duocuc.turismoreal.request.ActualizarInventario;
import com.duocuc.turismoreal.request.RegistrarInventario;
import com.duocuc.turismoreal.request.RegistrarObjetoInventario;
import com.duocuc.turismoreal.response.InventarioObjetoRespone;
import com.duocuc.turismoreal.response.InventarioResponse;
import com.duocuc.turismoreal.response.ObjetoResponse;

@Service
public class InventarioService {

    @Autowired
    DataSource dataSource;

    public void crearInventario(RegistrarInventario registrarInventario) {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_in_observacion", registrarInventario.getObservacion(), Types.VARCHAR)
                .addValue("p_in_fecha_inventario", registrarInventario.getFechaInventario(), Types.DATE)
                .addValue("p_in_estado", registrarInventario.getEstado(), Types.VARCHAR)
                .addValue("p_in_id_depto", registrarInventario.getIdDepartamento(), Types.INTEGER);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_CREATE_INVENTARY")
                .declareParameters(new SqlParameter("p_in_observacion", Types.VARCHAR),
                        new SqlParameter("p_in_fecha_inventario", Types.DATE),
                        new SqlParameter("p_in_estado", Types.VARCHAR),
                        new SqlParameter("p_in_id_depto", Types.INTEGER));

        jdbcCall.execute(in);

    }

    public void actualizarInventario(ActualizarInventario actualizarInventario) {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_in_id_inventario", actualizarInventario.getIdInventario(), Types.INTEGER)
                .addValue("p_in_observacion", actualizarInventario.getObservacion(), Types.VARCHAR)
                .addValue("p_in_fecha_inventario", actualizarInventario.getFechaInventario(), Types.DATE)
                .addValue("p_in_estado", actualizarInventario.getEstado(), Types.VARCHAR)
                .addValue("p_in_id_depto", actualizarInventario.getIdDepartamento(), Types.INTEGER);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_UPDATE_INVENTARY")
                .declareParameters(new SqlParameter("p_in_id_inventario", Types.INTEGER),
                        new SqlParameter("p_in_observacion", Types.VARCHAR),
                        new SqlParameter("p_in_fecha_inventario", Types.DATE),
                        new SqlParameter("p_in_estado", Types.VARCHAR),
                        new SqlParameter("p_in_id_depto", Types.INTEGER));

        jdbcCall.execute(in);

    }

    public InventarioResponse buscarInventario(int idInventario) {

        InventarioResponse inventario = new InventarioResponse();

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_in_id_inventario", idInventario, Types.INTEGER)
                .addValue("p_out_id_inventario", Types.INTEGER)
                .addValue("p_out_observacion", Types.VARCHAR)
                .addValue("p_out_fecha_inventario", Types.DATE)
                .addValue("p_out_estado", Types.VARCHAR)
                .addValue("p_out_id_depto", Types.INTEGER);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_SEARCH_INVENTARY")
                .declareParameters(new SqlParameter("p_in_id_inventario", Types.INTEGER),
                        new SqlOutParameter("p_out_id_inventario", Types.INTEGER),
                        new SqlOutParameter("p_out_observacion", Types.VARCHAR),
                        new SqlOutParameter("p_out_fecha_inventario", Types.DATE),
                        new SqlOutParameter("p_out_estado", Types.VARCHAR),
                        new SqlOutParameter("p_out_id_depto", Types.INTEGER));

        Map<String, Object> out = jdbcCall.execute(in);

        if (!out.isEmpty()) {

            inventario.setIdInventario((Integer) out.get("p_out_id_inventario"));
            inventario.setObservacion((String) out.get("p_out_obervacion"));
            inventario.setFechaInventario((Date) out.get("p_out_fecha_inventario"));
            inventario.setEstado((String) out.get("p_out_estado"));
            inventario.setIdDepartamento((Integer) out.get("p_out_id_depto"));

        }

        return inventario;

    }

    public void eliminarInventario(int idInventario) {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_id_inventario", idInventario, Types.INTEGER);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_DELETE_INVENTARY")
                .declareParameters(new SqlParameter("p_id_inventario", Types.INTEGER));

        jdbcCall.execute(in);

    }

    public void agregarObjetoInventario(RegistrarObjetoInventario registrarObjetoInventario) {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_in_id_inventario", registrarObjetoInventario.getIdInventario(), Types.INTEGER)
                .addValue("p_in_objeto_sku", registrarObjetoInventario.getSku(), Types.INTEGER);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_CREATE_INVENTARY_FURNY")
                .declareParameters(new SqlParameter("p_in_id_inventario", Types.INTEGER),
                        new SqlParameter("p_in_objeto_sku", Types.INTEGER));

        jdbcCall.execute(in);

    }

    public InventarioObjetoRespone listarObjetosInventario(int idInventario){

        InventarioObjetoRespone inventarioObjetoRespone = new InventarioObjetoRespone();

        inventarioObjetoRespone.setIdInventario(idInventario);

        List<ObjetoResponse> objetos = new ArrayList<>();


        try {
            
            String query = "SELECT SKU, NOMBRE_OBJETO, PRECIO, CANTIDAD, ESTADO, ID_MARCA FROM OBJETOS JOIN INVENTARIO_OBJETO"
            +" "+"ON SKU = OBJETO_SKU WHERE ID_INVENTARIO = ?";

            PreparedStatement stm = dataSource.getConnection().prepareStatement(query);

            stm.setInt(1, idInventario);

            ResultSet rs = stm.executeQuery();

            while(rs.next()){

                ObjetoResponse objeto = new ObjetoResponse();

                objeto.setSku(rs.getString("SKU"));
                objeto.setNombreObjeto(rs.getString("NOMBRE_OBJETO"));
                objeto.setPrecio(rs.getInt("PRECIO"));
                objeto.setCantidad(rs.getInt("CANTIDAD"));
                objeto.setEstado(rs.getString("ESTADO"));
                objeto.setIdMarca(rs.getInt("ID_MARCA"));

                objetos.add(objeto);

            }

            rs.close();


        } catch (Exception e) {
            
            e.printStackTrace();
            
        }


        return inventarioObjetoRespone;

        
    }

}
