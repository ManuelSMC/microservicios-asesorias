package com.asesorias.microservicio_asesorias.dto;

import lombok.Data;

@Data
public class AsesoriaDTO {
    private Integer idAsesoria;
    private String tema;
    private String descripcion;
    private String lugar;
    private String modalidad;
    private String horaInicio;
    private String horaFin;
    private String fechaCreacion;
    private Boolean status;
}