package com.duocuc.turismoreal.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duocuc.turismoreal.request.RegistroFuncionario;
import com.duocuc.turismoreal.service.FuncionarioService;

@RestController
@RequestMapping("funcionario")
public class FuncionarioController {
 
    @Autowired
    FuncionarioService funcionarioService;
    
    @PostMapping("/registrar")
    public void registrarFuncionario(@RequestBody(required = true) RegistroFuncionario registroFuncionario){

        funcionarioService.registrarFuncionario(registroFuncionario);

    }
}
