package com.posicionup.crm;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController {

    private final ClienteRepository repository;

    public DashboardController(ClienteRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/resumen")
    public Map<String, Object> resumen() {

        List<Cliente> clientes = repository.findAll();

        Map<String, Object> data = new HashMap<>();

        data.put("totalClientes", clientes.size());

        // 🔥 por mes (simplificado)
        Map<String, Integer> porMes = new LinkedHashMap<>();
        porMes.put("Ene", 0);
        porMes.put("Feb", 0);
        porMes.put("Mar", 0);
        porMes.put("Abr", 0);
        porMes.put("May", 0);

        for (Cliente c : clientes) {
            // si tienes fechaAlta puedes usarla aquí
            porMes.put("Abr", porMes.get("Abr") + 1); // temporal
        }

        data.put("clientesPorMes", porMes);

        return data;
    }
}