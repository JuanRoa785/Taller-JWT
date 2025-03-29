package com.entornos.uis.tallerJWT.servicio;

import com.entornos.uis.tallerJWT.dto.UsuarioDTO;
import com.entornos.uis.tallerJWT.modelo.Usuario;
import com.entornos.uis.tallerJWT.repositorio.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author roa
 */
@Service
@Transactional
public class UsuarioService  implements  IUsuarioService{

    @Autowired
    UsuarioRepositorio usuarioRepositorio;
    
    @Autowired
    AuthenticationManager authManager;
    
    @Autowired
    JWTService jwtService;
    
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    
    @Override
    public List<UsuarioDTO> getUsuarios() {
        List<Usuario> listaUsuarios  = usuarioRepositorio.findAll();
        List<UsuarioDTO> listaUsuariosDTOs = new ArrayList<>();
        for (Usuario usuario : listaUsuarios) {
            listaUsuariosDTOs.add(usuario.converToDTO());
        }
       return listaUsuariosDTOs;
    }

    @Override
    public Usuario nuevoUsuario(UsuarioDTO usuario) {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(usuario.getNombre());
        nuevoUsuario.setEmail(usuario.getEmail());
        nuevoUsuario.setIdTipodocumento(usuario.getIdTipodocumento());
        nuevoUsuario.setNumeroDocumento(usuario.getNumeroDocumento());
        nuevoUsuario.setUserName(usuario.getUserName());
        nuevoUsuario.setPassword(encoder.encode(usuario.getPassword()));
       return usuarioRepositorio.save(nuevoUsuario);
    }

    @Override
    public Usuario buscarUsuario(Long id) {
        Usuario usuario = usuarioRepositorio.findById(id).orElse(null);
        if (usuario == null) {
            return null;
        }
        return usuario;
    }

    @Override
    public int borrarUsuario(Long id) {
       usuarioRepositorio.deleteById(id);
       return 1;
    }
    
    @Override
     public String  verificarUsuario(UsuarioDTO usuario){
        Authentication authentication = 
                authManager.authenticate(
                        new UsernamePasswordAuthenticationToken(usuario.getUserName(), usuario.getPassword()
                        )
                );
        
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(usuario.getUserName());
        }
        return null;
    }

    @Override
    public Usuario buscarPorUserName(String userName) {
       Usuario usuario = usuarioRepositorio.findByUsername(userName);
        
        if(usuario == null){
            return null;
        }
       
        return usuario;
    }
}
