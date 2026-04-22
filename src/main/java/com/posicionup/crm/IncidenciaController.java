package com.posicionup.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/incidencias")
public class IncidenciaController {

    @Autowired
    private IncidenciaDAO dao;

    @GetMapping
    public List<Incidencia> listar() {
        return dao.findAll();
    }

    @PostMapping
    public Incidencia crear(@RequestBody Incidencia i) {
        return dao.save(i);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        dao.delete(id);
    }

    @PutMapping("/{id}")
    public Incidencia actualizar(@PathVariable Long id, @RequestBody Incidencia nueva) {

        Incidencia i = dao.findById(id);

        if (i == null) {
            throw new RuntimeException("No encontrada");
        }

        // 👇 FORZAMOS EL CAMBIO
        i.setEstado(nueva.getEstado());

        return dao.save(i);
    }
    @PutMapping("/test")
    public String testPut() {
        return "PUT FUNCIONA";
    }
}