package com.posicionup.crm;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNombreContaining(String nombre);
    List<Cliente> findByEmailContaining(String email);
    List<Cliente> findByEmpresaContaining(String empresa);
}