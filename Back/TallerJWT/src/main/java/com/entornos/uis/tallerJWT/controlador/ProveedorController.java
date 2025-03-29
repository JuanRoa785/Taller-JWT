package com.entornos.uis.tallerJWT.controlador;

import com.entornos.uis.tallerJWT.modelo.Proveedor;
import com.entornos.uis.tallerJWT.servicio.ProveedorService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/proveedores")
public class ProveedorController {
    @Autowired
    ProveedorService proveedorService;
    
    @GetMapping("/list")
    public List<Proveedor> getProveedores(){
        return proveedorService.getProveedores();
    }

    @GetMapping("/list/{id}")
    public Proveedor buscarPorId(@PathVariable Long id){
        Proveedor proveedor = proveedorService.buscarProveedor(id);
        if(proveedor == null){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proveedor no encontrado");
        }
        return proveedor;
    }
    
    @PostMapping("/addProveedor")
    public ResponseEntity<Proveedor> agregarProveedor(@Valid @RequestBody Proveedor proveedor){
        Proveedor obj = proveedorService.nuevoProveedor(proveedor);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping("/updateProveedor")
    public ResponseEntity<Proveedor> editar(@Valid @RequestBody Proveedor proveedor){
        Proveedor obj = proveedorService.buscarProveedor(proveedor.getId());
        if (obj != null) {
           
            obj.setCiudad(proveedor.getCiudad());
            obj.setDireccion(proveedor.getDireccion());
            obj.setNombre(proveedor.getNombre());
            obj.setTelefono(proveedor.getTelefono());
            obj.setNit(proveedor.getNit());
            
            proveedorService.nuevoProveedor(obj);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proveedor no encontrado");
        }  
    }
    
    @DeleteMapping("/deleteProveedor/{id}")
    public ResponseEntity<Proveedor> eliminar(@PathVariable Long id){
        Proveedor obj = proveedorService.buscarProveedor(id);
        if(obj != null) {
            proveedorService.borrarProveedor(id);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proveedor no encontrado");
        }
    }
}
