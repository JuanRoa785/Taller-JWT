package com.entornos.uis.tallerJWT.servicio;


import com.entornos.uis.tallerJWT.modelo.Tipodocumento;
import java.util.List;

/**
 *
 * @author Juan Diego Roa
 */
public interface ITipodocumentoService {
    List<Tipodocumento> getTipodocumento();
    
    Tipodocumento nuevoTipodocumento(Tipodocumento tipodocumento);
    
    Tipodocumento buscarTipodocumento(Long id);
    
    Tipodocumento borrarTipodocumento(Long id);
}
