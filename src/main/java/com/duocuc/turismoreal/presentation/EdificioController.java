package com.duocuc.turismoreal.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.duocuc.turismoreal.request.ActualizarEdificio;
import com.duocuc.turismoreal.request.RegistroEdificio;
import com.duocuc.turismoreal.response.EdificioResponse;
import com.duocuc.turismoreal.service.EdificioService;

@RestController
@RequestMapping("edificio")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class EdificioController {
  
    @Autowired
    EdificioService edificioService;

    @PostMapping("/registrar")
    public void registrarEdificio(@RequestBody(required = true) RegistroEdificio registroEdificio){

        edificioService.crearEdificio(registroEdificio);

    }

    @PutMapping("/actualizar/{idEdificio}")
    public void actualizarEdificio(@PathVariable(required = true) int idEdificio, 
                                   @RequestBody(required = true) ActualizarEdificio actualizarEdificio){

        edificioService.actualizarEdificio(idEdificio, actualizarEdificio);

    }

    @DeleteMapping("/borrar/{idEdificio}")
    public void eliminarEdificio(@PathVariable(required = true) int idEdificio){

        edificioService.eliminarEdificio(idEdificio);
        
    }

    @GetMapping("/listar-edificios/{idComuna}")
    public List<EdificioResponse> listarEdificios(@PathVariable(required = true) int idComuna) {

        return edificioService.listarEdificios(idComuna);

    }

    @GetMapping("/listar")
    public List<EdificioResponse> listar() {

        return edificioService.listar();

    }
    
}
