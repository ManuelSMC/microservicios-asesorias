package com.asesorias.microservicio_asesorias.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asesorias.microservicio_asesorias.dto.AsesoriaDTO;
import com.asesorias.microservicio_asesorias.entity.Asesoria;
import com.asesorias.microservicio_asesorias.repository.AsesoriaRepository;

@Service
public class AsesoriaServiceImpl implements AsesoriaService {

    @Autowired
    private AsesoriaRepository asesoriaRepository;

    @Override
    public List<Asesoria> getAll() {
        // Obtener todos los usuarios (administradores)
        return asesoriaRepository.findAll();
    }

    @Override
    public Asesoria getById(Integer id) {
        // Visualizar un usuario por ID
        return asesoriaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Asesoria no encontrada con ID: " + id));
    }

    @Override
    public Asesoria create(Asesoria asesoria) {
        if (asesoria.getNombre() == null || asesoria.getDescripcion() == null) {
            throw new IllegalArgumentException("Faltan datos obligatorios: nombre, descripcion o status");
        }

        asesoria.setStatus(true);

        Asesoria nuevo = asesoriaRepository.save(asesoria);
        return nuevo;
    }

    @Override
    @Transactional
    public Asesoria update(Integer id, AsesoriaDTO asesoriaDTO) {
        Optional<Asesoria> asesoriaOpt = asesoriaRepository.findById(id);
        if (!asesoriaOpt.isPresent()) {
            return null;
        }
        
        Asesoria asesoria = asesoriaOpt.get();
        
        if (asesoriaDTO.getNombre() != null) {
            asesoria.setNombre(asesoriaDTO.getNombre());
        }
        if (asesoriaDTO.getDescripcion() != null) {
            asesoria.setDescripcion(asesoriaDTO.getDescripcion());
        }
        if (asesoriaDTO.getStatus() != null) {
            asesoria.setStatus(asesoriaDTO.getStatus());
        }
        
        /*if (asesoriaDTO.getProgramasEducativosIds() != null) {
            asesoria.getProgramasEducativos().clear();
            
            for (Integer programaId : asesoriaDTO.getProgramasEducativosIds()) {
                UsuarioProgramaEducativo upe = new UsuarioProgramaEducativo();
                upe.setUsuario(asesoria);
                upe.setProgramaEducativoId(programaId);
                asesoria.getProgramasEducativos().add(upe);
            }
        }*/
        
        return asesoriaRepository.save(asesoria);
    }

    @Override
    @Transactional
    public Asesoria disable(Integer id) {
        Optional<Asesoria> asesoriaOpt = asesoriaRepository.findById(id);
        if (asesoriaOpt.isPresent()) {
            Asesoria asesoria = asesoriaOpt.get();
            asesoria.setStatus(false);  
            return asesoriaRepository.save(asesoria);
        }
        return null;
    }

    @Override
    @Transactional
    public Asesoria enable(Integer id) {
        Optional<Asesoria> asesoriaOpt = asesoriaRepository.findById(id);
        if (asesoriaOpt.isPresent()) {
            Asesoria asesoria = asesoriaOpt.get();
            asesoria.setStatus(true);
            return asesoriaRepository.save(asesoria);
        }
        return null;  
    }
}