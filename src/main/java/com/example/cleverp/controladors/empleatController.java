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
import org.springframework.web.bind.annotation.RequestAttribute;

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
        m.addAttribute("clientes", cliente.listarClientes());
        return "listadoClientes";
    }
    

    @PostMapping("/")
    public String base2(@RequestAttribute("username") String user,Model m, @AuthenticationPrincipal User username) {
        m.addAttribute("clientes", cliente.listarClientes());
        m.addAttribute("user", user);
        return "listadoClientes";
    }

    @GetMapping("/empleat/formulari")
    public String formularioEmpleat() {
        return "formularioEmpleado";
    }

    @GetMapping("/client/formulari")
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

    @GetMapping("/empleats")
    public String empleados(Model model) {
        model.addAttribute("empleat", empleado.listarEmpleats());
        return "listadoEmpleados";
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

    @PostMapping("/empleats/guardar")
    public String guardaEmpleat(Empleat empl) {
        empleado.addEmpleat(empl);
        return "redirect:/empleats";
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

    @GetMapping("/editar/empleat/{idUsuari}")
    public String editarEmpleat(Empleat empl, Model model) {

        model.addAttribute("empleat", empleado.buscarEmpleat(empl));

        return "formularioEmpleado"; //Retorna la pàgina amb el formulari de les dades del gos
    }

}
