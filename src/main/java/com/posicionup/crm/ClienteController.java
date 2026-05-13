package com.posicionup.crm;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    private final ClienteRepository repository;

    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    // 🔍 OBTENER TODOS
    @GetMapping
    public List<Cliente> obtenerClientes() {
        return repository.findAll();
    }

    // 🔍 OBTENER POR ID
    @GetMapping("/{id}")
    public Cliente obtenerClientePorId(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    // ➕ CREAR (con código automático)
    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return repository.save(cliente);
    }
    // ✏️ ACTUALIZAR
    @PutMapping("/{id}")
    public Cliente actualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteActualizado) {

        Cliente cliente = repository.findById(id).orElseThrow();

        if (clienteActualizado.getNombre() != null)
            cliente.setNombre(clienteActualizado.getNombre());

        if (clienteActualizado.getEmail() != null)
            cliente.setEmail(clienteActualizado.getEmail());

        if (clienteActualizado.getTelefono() != null)
            cliente.setTelefono(clienteActualizado.getTelefono());

        if (clienteActualizado.getEmpresa() != null)
            cliente.setEmpresa(clienteActualizado.getEmpresa());

        // 🔥 CLAVE
        if (clienteActualizado.getCif() != null)
            cliente.setCif(clienteActualizado.getCif());

        if (clienteActualizado.getDireccion() != null)
            cliente.setDireccion(clienteActualizado.getDireccion());

        return repository.save(cliente);
    }

    // ❌ ELIMINAR
    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable Long id) {
        repository.deleteById(id);
    }

    // 🔎 BUSCAR
    @GetMapping("/buscar")
    public List<Cliente> buscarClientes(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String empresa) {

        if (nombre != null) {
            return repository.findByNombreContaining(nombre);
        }
        if (email != null) {
            return repository.findByEmailContaining(email);
        }
        if (empresa != null) {
            return repository.findByEmpresaContaining(empresa);
        }

        return repository.findAll();
    }

    // 📊 EXPORTAR A EXCEL
    @GetMapping("/exportar")
    public void exportarExcel(HttpServletResponse response) throws IOException {

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

        response.setHeader(
                "Content-Disposition",
                "attachment; filename=clientes_" + java.time.LocalDate.now() + ".xlsx"
        );

        List<Cliente> clientes = repository.findAll();

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Clientes");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Código");
        header.createCell(1).setCellValue("Nombre");
        header.createCell(2).setCellValue("Email");
        header.createCell(3).setCellValue("Teléfono");
        header.createCell(4).setCellValue("Empresa");

        int rowNum = 1;
        for (Cliente c : clientes) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(c.getCodigo());
            row.createCell(1).setCellValue(c.getNombre());
            row.createCell(2).setCellValue(c.getEmail());
            row.createCell(3).setCellValue(c.getTelefono());
            row.createCell(4).setCellValue(c.getEmpresa());
        }

        workbook.write(response.getOutputStream());
        workbook.close();
    }

    // 🧪 TEST
    @GetMapping("/test")
    public Cliente crearClienteTest() {

        long total = repository.count() + 1;
        String codigo = String.format("CL-%03d", total);

        Cliente cliente = new Cliente();
        cliente.setCodigo(codigo);
        cliente.setNombre("Fernando");
        cliente.setEmail("fernando@gmail.com");
        cliente.setTelefono("123456789");
        cliente.setEmpresa("PosicionUp");

        return repository.save(cliente);
    }
}