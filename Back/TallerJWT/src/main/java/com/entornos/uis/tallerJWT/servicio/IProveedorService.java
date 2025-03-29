package com.entornos.uis.tallerJWT.servicio;

import com.entornos.uis.tallerJWT.modelo.Proveedor;
import java.util.List;

/**
 *
 * @author roa
 */
public interface IProveedorService {
    List<Proveedor> getProveedores();
    
    Proveedor nuevoProveedor(Proveedor proveedor);
    
    Proveedor buscarProveedor(Long id);
    
    Proveedor borrarProveedor(Long id);
}
