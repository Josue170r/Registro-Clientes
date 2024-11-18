package org.example.registro_clientes.service;

import org.example.registro_clientes.models.Municipio;
import java.util.List;

public interface MunicipioService {
    public List<Municipio> readAllMunicipios();
    public Municipio readMunicipio(Long id);
    public Municipio createMunicipio(Municipio municipio);
    public Municipio updateMunicipio(Long id, Municipio municipio);
    public void deleteMunicipio(Long id);
}
