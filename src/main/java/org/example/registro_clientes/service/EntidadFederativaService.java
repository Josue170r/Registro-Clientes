package org.example.registro_clientes.service;

import org.example.registro_clientes.models.EntidadFederativa;
import java.util.List;

public interface EntidadFederativaService {
    public List<EntidadFederativa> readAllEntidades();
    public EntidadFederativa readEntidadFederativa(Long id);
    public EntidadFederativa createEntidadFederativa(EntidadFederativa entidad);
    public List<EntidadFederativa> createEntidadesFederativas(List<EntidadFederativa> entidades);
    public EntidadFederativa updateEntidadFederativa(Long id, EntidadFederativa entidad);
    public void deleteEntidadFederativa(Long id);
}
