/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.cleverp.model;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.sql.Date;

import lombok.Data;

/**
 *
 * @author Carlos
 */
@Entity
@Data
@Table(name = "client", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"dni"}),
    @UniqueConstraint(columnNames = {"email"})
})
public class Cliente {

    private static final long serialVersionUID = 1L;

    @Id //L'atribut idUsuari és la clau primària de la BBDD
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Generació autonumèrica de l'id
    @Column(name = "id")
    private long id;

    @Column(name = "dni")
    @Pattern(regexp = "^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$", message = "El DNI debe tener 8 dígitos seguidos de una letra permitida: (TRWAGMYFPDXBNJZSQVHLCKE)")
    private String dni;

    @Column(name = "nom")
    @NotEmpty(message = "El nombre no puede ser nulo ni vacío")
    @Size(max = 45, message = "El nombre no puede tener más de 45 caracteres")
    @Pattern(regexp = "[A-Za-z]+", message = "El nombre solo puede contener letras")
    private String nom;

    @Column(name = "cognom1")
    @NotEmpty(message = "El apellido no puede ser nulo ni vacío")
    @Size(max = 45, message = "El apellido no puede tener más de 45 caracteres")
    @Pattern(regexp = "[A-Za-z]+", message = "El apellido solo puede contener letras")
    private String cognom1;

    @Column(name = "cognom2")
    @Nullable
    @Size(max = 45, message = "El apellido no puede tener más de 45 caracteres")
    @Pattern(regexp = "^[A-Za-z]*$|^$", message = "El apellido solo puede contener letras")
    private String cognom2;

    @Column(name = "data_naixement")
    @NotNull(message = "La fecha de nacimiento no puede ser nula")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "La fecha debe de ser en formado AAA-MM-DD")
    private String data_naixement;

    @Column(name = "direccio")
    private String direccio;

    //Validació perquè l'usuari afegeixi contingut al camp contrasenya
    @Column(name = "data_registre")
    @NotNull(message = "La fecha de registro no puede ser nula")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "La fecha debe de ser en formado AAA-MM-DD")
    private String data_registre;
    @Column(name = "email")
    @Email(message = "El correo electrónico debe tener un formato válido")
    private String email;

}
