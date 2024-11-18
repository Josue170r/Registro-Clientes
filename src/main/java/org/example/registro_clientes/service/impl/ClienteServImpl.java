package org.example.registro_clientes.service.impl;

import org.example.registro_clientes.models.Cliente;
import org.example.registro_clientes.models.EntidadFederativa;
import org.example.registro_clientes.models.Municipio;
import org.example.registro_clientes.repository.ClienteRepository;
import org.example.registro_clientes.repository.EntidadRepository;
import org.example.registro_clientes.repository.MunicipioRepository;
import org.example.registro_clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServImpl implements ClienteService {
    @Autowired
    private ClienteRepository dao;
    @Autowired
    private MunicipioRepository municipioDao;
    @Autowired
    private EntidadRepository entidadDao;

    @Override
    public List<Cliente> readAllClientes() {
        return (List<Cliente>) dao.findAll();
    }

    @Override
    public Cliente readCliente(Long id) {
        return dao.findById(id).orElseThrow(
            () -> new RuntimeException("Cliente no encontrado con id " + id)
        );
    }

    @Override
    public void createCliente(Cliente cliente) {
//        Long idMunicipio = cliente.getIdMunicipio().getIdMunicipio();
//        Optional<Municipio> municipioOptional = municipioDao.findById(idMunicipio);
//        Municipio municipio = municipioOptional
//                .orElseThrow(() -> new RuntimeException("Municipio no encontrado con id " + idMunicipio));
//        Long idEntidad = municipio.getIdEntidad().getIdEntidad();
//        Optional<EntidadFederativa> entidadOptional = entidadDao.findById(idEntidad);
//        EntidadFederativa entidad = entidadOptional
//                .orElseThrow(() -> new RuntimeException("Entidad Federativa no encontrada"));
//        cliente.setIdMunicipio(municipio);
//        cliente.setIdEntidad(entidad);
//        dao.save(cliente);
        System.out.println(cliente);
    }

    @Override
    public void deleteCliente(Long id) {
        dao.deleteById(id);
    }
}
