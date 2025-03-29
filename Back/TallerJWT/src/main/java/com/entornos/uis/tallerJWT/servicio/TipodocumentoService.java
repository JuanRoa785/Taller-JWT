package com.entornos.uis.tallerJWT.servicio;

import com.entornos.uis.tallerJWT.modelo.Tipodocumento;
import com.entornos.uis.tallerJWT.repositorio.TipodocumentoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Juan Diego Roa
 */
@Service
@Transactional
public class TipodocumentoService  implements ITipodocumentoService{
    @Autowired
    TipodocumentoRepositorio tipodocumentoRepositorio;

    @Override
    public List<Tipodocumento> getTipodocumento() {
       return  tipodocumentoRepositorio.findAll();
    }

    @Override
    public Tipodocumento nuevoTipodocumento(Tipodocumento tipodocumento) {
      return tipodocumentoRepositorio.save(tipodocumento);
    }

    @Override
    public Tipodocumento buscarTipodocumento(Long id) {
        return tipodocumentoRepositorio.findById(id).orElse(null);
    }

    @Override
    public Tipodocumento borrarTipodocumento(Long id) {
        Tipodocumento tipodocumento = this.buscarTipodocumento(id);
        if(tipodocumento == null){
            return null;
        }
        tipodocumentoRepositorio.delete(tipodocumento);
        return tipodocumento;
    }
}
