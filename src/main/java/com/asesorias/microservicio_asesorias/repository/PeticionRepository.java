package com.asesorias.microservicio_asesorias.repository;

import com.asesorias.microservicio_asesorias.entity.Peticion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeticionRepository extends JpaRepository<Peticion, Integer> {
}