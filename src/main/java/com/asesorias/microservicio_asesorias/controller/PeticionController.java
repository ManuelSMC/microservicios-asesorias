package com.asesorias.microservicio_asesorias.controller;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.asesorias.microservicio_asesorias.entity.*;
import com.asesorias.microservicio_asesorias.service.PeticionService;
import com.asesorias.microservicio_asesorias.dto.PeticionDTO;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/peticiones")

public class PeticionController {

    @Autowired
    private PeticionService peticionService;

    // READ - Get all
    @GetMapping
    public ResponseEntity<List<Peticion>> getAll() {
        List<Peticion> lista = peticionService.getAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    // READ - Get by ID

    @GetMapping("/{id}")
    public ResponseEntity<Peticion> getById(@PathVariable Integer id) {
        Peticion peticion = peticionService.getById(id);
        if (peticion != null) {
            return new ResponseEntity<>(peticion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
