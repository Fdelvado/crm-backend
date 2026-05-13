package com.posicionup.crm;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyectos")
@CrossOrigin("*")
public class ProyectoController {

    private final ProyectoRepository repository;

    public ProyectoController(ProyectoRepository repository) {
        this.repository = repository;
    }

    // =========================
    // 📋 LISTAR
    // =========================

    @GetMapping
    public List<Proyecto> listar() {
        return repository.findAll();
    }

    // =========================
    // 💾 GUARDAR
    // =========================

    @PostMapping
    public Proyecto guardar(
            @RequestBody Proyecto proyecto
    ) {

        return repository.save(proyecto);
    }

    // =========================
    // ✏️ ACTUALIZAR
    // =========================

    @PutMapping("/{id}")
    public Proyecto actualizar(
            @PathVariable Long id,
            @RequestBody Proyecto proyecto
    ) {

        proyecto.setId(id);

        return repository.save(proyecto);
    }

    // =========================
    // 🗑️ ELIMINAR
    // =========================

    @DeleteMapping("/{id}")
    public void eliminar(
            @PathVariable Long id
    ) {

        repository.deleteById(id);
    }
}