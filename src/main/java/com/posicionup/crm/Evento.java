package com.posicionup.crm;

import jakarta.persistence.*;

@Entity
@Table(name = "eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String fecha;

    private String tipo;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    // 🔥 AÑADE ESTO
    private boolean notificado = false;

    // 🔥 AÑADE ESTO
    private boolean notificado10min = false;

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // 🔥 AÑADE ESTO
    public boolean isNotificado() {
        return notificado;
    }

    public void setNotificado(boolean notificado) {
        this.notificado = notificado;
    }

    // 🔥 AÑADE ESTO
    public boolean isNotificado10min() {
        return notificado10min;
    }

    public void setNotificado10min(boolean notificado10min) {
        this.notificado10min = notificado10min;
    }
}