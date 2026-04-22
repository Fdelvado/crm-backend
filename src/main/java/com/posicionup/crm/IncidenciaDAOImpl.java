package com.posicionup.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IncidenciaDAOImpl implements IncidenciaDAO {

    @Autowired
    private IncidenciaRepository repo;

    @Override
    public List<Incidencia> findAll() {
        return repo.findAll();
    }

    @Override
    public Incidencia save(Incidencia i) {
        return repo.save(i);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Incidencia findById(Long id) {
        return repo.findById(id).orElse(null);
    }
}