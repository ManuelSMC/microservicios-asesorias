package com.asesorias.microservicio_asesorias.repository;

import com.asesorias.microservicio_asesorias.entity.Asesoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsesoriaRepository extends JpaRepository<Asesoria, Integer> {
}