package com.posicionup.crm;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturas")
@CrossOrigin("*")
public class FacturaController {

    private final FacturaRepository repository;

    public FacturaController(FacturaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Factura> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Factura guardar(@RequestBody Factura factura) {
        return repository.save(factura);
    }

    @PutMapping("/{id}")
    public Factura actualizar(
            @PathVariable Long id,
            @RequestBody Factura factura
    ) {

        factura.setId(id);

        return repository.save(factura);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}