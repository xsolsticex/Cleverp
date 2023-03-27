/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.cleverp.controladors;


import com.example.cleverp.dao.EmpleatDAO;
import com.example.cleverp.model.Empleat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;




/**
 *
 * @author Carlos
 */
@Controller
public class empleatController {

    @GetMapping("/login")
    public String login(Model m, @AuthenticationPrincipal User username) {
        //m.addAttribute("Empleat", new Empleat());
        return "login";
    }
    
    @GetMapping("/bootstrap.min.css")
    public String loginError(Model m, @AuthenticationPrincipal User username) {
        //m.addAttribute("Empleat", new Empleat());
        return "Base";
    }
    
    
    @GetMapping("/")
    public String base(Model m, @AuthenticationPrincipal User username) {
        //m.addAttribute("Empleat", new Empleat());
        return "Base";
    }

}
