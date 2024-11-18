package org.example.registro_clientes.service.impl;

import org.example.registro_clientes.models.EntidadFederativa;
import org.example.registro_clientes.repository.EntidadRepository;
import org.example.registro_clientes.service.EntidadFederativaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EntidadFedServImpl implements EntidadFederativaService {

    @Autowired
    private EntidadRepository dao;

    @Override
    @Transactional(readOnly = true)
    public List<EntidadFederativa> readAllEntidades() {
        return (List<EntidadFederativa>) dao.findAll();
    }

    @Override
    public EntidadFederativa readEntidadFederativa(Long id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public EntidadFederativa createEntidadFederativa(EntidadFederativa entidad) {
        return dao.save(entidad);
    }

    @Override
    public List<EntidadFederativa> createEntidadesFederativas(List<EntidadFederativa> entidades) {
        return (List<EntidadFederativa>) dao.saveAll(entidades);
    }

    @Override
    public EntidadFederativa updateEntidadFederativa(Long id, EntidadFederativa entidad) {
        EntidadFederativa federativa = dao.findById(id).orElseThrow(() ->
                new RuntimeException("EntidadFederativa no encontrada con id " + id)
        );
        if (entidad.getNombreEntidad() != null) {
            federativa.setNombreEntidad(entidad.getNombreEntidad());
        }
        if (entidad.getAbrevEntidad() != null) {
            federativa.setAbrevEntidad(entidad.getAbrevEntidad());
        }
        return dao.save(federativa);
    }

    @Override
    public void deleteEntidadFederativa(Long id) {
        dao.deleteById(id);
    }
}
