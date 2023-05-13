package com.paquier.sistemaVeterinaria.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Facturacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFacturacion;
    @Column(nullable = false)
    private String condicion;
    @Column(nullable = false)
    private LocalDateTime fecha;
    @Column(nullable = false)
    private String numero;
    @Column(nullable = false)
    private String estado;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Cliente cliente;
}
