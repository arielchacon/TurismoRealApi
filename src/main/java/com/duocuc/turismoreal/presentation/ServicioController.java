package com.duocuc.turismoreal.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duocuc.turismoreal.dto.Mensaje;
import com.duocuc.turismoreal.request.RegistroServicio;
import com.duocuc.turismoreal.service.ServiciosService;
import com.duocuc.turismoreal.response.*;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("servicios")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
    RequestMethod.DELETE })
public class ServicioController {

    @Autowired
    ServiciosService serviciosService;

    @PostMapping("/crear")
    public ResponseEntity<?> crearServicio(@RequestBody(required = true)RegistroServicio registroServicio){

        serviciosService.agregarServicio(registroServicio);

        return new ResponseEntity<>(new Mensaje("ok"), HttpStatus.CREATED);

    }

    @GetMapping("/listar")
    public List<ServicioResponse> listarServicios(){

        return serviciosService.listarServicios();

    }

    
}
