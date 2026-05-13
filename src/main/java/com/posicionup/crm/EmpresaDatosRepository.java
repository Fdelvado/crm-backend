package com.posicionup.crm;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpresaDatosRepository extends JpaRepository<EmpresaDatos, Long> {
    Optional<EmpresaDatos> findByClienteId(Long clienteId);
}