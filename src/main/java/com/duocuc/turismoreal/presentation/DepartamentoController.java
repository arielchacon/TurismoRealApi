package com.duocuc.turismoreal.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.duocuc.turismoreal.request.ActualizarDepartamento;
import com.duocuc.turismoreal.request.RegistroDepartamento;
import com.duocuc.turismoreal.response.DepartamentoResponse;
import com.duocuc.turismoreal.service.DepartamentoService;

@RestController
@RequestMapping("departamento")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
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

    @GetMapping("/listar-departamentos/{idEdificio}")
    public List<DepartamentoResponse> listarDepartamento(@PathVariable(required = true) int idEdificio) {

        return departamentoService.listarDepartamentos(idEdificio);

    }

}
