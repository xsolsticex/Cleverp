package com.example.cleverp.dao;

/**
 *Exercici:
 *Descripció:
 * @author brian
 */

import com.example.cleverp.model.Empleat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleatDAO extends JpaRepository<Empleat,Long>{ 
    
    /*Mètode que retornarà l'usuari que passem per paràmetre. 
    *El nom d'aquest mètode ha de ser findByUsername, ja que és el que reconeix Spring Boot
    *com a mètode de seguretat per recuperar l'usuari.
    */
    Empleat findByUsername(String username);
    
}