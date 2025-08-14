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
        if (path.startsWith("/login") || path.startsWith("/sin-login") || path.equals("/")) {
            chain.doFilter(request, response);
            return;
        }

        boolean autenticado = session != null && Boolean.TRUE.equals(session.getAttribute("autenticado"));
        boolean sinLogin = session != null && Boolean.TRUE.equals(session.getAttribute("modo_sin_login"));

        // Si es sin login, solo permitir acceso a /reservar/nueva
        if (sinLogin && !path.equals("/reservar/nueva")) {
            res.sendRedirect("/");
            return;
        }

        // Si no autenticado y no modo sin login, redirigir a inicio
        if (!autenticado && !sinLogin) {
            res.sendRedirect("/");
            return;
        }

        // Todo bien, continuar
        chain.doFilter(request, response);
    }
}
