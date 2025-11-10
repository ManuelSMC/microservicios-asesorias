package com.asesorias.microservicio_asesorias.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "password", nullable = false)
    private String password;
    
    @Column(name = "rol", nullable = false)
    private String rol;
    
    @Column(name = "status", nullable = false)
    private Integer status; // 1 = Activo, 0 = Inactivo
}