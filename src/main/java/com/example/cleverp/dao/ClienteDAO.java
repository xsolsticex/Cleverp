/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.cleverp.dao;

import com.example.cleverp.model.Cliente;
import com.example.cleverp.model.Empleat;
import org.springframework.data.jpa.repository.JpaRepository;



/**
 *
 * @author Carlos
 */
public interface ClienteDAO extends JpaRepository<Cliente, Long> {
    
}
