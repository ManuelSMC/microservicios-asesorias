package com.asesorias.microservicio_asesorias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.asesorias.microservicio_asesorias.repository.PeticionRepository;
import com.asesorias.microservicio_asesorias.entity.Peticion;

import java.util.List;

@Service  
public class PeticionServiceImpl implements PeticionService {

    @Autowired
    private PeticionRepository peticionRepository;

    @Override
    public List<Peticion> getAll() {
        return peticionRepository.findAll();
    }

    @Override
    public Peticion getById(Integer id) {
        return peticionRepository.findById(id).orElse(null);
    }
}
