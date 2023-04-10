/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.cleverp.controladors;

import com.example.cleverp.model.Cliente;
import com.example.cleverp.model.Empleat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
//    @GetMapping("/login")
//    public String login(Model m, @AuthenticationPrincipal User username) {
//        //m.addAttribute("Empleat", new Empleat());
//        return "login";
//    }
//    @GetMapping("/bootstrap.min.css")
//    public String loginError(Model m, @AuthenticationPrincipal User username) {
//        //m.addAttribute("Empleat", new Empleat());
//        return "Base";
//    }

    @GetMapping("/")
    public String base(Model m, @AuthenticationPrincipal User username) {
        m.addAttribute("empleat", empleado.listarEmpleats());
        return "listadoEmpleados";
    }

    @PostMapping("/listadoEmpleados")
    public String base2(Model m, @AuthenticationPrincipal User username) {
        m.addAttribute("empleat", empleado.listarEmpleats());
        return "listadoEmpleados";
    }

    /*@GetMapping("/")
    public String login() {
        return "login";
    }*/
    @GetMapping("/formularioEmpleat")
    public String formularioEmpleat() {
        return "formularioEmpleado";
    }

    @GetMapping("/formularioCliente")
    public String formularioCliente() {
        return "formularioCliente";
    }
    
        @GetMapping("/partides")
    public String partides() {
        return "partides";
    }
    
            @GetMapping("/configuracio")
    public String configuracio() {
        return "configuracio";
    }

    @GetMapping("/listadoEmpleados")
    public String empleados(Model model) {
        model.addAttribute("empleat", empleado.listarEmpleats());
        return "listadoEmpleados";
    }

    @GetMapping("/plantilla")
    public String plantilla(Model model) {
        
        return "plantilla";
    }

    @GetMapping("/listadoClientes")
    public String clientes(Model model) {
        model.addAttribute("clientes", cliente.listarClientes());
        return "listadoClientes";
    }

    @PostMapping("/guardarCliente")
    public String guardaCliente(Cliente client) {
        cliente.addCliente(client);
        return "redirect:/listadoClientes";
    }

    @PostMapping("/guardarEmpleado")
    public String guardaEmpleat(Empleat empl) {
        empleado.addEmpleat(empl);
        return "redirect:/listadoEmpleados";
    }

    @GetMapping("/elimina/cliente/{id}")
    public String eliminarClientes(Cliente client) {
        this.cliente.eliminarCliente(client);
        return "redirect:/listadoClientes";
    }

    @GetMapping("/elimina/empleado/{idUsuari}")
    public String eliminarEmpleats(Empleat empl) {
        this.empleado.eliminarEmpleat(empl);
        return "redirect:/listadoEmpleados";
    }

    @GetMapping("/editar/cliente/{id}")
    public String editarCliente(Cliente client, Model model) {

        /*Cerquem el gos passat per paràmetre, al qual li correspón l'idgos de @GetMapping mitjançant 
         *el mètode cercarGos de la capa de servei.*/
        model.addAttribute("cliente", cliente.buscarCliente(client));

        return "formularioCliente"; //Retorna la pàgina amb el formulari de les dades del gos
    }

    @GetMapping("/editar/empleado/{idUsuari}")
    public String editarEmpleat(Empleat empl, Model model) {

        /*Cerquem el gos passat per paràmetre, al qual li correspón l'idgos de @GetMapping mitjançant 
         *el mètode cercarGos de la capa de servei.*/
        model.addAttribute("empleat", empleado.buscarEmpleat(empl));

        return "formularioEmpleado"; //Retorna la pàgina amb el formulari de les dades del gos
    }

}
