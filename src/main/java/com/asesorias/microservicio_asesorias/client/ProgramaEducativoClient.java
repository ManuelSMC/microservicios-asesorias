package com.asesorias.microservicio_asesorias.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.asesorias.microservicio_asesorias.dto.MateriaDTO;
import com.asesorias.microservicio_asesorias.dto.UsuarioDTO;
// import com.asesorias.administrador.config.FeignConfig;

@FeignClient(name = "microservicio-admin") // Después se agrega | configuration = FeignConfig.class | Para propagar el token
public interface ProgramaEducativoClient {
    @PostMapping("/api/usuarios/by-ids") // Se debe agregar el endpoint by-ids en el endpoint de usuarios del microservicio del  admin
    List<UsuarioDTO> getUsuariosByIds(@RequestBody List<Integer> ids); // Asi se debe de llamar la función del endpoint

    @PostMapping("/api/materias/by-ids") // Se debe agregar el endpoint by-ids en el endpoint de materias del microservicio del admin
    List<MateriaDTO> getMateriasByIds(@RequestBody List<Integer> ids); // Asi se debe de llamar la función del endpoint
}
