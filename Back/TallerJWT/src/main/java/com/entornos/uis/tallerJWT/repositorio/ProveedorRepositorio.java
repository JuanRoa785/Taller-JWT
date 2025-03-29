package com.entornos.uis.tallerJWT.repositorio;

import com.entornos.uis.tallerJWT.modelo.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author roa
 */
public interface ProveedorRepositorio extends JpaRepository<Proveedor, Long> {
    
}
