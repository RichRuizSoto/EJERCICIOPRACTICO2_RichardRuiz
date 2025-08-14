package com.tienda.controller;

import com.tienda.service.PeliculaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarteleraController {

    private final PeliculaService peliculaService;

    public CarteleraController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping("/cartelera")
    public String verCartelera(Model model) {
        model.addAttribute("peliculas", peliculaService.listarPeliculas());
        return "cartelera/listado"; // Asegúrate de tener listado.html en templates/home
    }
}
