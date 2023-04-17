/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.cleverp.controladors;

import com.example.cleverp.model.Cliente;
import com.example.cleverp.model.Empleat;
import com.example.cleverp.model.Partides;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

import jakarta.validation.Valid;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author Carlos
 */
@Controller
public class empleatController {

    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosService al controlador    
    private ClienteService cliente;
    @Autowired
    private EmpleatService empleado;
    @Autowired
    private PartidesService partides;

    @GetMapping("/")
    public String base(Model m, @AuthenticationPrincipal User username) {
        m.addAttribute("clientes", cliente.listarClientes());
        return "listadoClientes";
    }
    

//    @PostMapping("/")
//    public String base2(@RequestAttribute("username") String user,Model m, @AuthenticationPrincipal User username) {
//        m.addAttribute("clientes", cliente.listarClientes());
//        m.addAttribute("user", user);
//        return "listadoClientes";
//    }

    
    @PostMapping("/empleats")
    public String base2(Model m, @AuthenticationPrincipal User username) {
        m.addAttribute("empleat", empleado.listarEmpleats());
        return "listadoEmpleados";
    }
    
    @GetMapping("/empleats")
    public String empleados(Model model, @AuthenticationPrincipal User username) {
        model.addAttribute("empleat", empleado.listarEmpleats());
        return "listadoEmpleados";
    }

   
    @GetMapping("/empleat/formulari")
    public String formularioEmpleat() {
        return "formularioEmpleado";
    }
    
     @GetMapping("/editar/empleat/{idUsuari}")
    public String editarEmpleat(Empleat empl, Model model) {

        model.addAttribute("empleat", empleado.buscarEmpleat(empl));

        return "formularioEmpleado"; //Retorna la pàgina amb el formulari de les dades del gos
    }
    
    @PostMapping("/empleats/guardar")
    public String guardaEmpleat(@Valid Empleat empleat, Errors errors) {
        System.out.println(errors);
        if (errors.hasErrors()){ //Si s'han produït errors...
             return "formularioEmpleado"; //Mostrem la pàgina del formulari
        }
        
        empleado.addEmpleat(empleat);
        
        return "redirect:/empleats";
    }
    
    
    
    //

    @GetMapping("/client/formulari")
    public String formularioCliente() {
        return "formularioCliente";
    }

//    @GetMapping("/base")
//    public String base3(Model m, @AuthenticationPrincipal User username) {
//        //m.addAttribute("Empleat", new Empleat());
//        return "Base";
//    }

    @GetMapping("/hola")
    public String hola(Model m) {
        //m.addAttribute("Empleat", new Empleat());
        return "holaAdmin";
    }

    @GetMapping("/holaVenedor")
    public String holaVenedor(Model m) {
        //m.addAttribute("Empleat", new Empleat());
        return "holaVenedor";
    }

    @GetMapping("/partides")
    public String partides(Model model) {
        model.addAttribute("partides", partides.listarPartides());
        return "partides";
    }
        

    @GetMapping("/configuracio")
    public String configuracio() {
        return "configuracio";
    }

    @GetMapping("/plantilla")
    public String plantilla(Model model) {

        return "plantilla";
    }

    @GetMapping("/clients")
    public String clientes(Model model) {
        model.addAttribute("clientes", cliente.listarClientes());
        return "listadoClientes";
    }

    @PostMapping("/clients/guardar")
    public String guardaCliente(Cliente client) {
        cliente.addCliente(client);
        return "redirect:/clients";
    }

   

    @GetMapping("/elimina/client/{id}")
    public String eliminarClientes(Cliente client) {
        this.cliente.eliminarCliente(client);
        return "redirect:/clients";
    }

    @GetMapping("/elimina/empleat/{idUsuari}")
    public String eliminarEmpleats(Empleat empl) {
        this.empleado.eliminarEmpleat(empl);
        return "redirect:/empleats";
    }

    @GetMapping("/editar/client/{id}")
    public String editarCliente(Cliente client, Model model) {

        model.addAttribute("cliente", cliente.buscarCliente(client));

        return "formularioCliente"; //Retorna la pàgina amb el formulari de les dades del gos
    }
    
    @GetMapping("/editar/partida/{id}")
    public String editarPartida(Partides partida, Model model) {
        model.addAttribute("partida", partides.buscarPartida(partida));
        return "formularioPartida";
    }
    
    @GetMapping("/crear/partida/")
    public String crearPartida(Model model) {
        model.addAttribute("partida", new Partides());
        return "formularioCrearPartida";
    }
    
    @PostMapping("/guardarPartida")
    public String guardarPartida(Partides partida) {
        partides.addPartida(partida);
        return "redirect:/partides";
    }
    
    @GetMapping("/elimina/partida/{id}")
    public String eliminarPartida(Partides partida) {
        this.partides.eliminarPartida(partida);
        return "redirect:/partides";
    }
}
