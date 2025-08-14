package com.tienda.controller;

import com.tienda.model.Pelicula;
import com.tienda.service.PeliculaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/peliculas")
public class PeliculaController {

    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping
    public String listarPeliculas(Model model) {
        System.out.println(">>> Método listarPeliculas ejecutado");
        model.addAttribute("peliculas", peliculaService.listarPeliculas());
        return "admin/peliculas/lista";
    }


    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("pelicula", new Pelicula());
        return "admin/peliculas/formulario"; // Formulario para crear nueva película
    }

    @PostMapping("/guardar")
    public String guardarPelicula(@ModelAttribute Pelicula pelicula) {
        peliculaService.guardar(pelicula);
        return "redirect:/admin/peliculas";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Pelicula pelicula = peliculaService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Pelicula no encontrada: " + id));
        model.addAttribute("pelicula", pelicula);
        return "admin/peliculas/formulario"; // Reusar formulario para editar
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPelicula(@PathVariable Long id) {
        peliculaService.eliminar(id);
        return "redirect:/admin/peliculas";
    }
}
