package com.example.cleverp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

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
    @Column(name = "dni")
    private String dni;
    @Column(name="cognom1")
    private String cognom1;
    @Column(name="cognom2")
    private String cognom2;
    @Column(name="data_naixement")
    private Date data_naixement;
    @Column(name="direccio")
    private String direccio;
    @NotEmpty//Validació perquè l'usuari afegeixi contingut al camp contrasenya
    @Column(name="password")
    private String password;
    @Column(name="username")
    @NotEmpty//Validació perquè l'usuari afegeixi contingut al camp nom d'usuari
    private String username;
    @Column(name="salari")
    private float salari;
    @Column(name="email")
    private String email;
    /*Implementem l'atribut que relacionarà l'usuari amb el rol, tenint en compte que un 
     *usuari pot tenir més d'un rol, per tant serà una col.lecció de tipus list, on guardarem
     *tots els rols de l'usuari.
     */
    @OneToMany //Indica al sistema que la relació entre les taules usuari i rol en aquest cas és d'un a molts.
    @JoinColumn(name = "id_usuari") //Columna de la base de dades que farà de clau forana relacionant les dues taules.
    private List<Rol> rols;
}
