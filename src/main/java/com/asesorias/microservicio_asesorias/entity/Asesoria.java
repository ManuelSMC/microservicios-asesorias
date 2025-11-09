package com.asesorias.microservicio_asesorias.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "asesoria")
@Data
public class Asesoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asesoria")
    private Integer idAsesoria;

    @Column(name = "tema")
    private String tema;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "lugar")
    private String lugar;

    @Column(name = "modalidad")
    private String modalidad;

    @Column(name = "hora_inicio")
    private String horaInicio;

    @Column(name = "hora_fin")
    private String horaFin;

    @Column(name = "fecha_creacion")
    private String fechaCreacion;

    @Column(name = "status")
    private Boolean status;
}
