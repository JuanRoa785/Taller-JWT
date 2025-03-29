package com.entornos.uis.tallerJWT.config;

import com.entornos.uis.tallerJWT.modelo.Usuario;
import java.util.Collection;
import java.util.Collections;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Juan Diego Roa
 */
public class UsuarioDetails implements UserDetails {
    private Usuario usuario;
    
    public UsuarioDetails() {
    }

    public UsuarioDetails(Usuario usuario) {
        this.usuario = usuario;
    }

    //Metodos de la clase Spring Security
    @Override
    public String getUsername() {
        return this.usuario.getUserName();
    }
    
    @Override
    public String getPassword() {
        return this.usuario.getPassword();
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.usuario.getRol() == '0'){
             return Collections.singleton(new SimpleGrantedAuthority("ADMIN"));
        } else {
            return Collections.singleton(new SimpleGrantedAuthority("USER"));
        }
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
