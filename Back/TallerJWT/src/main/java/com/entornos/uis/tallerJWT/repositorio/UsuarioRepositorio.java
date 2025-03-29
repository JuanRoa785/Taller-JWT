package com.entornos.uis.tallerJWT.repositorio;

import com.entornos.uis.tallerJWT.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author roa
 */
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
    
    @Query("SELECT u FROM Usuario as u where u.userName=:userName")
    Usuario findByUsername(@Param("userName") String userName);
}
