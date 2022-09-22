package com.duocuc.turismoreal.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.duocuc.turismoreal.request.RegistroCliente;
import com.duocuc.turismoreal.service.ClienteService;

@RestController("cliente")
public class ClienteController {
    
    @Autowired
    ClienteService clienteService;

    @PostMapping("/registrar")
    public String registrarCliente(@RequestBody(required = true) RegistroCliente registroCliente){

        return clienteService.registrarCliente(registroCliente);

    }

}
