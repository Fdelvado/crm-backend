package com.posicionup.crm;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/gastos")
@CrossOrigin(origins = "*")
public class GastoController {

    private final GastoRepository repo;

    public GastoController(GastoRepository repo) {
        this.repo = repo;
    }

    // 🔍 OBTENER TODOS
    @GetMapping
    public List<Gasto> obtenerGastos() {
        return repo.findAll();
    }

    // ➕ CREAR GASTO
    @PostMapping
    public Gasto crearGasto(@RequestBody Gasto gasto) {
        return repo.save(gasto);
    }

    // ❌ ELIMINAR GASTO
    @DeleteMapping("/{id}")
    public void eliminarGasto(@PathVariable Long id) {
        repo.deleteById(id);
    }

    // 🧪 TEST (gastos aleatorios)
    @GetMapping("/test")
    public Gasto crearGastoTest() {

        String[] conceptos = {"Publicidad", "Herramientas", "Hosting", "Ads", "Software"};
        double[] cantidades = {200, 150, 100, 250, 75};

        Random random = new Random();
        int index = random.nextInt(conceptos.length);

        Gasto gasto = new Gasto();
        gasto.setConcepto(conceptos[index]);
        gasto.setCantidad(cantidades[index]);

        return repo.save(gasto);
    }
}