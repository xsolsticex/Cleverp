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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Null;
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
    @Column(name = "EquipA_id")
    private Integer EquipA_id;
    @Nullable
    @Column(name = "EquipB_id")
    private Integer EquipB_id;
    @Column(name = "guanyador_sorteig")
    private Integer guanyador_sorteig;
    @Column(name = "producte_sorteig")
    private String producte_sorteig;
    
    @OneToMany
    @Nullable
    @JoinColumn(name = "EquipA_id")
    private List<Equip> EquipsA;
    @OneToMany
    @Nullable
    @JoinColumn(name = "EquipB_id")
    private List<Equip> EquipsB;
}
