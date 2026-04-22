package com.posicionup.crm;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    // ✏️ ACTUALIZAR PERFIL
    @PutMapping("/usuario")
    public Usuario actualizarPerfil(@RequestBody Usuario datos) {

        Usuario user = repository.findById(datos.getId()).orElseThrow();

        user.setNombre(datos.getNombre());
        user.setAvatar(datos.getAvatar());

        return repository.save(user);
    }
}