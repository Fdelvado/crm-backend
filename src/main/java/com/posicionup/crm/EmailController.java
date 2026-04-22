package com.posicionup.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/correo")
@CrossOrigin
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar")
    public void enviar(@RequestBody Map<String, String> data) {

        String para = data.get("para");
        String asunto = data.get("asunto");
        String mensaje = data.get("mensaje");

        emailService.enviarCorreo(para, asunto, mensaje);
    }

    // 🔥 TEST
    @GetMapping("/test")
    public String test() {
        return "OK";
    }
}