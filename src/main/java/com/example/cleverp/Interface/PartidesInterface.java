/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.cleverp.Interface;

import com.example.cleverp.model.Partides;
import java.util.List;

/**
 *
 * @author Aitor
 */
public interface PartidesInterface {

    public List<Partides> listarPartides(); 

    public void addPartida(Partides partides);

    public void eliminarPartida(Partides partides);
    
    public Partides buscarPartida(Partides partides);
    
}
