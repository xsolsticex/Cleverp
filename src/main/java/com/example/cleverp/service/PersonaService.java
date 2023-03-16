/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.cleverp.service;

import com.example.cleverp.model.Persona;

/**
 *
 * @author Carlos
 */
public interface PersonaService {
    void guardar(Persona persona);
    
    void eliminar(Persona persona);
    
    void listar();
    
    void actualizar(Persona persona,String campo,String valor);
}
