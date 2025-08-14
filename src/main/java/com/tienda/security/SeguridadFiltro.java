package com.tienda.security;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SeguridadFiltro implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        String path = req.getRequestURI();

        // Permitir libremente estas rutas
        if (path.equals("/") || path.startsWith("/login") || path.startsWith("/modo-invitado")) {
            chain.doFilter(request, response);
            return;
        }

        boolean usuarioLogueado = session != null && Boolean.TRUE.equals(session.getAttribute("usuarioLogueado"));
        boolean modoInvitado = session != null && Boolean.FALSE.equals(session.getAttribute("usuarioLogueado"));

        // Si es modo invitado, solo permitir acceso a /reservar/nueva
        if (modoInvitado && !path.equals("/reservar/nueva")) {
            res.sendRedirect("/");
            return;
        }

        // Si no está logueado y no es invitado, redirigir a /
        if (!usuarioLogueado && !modoInvitado) {
            res.sendRedirect("/");
            return;
        }

        // Todo bien, continuar
        chain.doFilter(request, response);
    }
}
