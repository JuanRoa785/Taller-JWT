package com.entornos.uis.tallerJWT.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author roa
 */
@Entity
@Table(name=Tipodocumento.TABLE_NAME)
public class Tipodocumento {
    
    public static final String TABLE_NAME = "tipoDocumento";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "La descripción del tipo de documento NO puede ser nula")
    @Column(name = "descripcion", length = 50, nullable = false)
    private String descripcion;

    public Tipodocumento() {
    
    }

    public Tipodocumento(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
