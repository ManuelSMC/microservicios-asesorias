package com.asesorias.microservicio_asesorias.dto;

import lombok.Data;

@Data
public class MateriaDTO {
    private String nombre;
    private String descripcion;
    private Boolean status;
}