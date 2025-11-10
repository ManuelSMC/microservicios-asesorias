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
        return asesoriaRepository.findAll();
    }

    @Override
    public Asesoria getById(Integer id) {
        return asesoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asesoría no encontrada con ID: " + id));
    }

    @Override
    public Asesoria create(Asesoria asesoria) {
        // Validación de campos requeridos
        if (asesoria.getTema() == null || asesoria.getDescripcion() == null) {
            throw new IllegalArgumentException("Faltan datos obligatorios: tema y descripción");
        }

        asesoria.setStatus(true);

        return asesoriaRepository.save(asesoria);
    }

    @Override
    @Transactional
    public Asesoria update(Integer id, AsesoriaDTO asesoriaDTO) {
        Optional<Asesoria> asesoriaOpt = asesoriaRepository.findById(id);
        if (!asesoriaOpt.isPresent()) {
            return null;
        }

        Asesoria asesoria = asesoriaOpt.get();

        // Actualizamos los campos solo si no vienen nulos
        if (asesoriaDTO.getTema() != null) {
            asesoria.setTema(asesoriaDTO.getTema());
        }
        if (asesoriaDTO.getDescripcion() != null) {
            asesoria.setDescripcion(asesoriaDTO.getDescripcion());
        }
        if (asesoriaDTO.getLugar() != null) {
            asesoria.setLugar(asesoriaDTO.getLugar());
        }
        if (asesoriaDTO.getModalidad() != null) {
            asesoria.setModalidad(asesoriaDTO.getModalidad());
        }
        if (asesoriaDTO.getHoraInicio() != null) {
            asesoria.setHoraInicio(asesoriaDTO.getHoraInicio());
        }
        if (asesoriaDTO.getHoraFin() != null) {
            asesoria.setHoraFin(asesoriaDTO.getHoraFin());
        }
        if (asesoriaDTO.getFechaCreacion() != null) {
            asesoria.setFechaCreacion(asesoriaDTO.getFechaCreacion());
        }
        if (asesoriaDTO.getStatus() != null) {
            asesoria.setStatus(asesoriaDTO.getStatus());
        }

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
