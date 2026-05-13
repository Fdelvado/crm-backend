package com.posicionup.crm;

import jakarta.persistence.*;

@Entity
@Table(name = "incidencias")
public class Incidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔥 NUEVO → nombre escrito manual
    private String cliente;

    // 🔥 opcional (lo dejamos por si luego lo usas)
    private Long clienteId;

    private String empresa;
    private String descripcion;
    private String estado;
    private String fecha;
    private String hora;

    // ===== GETTERS =====

    public Long getId() {
        return id;
    }

    public String getCliente() { // 🔥 NUEVO
        return cliente;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    // ===== SETTERS =====

    public void setId(Long id) {
        this.id = id;
    }

    public void setCliente(String cliente) { // 🔥 NUEVO
        this.cliente = cliente;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}