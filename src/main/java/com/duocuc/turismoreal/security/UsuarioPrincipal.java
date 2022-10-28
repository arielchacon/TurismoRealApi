package com.duocuc.turismoreal.security;

import java.util.Collection;
import java.util.List;

import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.duocuc.turismoreal.response.UsuarioResponse;


public class UsuarioPrincipal implements UserDetails{
    
    private int idUsuario;
    private String nombreUsuario;
    private String password;
    private String estado;
    private Collection<? extends GrantedAuthority> authorities;

    public UsuarioPrincipal(int idUsuario, String nombreUsuario, String password,String estado,  Collection<? extends GrantedAuthority> authorities) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.estado = estado;
        this.authorities=authorities;
    }

    public static UsuarioPrincipal build(UsuarioResponse usuario){
        List<GrantedAuthority> authorities =
                usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRol())).collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getIdUsuario(), usuario.getNombreUsuario(), usuario.getPassword(), usuario.getEstado() ,authorities);
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        return authorities;
    }

    @Override
    public String getPassword() {
        
        return password;
    }

    @Override
    public String getUsername() {
        
        return nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
       
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
       
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        
        return true;
    }

    @Override
    public boolean isEnabled() {
        
        return true;
    }


}
