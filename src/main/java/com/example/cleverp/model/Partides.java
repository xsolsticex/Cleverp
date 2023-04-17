/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.cleverp.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Aitor
 */
@Entity
@Data
@Table(name="partides")
public class Partides {
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "data_partida")
    @NotNull(message = "La data de partida no pot ser nula")
    //@FutureOrPresent(message = "La data de partida ha de ser en el futur o el present")
    private Date data_partida;
    
    @Column(name = "aforament")
    @NotNull(message = "El aforament no pot ser nul")
    @Max(value = 60, message = "L'aforament máxim del camp es de 60 jugadors.")
    private Integer aforament;
    
    @Column(name = "equipa_id", insertable=false, updatable=false)
    @NotNull(message = "La id de l'equip A no es válida")
    @Min(value = 1, message = "La id de l'equip A no es válida")
    private Integer equipa_id;
    
    @Column(name = "equipb_id", insertable=false, updatable=false)
    @NotNull(message = "La id de l'equip B no es válida")
    @Min(value = 1, message = "La id de l'equip B no es válida")
    private Integer equipb_id;
    
    @Column(name = "guanyador_sorteig")
    @Nullable
    private Integer guanyador_sorteig;
    
    @Column(name = "producte_sorteig")
    @Nullable
    private String producte_sorteig;
    
    // Joins
    @ManyToOne
    @JoinColumn(name = "equipa_id", referencedColumnName = "id")
    private Equip equips_a;
    
    @ManyToOne
    @JoinColumn(name = "equipb_id", referencedColumnName = "id")
    private Equip equips_b;
}
