package com.duocuc.turismoreal.presentation;

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
import com.duocuc.turismoreal.request.ActualizarInventario;
import com.duocuc.turismoreal.request.RegistrarInventario;
import com.duocuc.turismoreal.request.RegistrarObjetoInventario;
import com.duocuc.turismoreal.response.InventarioObjetoRespone;
import com.duocuc.turismoreal.response.InventarioResponse;
import com.duocuc.turismoreal.service.InventarioService;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("inventario")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class InventarioController {

    @Autowired
    InventarioService inventarioService;

    @PostMapping("/crear")
    public ResponseEntity<?> crearInventario(@RequestBody(required = true) RegistrarInventario registrarInventario){

        inventarioService.crearInventario(registrarInventario);

        return new ResponseEntity<>(new Mensaje("ok"), HttpStatus.CREATED);

    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarInventario(@RequestBody(required = true) ActualizarInventario actualizarInventario){

        inventarioService.actualizarInventario(actualizarInventario);

        return new ResponseEntity<>(new Mensaje("ok"), HttpStatus.OK);

    }

    @GetMapping("/buscar/{idInventario}")
    public InventarioResponse buscarInventario(@PathVariable("idInventario") int idInventario){

        return inventarioService.buscarInventario(idInventario);

    }

    @DeleteMapping("/eliminar/{idInventario}")
    public ResponseEntity<?> eliminarInventario(@PathVariable("idInventario") int idInventario){

        inventarioService.eliminarInventario(idInventario);

        return new ResponseEntity<>(new Mensaje("ok"), HttpStatus.OK);

    }

    @PostMapping("/agregar-objeto")
    public ResponseEntity<?> agregarObjetoInventario(@RequestBody(required = true) RegistrarObjetoInventario registrarObjetoInventario){

        inventarioService.agregarObjetoInventario(registrarObjetoInventario);

        return new ResponseEntity<>(new Mensaje("ok"), HttpStatus.CREATED);

    }

    @GetMapping("/inventario-objeto/{idInventario}")
    public InventarioObjetoRespone listarObjetosInventario(int idInventario){

        return inventarioService.listarObjetosInventario(idInventario);

    }

}
