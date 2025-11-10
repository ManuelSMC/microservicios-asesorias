package com.asesorias.microservicio_asesorias.service;

import com.asesorias.microservicio_asesorias.dto.UsuarioDTO;
import com.asesorias.microservicio_asesorias.entity.Usuario;
import java.util.List;

public interface UsuarioService {
    
    // CRUD básico
    List<Usuario> getAll();
    Usuario getById(Integer idUsuario);
    Usuario create(UsuarioDTO usuarioDTO);
    Usuario update(Integer idUsuario, UsuarioDTO usuarioDTO);
    
    // Baja lógica
    Usuario disable(Integer idUsuario); // Cambiar status a 0 (Inactivo)
    Usuario enable(Integer idUsuario);  // Cambiar status a 1 (Activo)
    
    // Consultas específicas
    List<Usuario> getByStatus(Integer status);
    List<Usuario> getByRol(String rol);
}