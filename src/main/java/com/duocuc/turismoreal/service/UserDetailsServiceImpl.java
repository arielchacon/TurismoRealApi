package com.duocuc.turismoreal.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.duocuc.turismoreal.response.UsuarioResponse;
import com.duocuc.turismoreal.security.UsuarioPrincipal;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    UsuarioService usuarioService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        UsuarioResponse usuario = usuarioService.getByNombre(username);

        return UsuarioPrincipal.build(usuario);
    }

}
