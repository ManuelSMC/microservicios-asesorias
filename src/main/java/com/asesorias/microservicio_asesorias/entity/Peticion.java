package com.asesorias.microservicio_asesorias.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Peticion")
@Data
public class Peticion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_peticion")
    private Integer idPeticion;

    @Column(name = "tema")
    private String tema;

    @Column(name = "fecha_creacion")
    private String fechaCreacion;

    @Column(name = "status")
    private Boolean status;
}
