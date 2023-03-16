/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.cleverp;


import com.example.cleverp.dao.PersonaDAO;
import com.example.cleverp.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



/**
 *
 * @author Carlos
 */
@Controller
public class sprinbotController {

    @Autowired
    private PersonaDAO p;
    
    @GetMapping("/")
    public String login(Model m) {
        m.addAttribute("persona", new Persona());
        return "login";

    }

    @GetMapping("/registro")
    public String inicio(Model m) {
        m.addAttribute("persona", new Persona());
        return "Formulario";

    }

    @PostMapping("/registro")
    public String crearPersona(@ModelAttribute("persona") Persona persona) {
        p.save(persona);
        return "redirect:/listar";
    }

    @GetMapping("/listar")
    public String listar(Model m) {
        Iterable<Persona> lista = p.findAll();
        m.addAttribute("personas",lista);
        return "VistaHolaMundo";
    }
    
    
    @GetMapping("/plantilla")
    public String plantilla(Model m) {
        return "Plantilla";
    }
    
    
    @GetMapping("/eliminar/{id}")
    public String eliminar(Persona persona) {
        p.delete(persona);
        
        return "redirect:/listar";
    }

}
