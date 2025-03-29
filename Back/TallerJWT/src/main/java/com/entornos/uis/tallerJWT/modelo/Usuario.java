package com.entornos.uis.tallerJWT.modelo;


import com.entornos.uis.tallerJWT.dto.UsuarioDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 *
 * @author roa
 */
@Entity
@Table(name=Usuario.TABLE_NAME)
public class Usuario {
    public static final String TABLE_NAME = "usuario";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    
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
    
    @Column(name = "rol", length = 1, nullable = false)
    private char rol = '1';  // 1 = Empleado, 0 = Admin/Gerente

    public Usuario() {
        
    }

    public Usuario(Long id, Tipodocumento idTipodocumento, String numeroDocumento, String nombre, String password, String nombreUsuario, String email) {
        this.id = id;
        this.idTipodocumento = idTipodocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.password = password;
        this.userName = nombreUsuario;
        this.email = email;
    }

    public UsuarioDTO converToDTO() {
        return new UsuarioDTO(
                this.getNombre(), 
                this.getEmail(), 
                this.getIdTipodocumento(), 
                this.getNumeroDocumento(), 
                this.getUserName(),
                this.getPassword()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getRol() {
        return rol;
    }

    public void setRol(char rol) {
        this.rol = rol;
    }
}
