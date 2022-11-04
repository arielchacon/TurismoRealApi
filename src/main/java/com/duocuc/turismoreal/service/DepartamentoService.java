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

import com.duocuc.turismoreal.request.ActualizarDepartamento;
import com.duocuc.turismoreal.request.RegistroDepartamento;
import com.duocuc.turismoreal.response.DepartamentoResponse;

@Service
public class DepartamentoService {

    @Autowired
    DataSource dataSource;

    public void crearDepartamento(RegistroDepartamento registroDepartamento) {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_num_depto", registroDepartamento.getNumDepto(), Types.INTEGER)
                .addValue("p_num_habitaciones", registroDepartamento.getNumHabitaciones(), Types.INTEGER)
                .addValue("p_num_banios", registroDepartamento.getNumBanios(), Types.INTEGER)
                .addValue("p_estado", registroDepartamento.getEstado(), Types.VARCHAR)
                .addValue("p_valor", registroDepartamento.getValor(), Types.INTEGER)
                .addValue("p_imagen", registroDepartamento.getImagen(), Types.BLOB)
                .addValue("p_dividendo", registroDepartamento.getDividendo(), Types.INTEGER)
                .addValue("p_contribucion", registroDepartamento.getContribucion(), Types.INTEGER)
                .addValue("p_disponibilidad", registroDepartamento.getDisponibilidad(), Types.VARCHAR)
                .addValue("p_id_edificio", registroDepartamento.getIdEdificio(), Types.INTEGER)
                .addValue("p_funcionarios_run", registroDepartamento.getRunFuncionario(), Types.VARCHAR);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_CREATE_DEPARTMENT")
                .declareParameters(new SqlParameter("p_num_depto", Types.INTEGER),
                        new SqlParameter("p_num_habitaciones", Types.INTEGER),
                        new SqlParameter("p_num_banios", Types.INTEGER),
                        new SqlParameter("p_estado", Types.VARCHAR),
                        new SqlParameter("p_valor", Types.INTEGER),
                        new SqlParameter("p_imagen", Types.BLOB),
                        new SqlParameter("p_dividendo", Types.INTEGER),
                        new SqlParameter("p_contribucion", Types.INTEGER),
                        new SqlParameter("p_disponibilidad", Types.VARCHAR),
                        new SqlParameter("p_id_edificio", Types.INTEGER),
                        new SqlParameter("p_funcionarios_run", Types.VARCHAR));

        jdbcCall.execute(in);

    }

    public void actualizarDepartamento(int idDepartamento, ActualizarDepartamento actualizarDepartamento) {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_num_depto", actualizarDepartamento.getNumDepto(), Types.INTEGER)
                .addValue("p_num_habitaciones", actualizarDepartamento.getNumHabitaciones(), Types.INTEGER)
                .addValue("p_num_banios", actualizarDepartamento.getNumBanios(), Types.INTEGER)
                .addValue("p_estado", actualizarDepartamento.getEstado(), Types.VARCHAR)
                .addValue("p_valor", actualizarDepartamento.getValor(), Types.INTEGER)
                .addValue("p_imagen", actualizarDepartamento.getImagen(), Types.BLOB)
                .addValue("p_dividendo", actualizarDepartamento.getDividendo(), Types.INTEGER)
                .addValue("p_contribucion", actualizarDepartamento.getContribucion(), Types.INTEGER)
                .addValue("p_disponibilidad", actualizarDepartamento.getDisponibilidad(), Types.VARCHAR)
                .addValue("p_funcionarios_run", actualizarDepartamento.getRunFuncionario(), Types.VARCHAR);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_CREATE_DEPARTMENT")
                .declareParameters(new SqlParameter("p_num_depto", Types.INTEGER),
                        new SqlParameter("p_num_habitaciones", Types.INTEGER),
                        new SqlParameter("p_num_banios", Types.INTEGER),
                        new SqlParameter("p_estado", Types.VARCHAR),
                        new SqlParameter("p_valor", Types.INTEGER),
                        new SqlParameter("p_imagen", Types.BLOB),
                        new SqlParameter("p_dividendo", Types.INTEGER),
                        new SqlParameter("p_contribucion", Types.INTEGER),
                        new SqlParameter("p_disponibilidad", Types.VARCHAR),
                        new SqlParameter("p_funcionarios_run", Types.VARCHAR));

        jdbcCall.execute(in);
    }

    public void borrarDepartamento(int idDepartamento) {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_id_departamento", idDepartamento, Types.INTEGER);

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withoutProcedureColumnMetaDataAccess()
                .withProcedureName("SP_DELETE_DEPARTMENT")
                .declareParameters(new SqlParameter("p_id_departamento", Types.INTEGER));

        jdbcCall.execute(in);

    }

    public List<DepartamentoResponse> listarDepartamentos(int idEdificio){

        List<DepartamentoResponse> departamentos = new ArrayList<>();

        try {

                String query = "SELECT ID_DEPARTAMENTO, NUM_DEPTO, NUM_HABITACIONES, NUM_BANIOS, ESTADO, VALOR, IMAGEN, DIVIDENDO,"
                               + "CONTRIBUCION, DISPONIBILIDAD, ID_EDIFICIO, FUNCIONARIOS_RUN FROM DEPARTAMENTOS WHERE ID_EDIFICIO = ?";

                PreparedStatement stm = dataSource.getConnection().prepareStatement(query);

                stm.setInt(1, idEdificio);

                ResultSet rs = stm.executeQuery();

                while(rs.next()){

                        DepartamentoResponse departamento = new DepartamentoResponse();

                        departamento.setIdDepartamento(rs.getInt("ID_DEPARTAMENTO"));
                        departamento.setNumDepartamento(rs.getInt("NUM_DEPTO"));
                        departamento.setNumHabitaciones(rs.getInt("NUM_HABITACIONES"));
                        departamento.setNumBanios(rs.getInt("NUM_BANIOS"));
                        departamento.setEstado(rs.getString("ESTADO"));
                        departamento.setValor(rs.getInt("VALOR"));
                        departamento.setImagen(rs.getBlob("IMAGEN"));
                        departamento.setDividendo(rs.getInt("DIVIDENDO"));
                        departamento.setContribucion(rs.getInt("CONTRIBUCION"));
                        departamento.setDisponibilidad(rs.getString("DISPONIBILIDAD"));
                        departamento.setIdEdificio(rs.getInt("ID_EDIFICIO"));
                        departamento.setRunFuncionario(rs.getString("FUNCIONARIOS_RUN"));

                        departamentos.add(departamento);

                }

                
        } catch (Exception e) {
                
                e.printStackTrace();
        }

        return departamentos;

    }

}
