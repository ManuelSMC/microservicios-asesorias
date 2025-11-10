package com.asesorias.microservicio_asesorias.repository;

import com.asesorias.microservicio_asesorias.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    // Buscar usuarios por status (activos o inactivos)
    List<Usuario> findByStatus(Integer status);
    
    // Buscar usuarios por rol
    List<Usuario> findByRol(String rol);
    
    // Buscar usuarios activos por rol
    List<Usuario> findByRolAndStatus(String rol, Integer status);
}