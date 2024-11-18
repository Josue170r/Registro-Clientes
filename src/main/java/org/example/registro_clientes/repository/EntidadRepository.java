package org.example.registro_clientes.repository;

import org.example.registro_clientes.models.EntidadFederativa;
import org.springframework.data.repository.CrudRepository;

public interface EntidadRepository extends CrudRepository<EntidadFederativa, Long> {
}
