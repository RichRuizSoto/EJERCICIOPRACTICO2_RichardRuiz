package com.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String mostrarIndex() {
        return "index";  // Retorna la plantilla src/main/resources/templates/index.html
    }
}
