package com.duocuc.turismoreal.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duocuc.turismoreal.dto.JwtDTO;
import com.duocuc.turismoreal.dto.LoginUsuario;
import com.duocuc.turismoreal.dto.Mensaje;
import com.duocuc.turismoreal.request.ActualizarUsuario;
import com.duocuc.turismoreal.request.RegistroCliente;
import com.duocuc.turismoreal.response.UsuarioResponse;
import com.duocuc.turismoreal.security.JWT.JwtProvider;
import com.duocuc.turismoreal.service.ClienteService;
import com.duocuc.turismoreal.service.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    JwtProvider jwtProvider;

    @PutMapping("/cambiar-password")
    public void cambiarPassword(@RequestBody(required = true) ActualizarUsuario actualizarUsuario) {

        usuarioService.actualizarPassword(actualizarUsuario);

    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarCliente(@RequestBody(required = true) RegistroCliente registroCliente, BindingResult bindingResult) {

        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos vacíos o email inválido"), HttpStatus.BAD_REQUEST);

        String passwordEncode = passwordEncoder.encode(registroCliente.getPassword());

        registroCliente.setPassword(passwordEncode);

        clienteService.registrarCliente(registroCliente);

       return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public ResponseEntity<JwtDTO> iniciarSesion(@RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){

            return new ResponseEntity(new Mensaje("campos vacíos o email inválido"), HttpStatus.BAD_REQUEST);

        }

        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtProvider.generateToken(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        JwtDTO jwtDTO = new JwtDTO(token, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity<JwtDTO>(jwtDTO, HttpStatus.OK);
    }

}
