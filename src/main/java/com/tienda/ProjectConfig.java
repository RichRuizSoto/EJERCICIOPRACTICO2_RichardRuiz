package com.tienda;

import com.tienda.security.SeguridadFiltro;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    public FilterRegistrationBean<SeguridadFiltro> filtroSeguridad() {
        FilterRegistrationBean<SeguridadFiltro> registration = new FilterRegistrationBean<>();
        registration.setFilter(new SeguridadFiltro());
        registration.addUrlPatterns("/*");
        return registration;
    }
}
