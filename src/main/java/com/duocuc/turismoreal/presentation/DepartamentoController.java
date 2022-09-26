package com.duocuc.turismoreal.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duocuc.turismoreal.request.ActualizarDepartamento;
import com.duocuc.turismoreal.request.RegistroDepartamento;
import com.duocuc.turismoreal.service.DepartamentoService;

@RestController
@RequestMapping("departamento")
public class DepartamentoController {

    @Autowired
    DepartamentoService departamentoService;

    @PostMapping("/guardar")
    public void guardarDepartamento(@RequestBody(required = true) RegistroDepartamento registroDepartamento) {

        departamentoService.crearDepartamento(registroDepartamento);

    }

    @PutMapping("/actualizar/{idDepartamento}")
    public void actualizarDepartamento(@PathVariable(required = true) int idDepartamento,
            @RequestBody(required = true) ActualizarDepartamento actualizarDepartamento) {

        departamentoService.actualizarDepartamento(idDepartamento, actualizarDepartamento);

    }

    @DeleteMapping("/borrar/{idDepartamento}")
    public void borrarDepartamento(@PathVariable(required = true) int idDepartamento){

        departamentoService.borrarDepartamento(idDepartamento);

    }

}
