package com.tienda.controller;

import com.tienda.model.Usuario;
import com.tienda.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/")
    public String elegirModo() {
        return "login/select";  // Vista con botones "Iniciar sesión" o "Entrar sin iniciar"
    }

    @GetMapping("/login")
    public String mostrarLogin(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login/login";
    }

    @PostMapping("/login")
    public String procesarLogin(@ModelAttribute Usuario usuario, HttpSession session, Model model) {
        Optional<Usuario> usuarioAutenticado = usuarioService.autenticar(usuario.getCorreo(), usuario.getContrasena());

        if (usuarioAutenticado.isPresent()) {
            session.setAttribute("usuarioLogueado", true);
            return "redirect:/index";  // Cambia a la ruta principal que tengas
        } else {
            model.addAttribute("error", "Correo o contraseña incorrectos");
            return "login/login";
        }
    }

    @GetMapping("/modo-invitado")
    public String modoInvitado(HttpSession session) {
        session.setAttribute("usuarioLogueado", false);
        return "redirect:/reservar/nueva";
    }

    @GetMapping("/logout")
    public String cerrarSesion(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
