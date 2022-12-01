package com.duocuc.turismoreal.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.duocuc.turismoreal.dto.Mensaje;
import com.duocuc.turismoreal.request.ActualizarFuncionario;
import com.duocuc.turismoreal.request.RegistroFuncionario;
import com.duocuc.turismoreal.service.FuncionarioService;

@RestController
@RequestMapping("funcionario")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @Autowired
    PasswordEncoder passwordEncoder;
    
    @PostMapping("/registrar")
    public ResponseEntity<?> registrarFuncionario(@RequestBody(required = true) RegistroFuncionario registroFuncionario) {

        String passwordEncode = passwordEncoder.encode(registroFuncionario.getPassword());

        registroFuncionario.setPassword(passwordEncode);

        funcionarioService.registrarFuncionario(registroFuncionario);

        return new ResponseEntity(new Mensaje("ok"), HttpStatus.CREATED);

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
