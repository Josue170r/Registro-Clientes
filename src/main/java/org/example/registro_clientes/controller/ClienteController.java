package org.example.registro_clientes.controller;

import org.example.registro_clientes.models.Cliente;
import org.example.registro_clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = {"*"})
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping("/clientes")
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> listarClientes() {
        return service.readAllClientes();
    }

    @GetMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente buscarClientePorId(@PathVariable Long id) {
        return service.readCliente(id);
    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public void guardarCliente(@RequestBody Cliente cliente) {
        System.out.println(cliente);
        service.createCliente(cliente);
    }

    @DeleteMapping("/clientes/{id}")
    public void eliminarCliente(@PathVariable Long id) {
        service.deleteCliente(id);
    }
}