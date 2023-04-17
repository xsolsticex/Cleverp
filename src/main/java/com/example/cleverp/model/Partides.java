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
    private long id;
    @Column(name = "data_partida")
    private Date data_partida;
    @Column(name = "aforament")
    private Integer aforament;
    @Nullable
    @Column(name = "equipa_id", insertable=false, updatable=false)
    private Integer equipa_id;
    @Nullable
    @Column(name = "equipb_id", insertable=false, updatable=false)
    private Integer equipb_id;
    @Column(name = "guanyador_sorteig")
    private Integer guanyador_sorteig;
    @Column(name = "producte_sorteig")
    private String producte_sorteig;
    
    @ManyToOne
    @Nullable
    @JoinColumn(name = "equipa_id", referencedColumnName = "id")
    private Equip equips_a;
    @ManyToOne
    @Nullable
    @JoinColumn(name = "equipb_id", referencedColumnName = "id")
    private Equip equips_b;
}
