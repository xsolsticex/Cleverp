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
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
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

    //General
    @GetMapping("/")
    public String base(Model m, @AuthenticationPrincipal User username) {
        m.addAttribute("clientes", cliente.listarClientes());
        return "listadoClientes";
    }

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

//    @GetMapping("/plantilla")
//    public String plantilla(Model model) {
//
//        return "plantilla";
//    }
//    @PostMapping("/")
//    public String base2(@RequestAttribute("username") String user,Model m, @AuthenticationPrincipal User username) {
//        m.addAttribute("clientes", cliente.listarClientes());
//        m.addAttribute("user", user);
//        return "listadoClientes";
//    }
    //Empleats:
    @PostMapping("/empleats")
    public String base2(Model m, @AuthenticationPrincipal User username) {
        m.addAttribute("empleat", empleado.listarEmpleats());
        m.addAttribute("nomUsuari", username.getUsername());
        return "listadoEmpleados";
    }

    @GetMapping("/empleats")
    public String empleados(Model model, @AuthenticationPrincipal User username) {
        model.addAttribute("empleat", empleado.listarEmpleats());
        model.addAttribute("nomUsuari", username.getUsername());
        return "listadoEmpleados";
    }

    @GetMapping("/empleat/formulari")
    public String formularioEmpleat(@AuthenticationPrincipal User username) {
        return "formularioEmpleado";
    }

    @GetMapping("/editar/empleat/{idUsuari}")
    public String editarEmpleat(Empleat empl, Model model, @AuthenticationPrincipal User username) {

        model.addAttribute("empleat", empleado.buscarEmpleat(empl));
        model.addAttribute("nomUsuari", username.getUsername());

        return "formularioEmpleado"; //Retorna la pàgina amb el formulari de les dades del gos
    }

    @GetMapping("/empleat/nou")
    public String crearEmpleat(Model model, @AuthenticationPrincipal User username) {

        model.addAttribute("empleat", new Empleat());
        model.addAttribute("nomUsuari", username.getUsername());

        return "formularioCrearEmpleado";
    }

//    @PostMapping("/empleats/guardar")
//    public String guardaEmpleat(@Valid Empleat empleat, Errors errors) {
//        System.out.println(errors);
//        if (errors.hasErrors()){ //Si s'han produït errors...
//             return "formularioEmpleado"; //Mostrem la pàgina del formulari
//        }
//        
//        empleado.addEmpleat(empleat);
//        
//        return "redirect:/empleats";
//    }
    @PostMapping("/empleats/guardarNou")
    public String guardaNouEmpleat(@Valid Empleat empleat, Errors errors, Model model, @AuthenticationPrincipal User username) {
        if (errors.hasErrors()) {
            return "formularioCrearEmpleado";
        }
        try {
            empleado.addEmpleat(empleat);
            return "redirect:/empleats";
        } catch (DataIntegrityViolationException e) {
            if (e.getCause() instanceof ConstraintViolationException) {
                ConstraintViolationException ex = (ConstraintViolationException) e.getCause();
                if (ex.getConstraintName().contains("dni")) {
                    errors.rejectValue("dni", "error.dni", "El DNI ya existe en la base de datos");
                } else if (ex.getConstraintName().contains("email")) {
                    errors.rejectValue("email", "error.email", "El correo electrónico ya existe en la base de datos");
                } else if (ex.getConstraintName().contains("username")) {
                    errors.rejectValue("username", "error.username", "El nombre de usuario ya existe en la base de datos");
                }
            }
            return "formularioCrearEmpleado";
        }
    }

    @PostMapping("/empleats/guardar")
    public String guardaEmpleat(@Valid Empleat empleat, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "formularioEmpleado";
        }
        try {
            empleado.addEmpleat(empleat);
            return "redirect:/empleats";
        } catch (DataIntegrityViolationException e) {
            if (e.getCause() instanceof ConstraintViolationException) {
                ConstraintViolationException ex = (ConstraintViolationException) e.getCause();
                if (ex.getConstraintName().contains("dni")) {
                    errors.rejectValue("dni", "error.dni", "El DNI ya existe en la base de datos");
                } else if (ex.getConstraintName().contains("email")) {
                    errors.rejectValue("email", "error.email", "El correo electrónico ya existe en la base de datos");
                } else if (ex.getConstraintName().contains("username")) {
                    errors.rejectValue("username", "error.username", "El nombre de usuario ya existe en la base de datos");
                }
            }
            return "formularioEmpleado";
        }
    }

    @GetMapping("/elimina/empleat/{idUsuari}")
    public String eliminarEmpleats(Empleat empl) {
        this.empleado.eliminarEmpleat(empl);
        return "redirect:/empleats";
    }

    //Clients:
    @GetMapping("/client/formulari")
    public String formularioCliente() {
        return "formularioCliente";
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

    @GetMapping("/editar/client/{id}")
    public String editarCliente(Cliente client, Model model) {

        model.addAttribute("cliente", cliente.buscarCliente(client));

        return "formularioCliente"; //Retorna la pàgina amb el formulari de les dades del gos
    }

    //Partides
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

    @GetMapping("/client/afegir")
    public String afegirClient(Model m) {
        m.addAttribute("client", new Cliente());
        return "formularioCrearCliente";
    }

    @PostMapping("/client/afegir")
    public String afegirClient(Cliente client) {
        cliente.addCliente(client);
        return "redirect:/clients";
    }
}
