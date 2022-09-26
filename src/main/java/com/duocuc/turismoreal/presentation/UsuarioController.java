package com.duocuc.turismoreal.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.duocuc.turismoreal.request.ActualizarUsuario;
import com.duocuc.turismoreal.response.UsuarioResponse;
import com.duocuc.turismoreal.service.UsuarioService;

public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PutMapping("/cambiar-password")
    public void cambiarPassword(@RequestBody(required = true) ActualizarUsuario actualizarUsuario) {

        usuarioService.actualizarPassword(actualizarUsuario);

    }

    @GetMapping("/login/{nombreUsuario}/{password}")
    public UsuarioResponse iniciarSesion(@PathVariable(required = true) String nombreUsuario,
            @PathVariable(required = true) String password) {

        return usuarioService.iniciarSesion(nombreUsuario, password);

    }

}
