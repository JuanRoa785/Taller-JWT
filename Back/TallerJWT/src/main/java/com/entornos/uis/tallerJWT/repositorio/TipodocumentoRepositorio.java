package com.entornos.uis.tallerJWT.repositorio;

import com.entornos.uis.tallerJWT.modelo.Tipodocumento;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author roa
 */
public interface TipodocumentoRepositorio  extends JpaRepository<Tipodocumento, Long>{
    
}
