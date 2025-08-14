package com.tienda.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCliente;
    private int cantidadEntradas;
    private String pelicula; // O puedes usar una relación con `Pelicula` más adelante
}
