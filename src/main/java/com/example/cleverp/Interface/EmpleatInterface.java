/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.cleverp.Interface;


import com.example.cleverp.model.Empleat;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Carlos
 */
public interface EmpleatInterface {

    public List<Empleat> listarEmpleats(); //Mètode que implementarem per llistar gossos

    public void addEmpleat(Empleat empleado); //Mètode que implementarem per afegir un gos

    public void eliminarEmpleat(Empleat empleado); //Mètode que implementarem per eliminar un gos

    public Empleat buscarEmpleat(Empleat empleado); //Mètode que implementarem per cercar un gos
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
