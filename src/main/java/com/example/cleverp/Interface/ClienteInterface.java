/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.cleverp.Interface;

import com.example.cleverp.model.Cliente;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Carlos
 */
public interface ClienteInterface {

    public List<Cliente> listarClientes(); //Mètode que implementarem per llistar gossos

    public void addCliente(Cliente cliente); //Mètode que implementarem per afegir un gos

    public void eliminarCliente(Cliente cliente); //Mètode que implementarem per eliminar un gos

    public Cliente buscarCliente(Cliente cliente); //Mètode que implementarem per cercar un gos
    
}
