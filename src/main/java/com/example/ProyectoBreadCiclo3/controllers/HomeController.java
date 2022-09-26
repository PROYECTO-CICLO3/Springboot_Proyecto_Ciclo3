package com.example.ProyectoBreadCiclo3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("inicio")
    public String inicio(){
        return "home/inicio";
    }
}
