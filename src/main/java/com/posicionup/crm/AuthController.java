package com.posicionup.crm;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*") // 🔥 permite peticiones desde tu frontend
public class AuthController {

    private final UsuarioRepository repository;

    public AuthController(UsuarioRepository repository) {
        this.repository = repository;
    }

    // 🔐 LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {

        Usuario user = repository.findByUsernameAndPassword(
                usuario.getUsername(),
                usuario.getPassword()
        );

        if (user != null) {

            return ResponseEntity.ok(user);

        } else {

            return ResponseEntity.status(401)
                    .body("Usuario o contraseña incorrectos");
        }
    } }
