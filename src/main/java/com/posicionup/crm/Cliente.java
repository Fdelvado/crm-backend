package com.posicionup.crm;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes") // 👈 control total

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo; // 🔥 AÑADIR ESTO

    private String nombre;
    private String email;
    private String telefono;
    private String empresa;

    public Cliente() {}

    public Cliente(String nombre, String email, String telefono, String empresa) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.empresa = empresa;
    }

    // GETTERS & SETTERS

    public Long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) { // 🔥 ESTO ES LO QUE FALTABA
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}