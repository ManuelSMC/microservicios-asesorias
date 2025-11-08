package com.asesorias.microservicio_asesorias.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "asesoria_admin")
@Data
public class AsesoriaAdmin {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "asesoria_id")
    @JsonBackReference
    private Asesoria asesoria;

    @Column(name = "usuario_id")
    private Integer usuarioId;

    @Column(name = "materia_id")
    private Integer materiaId;
}