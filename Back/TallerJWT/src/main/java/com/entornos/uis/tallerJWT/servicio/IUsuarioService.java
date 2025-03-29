package com.entornos.uis.tallerJWT.servicio;

import com.entornos.uis.tallerJWT.dto.UsuarioDTO;
import com.entornos.uis.tallerJWT.modelo.Usuario;
import java.util.List;

/**
 *
 * @author roa
 */
public interface IUsuarioService {
    List<UsuarioDTO> getUsuarios();
    
    Usuario nuevoUsuario(UsuarioDTO usuario);
    
    Usuario buscarUsuario(Long id);
    
    Usuario buscarPorUserName(String userName);
    
    public String verificarUsuario(UsuarioDTO usuario);
    
    int borrarUsuario(Long id);
}
