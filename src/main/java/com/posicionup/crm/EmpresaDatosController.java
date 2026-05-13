package com.posicionup.crm;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empresa")
@CrossOrigin("*")
public class EmpresaDatosController {

    private final EmpresaDatosRepository repo;

    public EmpresaDatosController(EmpresaDatosRepository repo) {
        this.repo = repo;
    }

    // 🔥 GUARDAR
    @PostMapping
    public EmpresaDatos guardar(@RequestBody EmpresaDatos datos) {

        EmpresaDatos existente = repo.findByClienteId(datos.getClienteId()).orElse(null);

        if (existente != null) {
            datos.setId(existente.getId());
        }

        return repo.save(datos);
    }

    // 🔥 OBTENER
    @GetMapping("/{clienteId}")
    public EmpresaDatos obtener(@PathVariable Long clienteId) {
        return repo.findByClienteId(clienteId).orElse(new EmpresaDatos());
    }
}