package com.tienda.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "peliculas")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String director;
    private Integer duracion; // en minutos
    private String genero;
    private String descripcion;

}
