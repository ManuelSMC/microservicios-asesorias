package com.asesorias.microservicio_asesorias.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
    private String nombre;
    private String password;
    private String rol;
    private Integer status;
    // private Integer programaEducativoId; terminar de implementar cuando el microservicio de admin esté listo para comunicación
}