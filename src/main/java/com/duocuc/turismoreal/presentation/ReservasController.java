package com.duocuc.turismoreal.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duocuc.turismoreal.dto.Mensaje;
import com.duocuc.turismoreal.request.RegistrarReserva;
import com.duocuc.turismoreal.response.ReservaResponse;
import com.duocuc.turismoreal.service.ReservasService;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("reservas")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservasController {

    @Autowired
    ReservasService reservasService;
    
    @PostMapping("/crear")
    public ResponseEntity<?> crearReserva(@RequestBody(required = true) RegistrarReserva registrarReserva){

        reservasService.crearReserva(registrarReserva);

        return new ResponseEntity(new Mensaje("ok"), HttpStatus.CREATED);

    }

    @GetMapping("/listar-cliente/{runCliente}")
    public List<ReservaResponse> listarReservaCliente(@PathVariable String runCliente){
        
        return reservasService.listarReservasCliente(runCliente);

    }

    @GetMapping("/listar")
    public List<ReservaResponse> listarReserva(){
        
        return reservasService.listarReservas();

    }

}
