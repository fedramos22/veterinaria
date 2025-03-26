package com.federamos.veterinaria.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_mascota;
    private String nombre_mascota;
    private String especie;
    private String raza;
    private String color;
    @OneToOne
    @JoinColumn(name = "id_duenio", referencedColumnName = "id_duenio")
    private Duenio duenio;

    public Mascota() {
    }

    public Mascota(Long id_mascota, String nombre_mascota, String especie, String raza, String color) {
        this.id_mascota = id_mascota;
        this.nombre_mascota = nombre_mascota;
        this.especie = especie;
        this.raza = raza;
        this.color = color;
    }
}
