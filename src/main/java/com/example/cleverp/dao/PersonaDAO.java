/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.cleverp.dao;

import com.example.cleverp.model.Persona;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Carlos
 */
public interface PersonaDAO extends CrudRepository<Persona, List> {
    
}
