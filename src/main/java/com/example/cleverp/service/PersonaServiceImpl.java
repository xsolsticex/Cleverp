/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.cleverp.service;

import com.example.cleverp.dao.PersonaDAO;
import com.example.cleverp.model.Persona;

/**
 *
 * @author Carlos
 */
public class PersonaServiceImpl implements PersonaService {
    
    private PersonaDAO personaDAO;

    @Override
    public void guardar(Persona persona) {
        personaDAO.save(persona);
    }

    @Override
    public void eliminar(Persona persona) {
       personaDAO.delete(persona);
    }

    @Override
    public void listar() {
        personaDAO.findAll();
    }

    @Override
    public void actualizar(Persona persona, String campo, String valor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
