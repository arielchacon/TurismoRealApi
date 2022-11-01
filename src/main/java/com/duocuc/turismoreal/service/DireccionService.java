package com.duocuc.turismoreal.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duocuc.turismoreal.response.ComunaResponse;
import com.duocuc.turismoreal.response.ProvinciaResponse;
import com.duocuc.turismoreal.response.RegionResponse;

@Service
public class DireccionService {
    
    @Autowired
    DataSource dataSource;

    public List<RegionResponse> listarRegiones(){

        List<RegionResponse> regiones = new ArrayList<>();

        try {

            String query = "SELECT ID_REGION, NOMBRE FROM REGIONES";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(query);
        
            ResultSet rs = stm.executeQuery();

            while(rs.next()){

                RegionResponse region = new RegionResponse();
                
                region.setIdRegion(rs.getInt("ID_REGION"));
                region.setNombre(rs.getString("NOMBRE"));

                regiones.add(region);

            }

        } catch (SQLException e) {
            
            e.printStackTrace();
        }

        return regiones;       

    }

    public List<ProvinciaResponse> listarProvincia(int idRegion){

        List<ProvinciaResponse> provincias = new ArrayList<>();

        try {
            
            String query = "SELECT ID_PROVINCIA, NOMBRE, ID_REGION FROM PROVINCIAS WHERE ID_REGION = ?";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(query);
        
            stm.setInt(1, idRegion);

            ResultSet rs = stm.executeQuery();

            while(rs.next()){

                ProvinciaResponse provincia = new ProvinciaResponse(rs.getInt("ID_PROVINCIA"), rs.getString("NOMBRE"), rs.getInt("ID_REGION"));

                provincias.add(provincia);

            }

        } catch (Exception e) {
            
            e.printStackTrace();
            
        }

        return provincias;

    }

    public List<ComunaResponse> listarComunas(int idProvincia){

        List<ComunaResponse> comunas = new ArrayList<>();

        try {

            String query = "SELECT ID_COMUNA, NOMBRE, ID_PROVINCIA FROM COMUNAS WHERE ID_PROVINCIA = ?";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(query);

            stm.setInt(1, idProvincia);

            ResultSet rs = stm.executeQuery();

            while(rs.next()){

                ComunaResponse comuna = new ComunaResponse(rs.getInt("ID_COMUNA"), 
                                                           rs.getString("NOMBRE"), rs.getInt("ID_PROVINCIA"));

                comunas.add(comuna);
            }
            
        } catch (Exception e) {
            
            e.printStackTrace();

        }

        return comunas;

    }

}
