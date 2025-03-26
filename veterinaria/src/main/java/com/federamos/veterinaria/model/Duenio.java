package com.federamos.veterinaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Duenio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_duenio;
    private int dni;
    private String nombre_duenio;
    private String apellido_duenio;
    private int celular;

    public Duenio() {
    }

    public Duenio(Long id_duenio, int dni, String nombre_duenio, String apellido_duenio, int celular) {
        this.id_duenio = id_duenio;
        this.dni = dni;
        this.nombre_duenio = nombre_duenio;
        this.apellido_duenio = apellido_duenio;
        this.celular = celular;
    }
}
