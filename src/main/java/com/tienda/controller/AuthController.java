package com.tienda.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @GetMapping("/")
    public String seleccionarModo() {
        return "login/select";
    }

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login/login";  // Debes crear esta vista
    }

    @PostMapping("/login")
    public String procesarLogin(String correo, String contrasena, HttpSession session) {
        // Validar con base de datos (por simplicidad, haré un ejemplo simple)
        if ("admin@correo.com".equals(correo) && "1234".equals(contrasena)) {
            session.setAttribute("autenticado", true);
            return "redirect:/cartelera"; // o cualquier vista de inicio
        } else {
            return "login/login"; // vuelve al login si falla
        }
    }

    @GetMapping("/sin-login")
    public String continuarSinLogin(HttpSession session) {
        session.setAttribute("modo_sin_login", true);
        return "redirect:/reservar/nueva";
    }
}
