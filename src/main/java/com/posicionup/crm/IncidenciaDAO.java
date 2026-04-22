package com.posicionup.crm;

import java.util.List;

public interface IncidenciaDAO {

    List<Incidencia> findAll();

    Incidencia save(Incidencia i);

    void delete(Long id);

    Incidencia findById(Long id);
}