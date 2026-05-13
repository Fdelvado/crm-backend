package com.posicionup.crm;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
@CrossOrigin("*")
public class EventoController {

    private final EventoRepository repository;

    public EventoController(EventoRepository repository) {
        this.repository = repository;
    }

    // =========================
    // 📋 LISTAR EVENTOS
    // =========================

    @GetMapping
    public List<Evento> listar() {
        return repository.findAll();
    }

    // =========================
    // 💾 GUARDAR EVENTO
    // =========================

    @PostMapping
    public Evento guardar(@RequestBody Evento evento) {
        return repository.save(evento);
    }

    // =========================
    // ✏️ EDITAR EVENTO
    // =========================

    @PutMapping("/{id}")
    public Evento editar(@PathVariable Long id, @RequestBody Evento eventoActualizado) {

        Evento evento = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento no encontrado"));

        evento.setTitulo(eventoActualizado.getTitulo());
        evento.setFecha(eventoActualizado.getFecha());
        evento.setTipo(eventoActualizado.getTipo());
        evento.setDescripcion(eventoActualizado.getDescripcion());

        return repository.save(evento);
    }

    // =========================
    // 🗑️ ELIMINAR EVENTO
    // =========================

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}