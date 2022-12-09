package com.duocuc.turismoreal.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.duocuc.turismoreal.request.ActualizarCliente;
import com.duocuc.turismoreal.response.ClienteResponse;
import com.duocuc.turismoreal.response.InfoClienteResponse;
import com.duocuc.turismoreal.service.ClienteService;

@RestController
@RequestMapping("cliente")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
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

    @GetMapping("/buscar-info/{nombreUsuario}")
    public InfoClienteResponse buscarInfo(@PathVariable("nombreUsuario") String nombreUsuario){

        return clienteService.buscarInformacionCliente(nombreUsuario);

    }

    @GetMapping("/buscar/{nombreUsuario}")
    public ClienteResponse buscarCliente(@PathVariable("nombreUsuario") String nombreUsuario){

        return clienteService.buscarCliente(nombreUsuario);

    }

}
