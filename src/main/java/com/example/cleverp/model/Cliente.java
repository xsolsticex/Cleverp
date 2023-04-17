/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.cleverp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.sql.Date;
import lombok.Data;

/**
 *
 * @author Carlos
 */
@Entity
@Data
@Table(name="client")
public class Cliente {
    private static final long serialVersionUID=1L;

    @Id //L'atribut idUsuari és la clau primària de la BBDD
    @GeneratedValue(strategy=GenerationType.IDENTITY) //Generació autonumèrica de l'id
    @Column(name = "id")
    private long id;
    @Column(name = "dni")
    private String dni;
    @Column(name="nom")
    private String nom;
    @Column(name="cognom1")
    private String cognom1;
    @Column(name="cognom2")
    private String cognom2;
    @Column(name="data_naixement")
    private Date data_naixement;
    @Column(name="direccio")
    private String direccio;
    @NotNull//Validació perquè l'usuari afegeixi contingut al camp contrasenya
    @Column(name="data_registre")
    private Date data_registre;
    @Column(name="email")
    private String email;
    
    
}
