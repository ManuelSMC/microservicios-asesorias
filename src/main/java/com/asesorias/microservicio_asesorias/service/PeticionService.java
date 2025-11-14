package com.asesorias.microservicio_asesorias.service;

import com.asesorias.microservicio_asesorias.entity.Peticion;
import java.util.List;

public interface PeticionService {
    //READ
    List<Peticion> getAll();
    Peticion getById(Integer id);
}
