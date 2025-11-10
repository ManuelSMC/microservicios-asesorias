package com.asesorias.microservicio_asesorias.controller;

import com.asesorias.microservicio_asesorias.dto.UsuarioDTO;
import com.asesorias.microservicio_asesorias.entity.Usuario;
import com.asesorias.microservicio_asesorias.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    // CREATE
    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario nuevo = usuarioService.create(usuarioDTO);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }
    
    // READ - Get all
    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        List<Usuario> lista = usuarioService.getAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
    
    // READ - Get by ID
    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuario> getById(@PathVariable Integer idUsuario) {
        Usuario usuario = usuarioService.getById(idUsuario);
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // READ - Get by Status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Usuario>> getByStatus(@PathVariable Integer status) {
        List<Usuario> lista = usuarioService.getByStatus(status);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
    
    // READ - Get by Rol
    @GetMapping("/rol/{rol}")
    public ResponseEntity<List<Usuario>> getByRol(@PathVariable String rol) {
        List<Usuario> lista = usuarioService.getByRol(rol);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
    
    // UPDATE
    @PutMapping("/{idUsuario}")
    public ResponseEntity<Usuario> update(@PathVariable Integer idUsuario, @RequestBody UsuarioDTO usuarioDTO) {
        Usuario actualizado = usuarioService.update(idUsuario, usuarioDTO);
        if (actualizado != null) {
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // DISABLE - Baja lógica (Inactivo)
    @PutMapping("/{idUsuario}/disable")
    public ResponseEntity<Usuario> disable(@PathVariable Integer idUsuario) {
        Usuario deshabilitado = usuarioService.disable(idUsuario);
        if (deshabilitado != null) {
            return new ResponseEntity<>(deshabilitado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // ENABLE - Reactivar (Activo)
    @PutMapping("/{idUsuario}/enable")
    public ResponseEntity<Usuario> enable(@PathVariable Integer idUsuario) {
        Usuario habilitado = usuarioService.enable(idUsuario);
        if (habilitado != null) {
            return new ResponseEntity<>(habilitado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}