package com.asesorias.microservicio_asesorias.dto;

import lombok.Data;

@Data
public class PeticionDTO {
    private Integer idPeticion;
    private String tema;
    private String descripcion;
    private String fechaCreacion;
    private Boolean status;
}