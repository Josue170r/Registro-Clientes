package org.example.registro_clientes.service;

import org.example.registro_clientes.models.Cliente;

import java.util.List;

public interface ClienteService {
    public List<Cliente> readAllClientes();
    public Cliente readCliente(Long id);
    public void createCliente(Cliente cliente);
    public void deleteCliente(Long id);
}
