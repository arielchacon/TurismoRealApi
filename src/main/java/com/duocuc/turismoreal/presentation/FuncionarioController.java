package com.duocuc.turismoreal.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.duocuc.turismoreal.request.ActualizarFuncionario;
import com.duocuc.turismoreal.request.RegistroFuncionario;
import com.duocuc.turismoreal.service.FuncionarioService;

@RestController
@RequestMapping("funcionario")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @PostMapping("/registrar")
    public void registrarFuncionario(@RequestBody(required = true) RegistroFuncionario registroFuncionario) {

        funcionarioService.registrarFuncionario(registroFuncionario);

    }

    @PutMapping("/actualizar/{runFuncionario}")
    public void actualizarFuncionario(@PathVariable(required = true) String runFuncionario,
            @RequestBody(required = true) ActualizarFuncionario actualizarFuncionario) {

        funcionarioService.actualizarFuncionario(runFuncionario, actualizarFuncionario);

    }

    @DeleteMapping("/eliminar/{runFuncionario}")
    public void eliminarFuncionario(@PathVariable(required = true) String runFuncionario){

        funcionarioService.borrarFuncionario(runFuncionario);

    }
}
