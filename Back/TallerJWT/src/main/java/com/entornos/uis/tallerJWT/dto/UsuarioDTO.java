package com.entornos.uis.tallerJWT.dto;

import com.entornos.uis.tallerJWT.modelo.Tipodocumento;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 *
 * @author Juan Diego Roa
 */
public class UsuarioDTO {
@NotNull(message = "El nombre NO puede ser nulo")
    @Size(min = 3, max = 100, message = "El nombre DEBE estar entre 3 y 100 caracteres")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    
    @NotNull(message = "El correo NO puede ser nulo")
    @Size(min =10, message = "El email debe tener MINIMO 10 caracteres")
    @Email(message = "El correo electronico ingresado, NO es valido")
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;
    
    @ManyToOne
    @NotNull(message = "El ID del tipo de documento NO puede ser nulo")
    @JoinColumn(name = "idTipoDocumento", nullable = false)
    private Tipodocumento idTipodocumento;
    
    @NotNull(message = "El número del documento NO puede ser nulo")
    @Size(min = 5, max = 50, message = "El documento DEBE tener minimo 5 caracteres")
    @Column(name = "numeroDocumento", nullable = false, length = 50, unique = true)
    private String numeroDocumento;
    
    @NotNull(message = "El UserName NO puede ser nulo")
    @Size(min = 5, max = 15, message = "El UserName DEBE estar entre 5 y 15 caracteres")
    @Column(name = "userName", nullable = false, unique = true, length = 20)
    private String userName;
    
    @NotNull(message = "La contraseña NO puede ser nula")
    @Size(min = 5, message = "La contraseña DEBE tener minimo 5 caracteres")
    @Column(name = "password", length = 200)
    private String password;
    

    public UsuarioDTO() {
        
    }

    public UsuarioDTO(String nombre, String email, Tipodocumento idTipodocumento, String numeroDocumento, String userName, String password) {
        this.nombre = nombre;
        this.email = email;
        this.idTipodocumento = idTipodocumento;
        this.numeroDocumento = numeroDocumento;
        this.userName = userName;
        this.password = password;
    }
    
    public UsuarioDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Tipodocumento getIdTipodocumento() {
        return idTipodocumento;
    }

    public void setIdTipodocumento(Tipodocumento idTipodocumento) {
        this.idTipodocumento = idTipodocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
