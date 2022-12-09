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
import com.duocuc.turismoreal.request.ActualizarMantenimiento;
import com.duocuc.turismoreal.request.RegistrarMantenimiento;
import com.duocuc.turismoreal.response.MantenimientoResponse;
import com.duocuc.turismoreal.service.MantenimientoService;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("mantenimientos")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class MantenimientoController {

    @Autowired
    MantenimientoService mantenimientoService;

    @PostMapping("/crear")
    public ResponseEntity<?> crearMantenimiento(@RequestBody(required = true) RegistrarMantenimiento registrarMantenimiento){

        mantenimientoService.crearMantenimiento(registrarMantenimiento);

        return new ResponseEntity<>(new Mensaje("ok"), HttpStatus.CREATED);

    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarMantenimiento(@RequestBody(required = true) ActualizarMantenimiento actualizarMantenimiento){

        mantenimientoService.actualizarMantenimiento(actualizarMantenimiento);

        return new ResponseEntity<>(new Mensaje("ok"), HttpStatus.OK);

    }

    @GetMapping("/buscar/{idMantencion}")
    public MantenimientoResponse buscarMantenimiento(@PathVariable("idMantencion") int idMantencion){

        return mantenimientoService.buscarMantenimiento(idMantencion);

    }

    @GetMapping("/listar")
    public List<MantenimientoResponse> listarMantenimientos(){

        return mantenimientoService.listarMantenimientos();

    }

    @DeleteMapping("/eliminar/{idMantencion}")
    public ResponseEntity<?> eliminarMantenimiento(@PathVariable("idMantencion") int idMantencion){

        mantenimientoService.eliminarMantenimiento(idMantencion);

        return new ResponseEntity<>(new Mensaje("ok"), HttpStatus.OK);

    }


    
}
