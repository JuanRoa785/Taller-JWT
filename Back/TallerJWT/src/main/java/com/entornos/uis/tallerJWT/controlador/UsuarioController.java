package com.entornos.uis.tallerJWT.controlador;

import com.entornos.uis.tallerJWT.dto.LoginDTO;
import com.entornos.uis.tallerJWT.dto.UsuarioDTO;
import com.entornos.uis.tallerJWT.modelo.Usuario;
import com.entornos.uis.tallerJWT.servicio.TipodocumentoService;
import com.entornos.uis.tallerJWT.servicio.UsuarioService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author roa
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    TipodocumentoService TipodocumentoService;
    
    @GetMapping("/list")
    public List<UsuarioDTO> cargarUsuario(){
        return usuarioService.getUsuarios();
    }

    @GetMapping("/list/{id}")
    public UsuarioDTO buscarPorId(@PathVariable Long id){
        Usuario usuario = usuarioService.buscarUsuario(id);
        if(usuario == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
        } 
        return usuario.converToDTO();
    }
    
    @PostMapping("/signUp")
    public ResponseEntity<UsuarioDTO> registrarUsuario(@Valid @RequestBody UsuarioDTO usuario) {
        if (TipodocumentoService.buscarTipodocumento(usuario.getIdTipodocumento().getId()) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de Documento invalido");
        }
        Usuario obj = usuarioService.nuevoUsuario(usuario);
        return new ResponseEntity<>(obj.converToDTO(), HttpStatus.OK);
    }
    
    @PostMapping("/logIn")
    public ResponseEntity<?> iniciarSesion(@Valid @RequestBody LoginDTO usuarioData) {
        UsuarioDTO usuario = new UsuarioDTO(usuarioData.getUserName(), usuarioData.getPassword());
        String token = usuarioService.verificarUsuario(usuario);
        
        if (token == null || token.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("mensaje", "Credenciales incorrectas"));
        }
        
        return ResponseEntity.ok(Map.of("token", token));
    }
    
    @PutMapping("/updateUser")
    public ResponseEntity<UsuarioDTO> editar(@Valid @RequestBody UsuarioDTO usuario){
        Usuario obj = usuarioService.buscarPorUserName(usuario.getUserName());
        
        if (obj != null) {
            if (TipodocumentoService.buscarTipodocumento(usuario.getIdTipodocumento().getId()) == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de Documento invalido");
            }
            
            obj.setEmail(usuario.getEmail());
            obj.setIdTipodocumento(usuario.getIdTipodocumento());
            obj.setNombre(usuario.getNombre());
            obj.setUserName(usuario.getUserName());
            obj.setNumeroDocumento(usuario.getNumeroDocumento());
            obj.setPassword(usuario.getPassword());
            
            usuarioService.nuevoUsuario(obj.converToDTO());
            return new ResponseEntity<>(obj.converToDTO(), HttpStatus.OK);
        }
         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
    }
    
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<UsuarioDTO> eliminar(@PathVariable Long id){
        Usuario obj = usuarioService.buscarUsuario(id);
        if(obj != null) {
            usuarioService.borrarUsuario(id);
            return new ResponseEntity<>(obj.converToDTO(), HttpStatus.OK);
        }
         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
    }
}