package com.example.cleverp.model;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Exercici: Descripció:
 *
 * @author brian
 */
//id_usuari, password, dni, username, cognom1, cognom2, data_naixement, direccio, email, salari, carrec
@Data
@Entity
@Table(name = "empleat")
public class Empleat implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id //L'atribut idUsuari és la clau primària de la BBDD
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Generació autonumèrica de l'id
    @Column(name = "id_usuari")
    private long idUsuari;
    
//    @Column(name = "dni")
//    private String dni;
    @Column(name = "dni")
    @Pattern(regexp = "^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$", message = "El DNI debe tener 8 dígitos seguidos de una letra permitida: (TRWAGMYFPDXBNJZSQVHLCKE)")
    private String dni;
    
//    @Column(name="cognom1")
//    private String cognom1;
    @Column(name="cognom1")
    @NotEmpty(message = "El apellido no puede ser nulo ni vacío")
    @Size(max = 45, message = "El apellido no puede tener más de 45 caracteres")
    @Pattern(regexp = "[A-Za-z]+", message = "El apellido solo puede contener letras")
    private String cognom1;
    
//    @Column(name="cognom2")
//    private String cognom2;
    @Column(name="cognom2")
    @Nullable
    @Size(max = 45, message = "El apellido no puede tener más de 45 caracteres")
    @Pattern(regexp = "[A-Za-z]+", message = "El apellido solo puede contener letras")
    private String cognom2;
    
//    @Column(name="data_naixement")
//    private Date data_naixement;
   @Column(name="data_naixement")
   @NotNull(message = "La fecha de nacimiento no puede ser nula")
   @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "La fecha debe de ser en formado AAA-MM-DD")
    private String data_naixement;
    
    @Column(name="direccio")
    private String direccio;
    
    @NotEmpty(message = "El campo contraseña no puede estar vacío")
    @Column(name="password")
    private String password;
    
    @Column(name="username")
    @NotEmpty(message = "El campo username no puede estar vacío")
    @Pattern(regexp = "[A-Za-z]+", message = "El nombre de usuario solo puede contener letras")
    private String username;
    
//    @Column(name="salari")
//    private float salari;
    @Column(name="salari")
    @Pattern(regexp = "^[0-9]{3,4}\\.[0-9]{2}$", message = "El salario debe tener 3 o 4 dígitos antes del punto decimal y 2 dígitos después del punto decimal")
    private String salari;
    
//    @Column(name="email")
//    private String email;
    @Column(name="email")
    @Email(message = "El correo electrónico debe tener un formato válido")
    private String email;
    
    @Column(name="rol")
    @Pattern(regexp="(arbitre|administrador|venedor)", message="El rol debe ser 'arbitre', 'administrador' o 'venedor'")
    private String rol;
    
//    /*Implementem l'atribut que relacionarà l'usuari amb el rol, tenint en compte que un 
//     *usuari pot tenir més d'un rol, per tant serà una col.lecció de tipus list, on guardarem
//     *tots els rols de l'usuari.
//     */
////    @OneToMany //Indica al sistema que la relació entre les taules usuari i rol en aquest cas és d'un a molts.
////    @JoinColumn(name = "id_rolusuari") 
////    private List<Rol> rols;
}
