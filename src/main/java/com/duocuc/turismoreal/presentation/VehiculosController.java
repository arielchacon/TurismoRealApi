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
import com.duocuc.turismoreal.request.ActualizarVehiculo;
import com.duocuc.turismoreal.request.RegistrarVehiculo;
import com.duocuc.turismoreal.response.VehiculoResponse;
import com.duocuc.turismoreal.service.VehiculoService;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("vehiculo")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class VehiculosController {

    @Autowired
    VehiculoService vehiculoService;

    @PostMapping("/crear")
    public ResponseEntity<?> crearVehiculo(@RequestBody(required = true) RegistrarVehiculo registrarVehiculo){

        vehiculoService.crearVehiculo(registrarVehiculo);

        return new ResponseEntity<>(new Mensaje("ok"), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarVehiculo(@RequestBody(required = true) ActualizarVehiculo actualizarVehiculo){

        vehiculoService.actualizarVehiculo(actualizarVehiculo);

        return new ResponseEntity<>(new Mensaje("ok"), HttpStatus.OK);

    }

    @GetMapping("/buscar/{patente}")
    public VehiculoResponse buscarVehiculo(@PathVariable("patente") String patente){

        return vehiculoService.buscarVehiculo(patente);

    }

    @DeleteMapping("/borrar/{idVehiculo}")
    public ResponseEntity<?> borrarVehiculo(@PathVariable("idVehiculo") int idVehiculo){

        vehiculoService.borrarVehiculo(idVehiculo);

        return new ResponseEntity<>(new Mensaje("ok"), HttpStatus.OK);

    }

    @GetMapping("/listar")
    public List<VehiculoResponse> listarVehiculos(){

        return vehiculoService.listarVehiculos();

    }
    
}
