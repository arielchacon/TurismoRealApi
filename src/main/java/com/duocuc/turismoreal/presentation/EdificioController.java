package com.duocuc.turismoreal.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duocuc.turismoreal.request.ActualizarEdificio;
import com.duocuc.turismoreal.request.RegistroEdificio;
import com.duocuc.turismoreal.service.EdificioService;

@RestController
@RequestMapping("edificio")
public class EdificioController {
  
    @Autowired
    EdificioService edificioService;

    @PostMapping("registrar")
    public void registrarEdificio(@RequestBody(required = true) RegistroEdificio registroEdificio){

        edificioService.crearEdificio(registroEdificio);

    }

    @PutMapping("actualizar/{idEdificio}")
    public void actualizarEdificio(@PathVariable(required = true) int idEdificio, 
                                   @RequestBody(required = true) ActualizarEdificio actualizarEdificio){

        edificioService.actualizarEdificio(idEdificio, actualizarEdificio);

    }

    @DeleteMapping("borrar/{idEdificio}")
    public void eliminarEdificio(@PathVariable(required = true) int idEdificio){

        edificioService.eliminarEdificio(idEdificio);
        
    }
    
}
