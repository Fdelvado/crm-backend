package com.posicionup.crm;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    // =========================
    // ✏️ ACTUALIZAR PERFIL
    // =========================

    @PutMapping("/{id}")
    public Usuario actualizarPerfil(
            @PathVariable Long id,
            @RequestBody Usuario datos
    ) {

        Usuario user =
                repository.findById(id)
                        .orElseThrow();

        user.setNombre(
                datos.getNombre()
        );

        user.setAvatar(
                datos.getAvatar()
        );

        user.setRol(
                datos.getRol()
        );

        return repository.save(user);
    }

    // =========================
    // 👤 OBTENER USUARIO
    // =========================

    @GetMapping("/{id}")
    public Usuario obtenerUsuario(
            @PathVariable Long id
    ) {

        return repository.findById(id)
                .orElseThrow();
    }
}