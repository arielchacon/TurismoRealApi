package com.duocuc.turismoreal.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duocuc.turismoreal.request.ActualizarCliente;
import com.duocuc.turismoreal.service.ClienteService;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    
    @PutMapping("/actualizar/{runCliente}")
    public void actualizarCliente(@PathVariable(required = true) String runCliente,
            @RequestBody(required = true) ActualizarCliente actualizarCliente) {

        clienteService.actualizarCliente(runCliente, actualizarCliente);

    }

    @DeleteMapping("/eliminar/{runCliente}")
    public void eliminarCliente(@PathVariable(required = true) String runCliente){

        clienteService.borrarCliente(runCliente);

    }

}
