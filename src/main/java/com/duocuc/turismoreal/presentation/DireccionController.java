package com.duocuc.turismoreal.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.duocuc.turismoreal.response.ComunaResponse;
import com.duocuc.turismoreal.response.ProvinciaResponse;
import com.duocuc.turismoreal.response.RegionResponse;
import com.duocuc.turismoreal.service.DireccionService;

@RestController
@RequestMapping("direccion")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET} )
public class DireccionController {
  
    @Autowired
    DireccionService direccionService;

    @GetMapping("/listar-region")
    public List<RegionResponse> listarRegiones(){
        
        return direccionService.listarRegiones();

    }

    @GetMapping("/listar-provincia/{idRegion}")
    public List<ProvinciaResponse> listarProvincia(@PathVariable int idRegion){

        return direccionService.listarProvincia(idRegion);

    }

    @GetMapping("/listar-comuna/{idProvincia}")
    public List<ComunaResponse> listarComuna(@PathVariable int idProvincia){

        return direccionService.listarComunas(idProvincia);
        
    }

}
