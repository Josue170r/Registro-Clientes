package org.example.registro_clientes.service.impl;

import org.example.registro_clientes.models.EntidadFederativa;
import org.example.registro_clientes.models.Municipio;
import org.example.registro_clientes.repository.EntidadRepository;
import org.example.registro_clientes.repository.MunicipioRepository;
import org.example.registro_clientes.service.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MunicipioServiceImpl implements MunicipioService {
    @Autowired
    private MunicipioRepository dao;
    @Autowired
    private EntidadRepository entidadDao;

    @Override
    public List<Municipio> readAllMunicipios() {
        return (List<Municipio>) dao.findAll();
    }

    @Override
    public Municipio readMunicipio(Long id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public Municipio createMunicipio(Municipio municipio) {
        Long idEntidad = municipio.getIdEntidad().getIdEntidad();
        Optional<EntidadFederativa> entidadOptional = entidadDao.findById(idEntidad);
        EntidadFederativa entidad = entidadOptional
                .orElseThrow(() -> new RuntimeException("Entidad Federativa no encontrada"));
        municipio.setIdEntidad(entidad);
        return dao.save(municipio);
    }

    @Override
    public Municipio updateMunicipio(Long id, Municipio municipio) {
        Municipio mun = dao.findById(id).orElseThrow(() ->
                new RuntimeException("Municipio no encontrada con id " + id)
        );
        if (mun.getNombreMunicipio() != null) {
            municipio.setNombreMunicipio(municipio.getNombreMunicipio());
        }
        if (mun.getAbrevMunicipio() != null) {
            mun.setAbrevMunicipio(municipio.getAbrevMunicipio());
        }
        return dao.save(mun);
    }

    @Override
    public void deleteMunicipio(Long id) {
        dao.deleteById(id);
    }
}
