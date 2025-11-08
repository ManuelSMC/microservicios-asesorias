package com.asesorias.microservicio_asesorias.controller;

import java.util.List;
import com.asesorias.microservicio_asesorias.dto.AsesoriaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.asesorias.microservicio_asesorias.entity.Asesoria;
import com.asesorias.microservicio_asesorias.service.AsesoriaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/admin")
public class AsesoriaController {

    @Autowired
    private AsesoriaService asesoriaService;

    // CREATE
    @PostMapping
    public ResponseEntity<Asesoria> create(@RequestBody Asesoria asesoria) {
        Asesoria nuevo = asesoriaService.create(asesoria);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    // READ - Get all
    @GetMapping
    public ResponseEntity<List<Asesoria>> getAll() {
        List<Asesoria> lista = asesoriaService.getAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    // READ - Get by ID
    @GetMapping("/{id}")
    public ResponseEntity<Asesoria> getById(@PathVariable Integer id) {
        Asesoria asesoria = asesoriaService.getById(id);
        if (asesoria != null) {
            return new ResponseEntity<>(asesoria, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Asesoria> update(@PathVariable Integer id, @RequestBody AsesoriaDTO asesoriaDTO) {
        Asesoria actualizado = asesoriaService.update(id, asesoriaDTO);
        if (actualizado != null) {
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DISABLE
    @PutMapping("/{id}/disable")
    public ResponseEntity<Asesoria> disable(@PathVariable Integer id) {
        Asesoria deshabilitado = asesoriaService.disable(id);
        if (deshabilitado != null) {
            return new ResponseEntity<>(deshabilitado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // ENABLE
    @PutMapping("/{id}/enable")
    public ResponseEntity<Asesoria> enable(@PathVariable Integer id) {
        Asesoria habilitado = asesoriaService.enable(id);
        if (habilitado != null) {
            return new ResponseEntity<>(habilitado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
