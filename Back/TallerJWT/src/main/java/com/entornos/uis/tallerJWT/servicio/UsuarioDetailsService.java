package com.entornos.uis.tallerJWT.servicio;

import com.entornos.uis.tallerJWT.config.UsuarioDetails;
import com.entornos.uis.tallerJWT.modelo.Usuario;
import com.entornos.uis.tallerJWT.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Diego Roa
 */
@Service
public class UsuarioDetailsService implements UserDetailsService{
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Usuario usuario = usuarioRepositorio.findByUsername(username);
        
        if(usuario == null){
            throw new UsernameNotFoundException("NO se encontró un Usuario con UserName: " + username);
        }
        
        UsuarioDetails usuarioDetails = new UsuarioDetails(usuario);
       
        return usuarioDetails;
    }
}
