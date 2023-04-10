/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.cleverp.controladors;

import com.example.cleverp.Interface.ClienteInterface;
import com.example.cleverp.dao.ClienteDAO;
import com.example.cleverp.model.Cliente;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Carlos
 */
@Service
@Slf4j
public class ClienteService implements ClienteInterface {

    /*Atribut que defineix un UsuariDAO, injectant els seu mètodes a aquesta classe (@Autowired),
     *els quals ens permeten interactuar amb les taules de la BBDD pels usuaris i rols
     */
    @Autowired
    private ClienteDAO cliente;

    /*Únic mètode de la interface UserDetailsService que retornarà un usuari a partir del nom d'usuari.
     *L'usuari que retorna es de tipus UserDetails que és una interface de Spring Security que defineix
     *els mètodes necessaris per treballar amb un usuari.
     */

    @Override
    @Transactional
    public List<Cliente> listarClientes() {
        return (List<Cliente>) cliente.findAll();
    }

    @Override
    @Transactional
    public void addCliente(Cliente cliente) {
        this.cliente.save(cliente);
    }

    @Override
    @Transactional
    public void eliminarCliente(Cliente cliente) {
        this.cliente.delete(cliente);
    }

    @Override
    @Transactional
    public Cliente buscarCliente(Cliente cliente) {
        return this.cliente.findById(cliente.getId()).orElse(null);
    }



}
