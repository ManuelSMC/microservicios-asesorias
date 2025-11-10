package com.asesorias.microservicio_asesorias.service;

import com.asesorias.microservicio_asesorias.dto.UsuarioDTO;
import com.asesorias.microservicio_asesorias.entity.Usuario;
import com.asesorias.microservicio_asesorias.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getById(Integer idUsuario) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(idUsuario);
        return usuarioOpt.orElse(null);
    }

    @Override
    @Transactional
    public Usuario create(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setPassword(usuarioDTO.getPassword());
        usuario.setRol(usuarioDTO.getRol());
        
        // Si no viene status, por defecto es 1 (Activo)
        usuario.setStatus(usuarioDTO.getStatus() != null ? usuarioDTO.getStatus() : 1);
        
        return usuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public Usuario update(Integer idUsuario, UsuarioDTO usuarioDTO) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(idUsuario);
        if (!usuarioOpt.isPresent()) {
            return null;
        }
        
        Usuario usuario = usuarioOpt.get();
        
        if (usuarioDTO.getNombre() != null) {
            usuario.setNombre(usuarioDTO.getNombre());
        }
        if (usuarioDTO.getPassword() != null) {
            usuario.setPassword(usuarioDTO.getPassword());
        }
        if (usuarioDTO.getRol() != null) {
            usuario.setRol(usuarioDTO.getRol());
        }
        if (usuarioDTO.getStatus() != null) {
            usuario.setStatus(usuarioDTO.getStatus());
        }
        
        return usuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public Usuario disable(Integer idUsuario) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(idUsuario);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            usuario.setStatus(0); // Inactivo
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    @Override
    @Transactional
    public Usuario enable(Integer idUsuario) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(idUsuario);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            usuario.setStatus(1); // Activo
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    @Override
    public List<Usuario> getByStatus(Integer status) {
        return usuarioRepository.findByStatus(status);
    }

    @Override
    public List<Usuario> getByRol(String rol) {
        return usuarioRepository.findByRol(rol);
    }
}