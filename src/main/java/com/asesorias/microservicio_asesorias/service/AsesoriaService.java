package com.asesorias.microservicio_asesorias.service;

import com.asesorias.microservicio_asesorias.entity.Asesoria;
import com.asesorias.microservicio_asesorias.dto.AsesoriaDTO;
import java.util.List;

public interface AsesoriaService {
    // CREATE
    Asesoria create(Asesoria asesoria);

    // READ
    List<Asesoria> getAll();
    Asesoria getById(Integer id);

    // UPDATE
    Asesoria update(Integer id, AsesoriaDTO asesoriaDTO);

    // DISABLE / ENABLE
    Asesoria disable(Integer id);
    Asesoria enable(Integer id);
}
