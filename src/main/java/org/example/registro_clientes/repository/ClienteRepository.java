package org.example.registro_clientes.repository;

import org.example.registro_clientes.models.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
