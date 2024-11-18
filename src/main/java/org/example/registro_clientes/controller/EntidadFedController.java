package org.example.registro_clientes.controller;

import org.example.registro_clientes.models.EntidadFederativa;
import org.example.registro_clientes.models.Municipio;
import org.example.registro_clientes.service.EntidadFederativaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = {"*"})
public class EntidadFedController {
    @Autowired
    private EntidadFederativaService service;

    @GetMapping("/entidades")
    @ResponseStatus(HttpStatus.OK)
    public List<EntidadFederativa> listaEntidades() {
        return service.readAllEntidades();
    }

    @GetMapping("/entidades/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EntidadFederativa buscaEntidadporId(@PathVariable Long id) {
        return service.readEntidadFederativa(id);
    }

    @PostMapping("/entidades")
    @ResponseStatus(HttpStatus.CREATED)
    public EntidadFederativa guardaEntidade(@RequestBody EntidadFederativa entidad) {
        return service.createEntidadFederativa(entidad);
    }

    @PostMapping("/entidades/list")
    @ResponseStatus(HttpStatus.CREATED)
    public List<EntidadFederativa> crearMunicipios(@RequestBody List<EntidadFederativa> entidades) {
        return service.createEntidadesFederativas(entidades);
    }

    @PutMapping("/entidades/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public EntidadFederativa actualizaEntidad(
            @RequestBody EntidadFederativa entidad,
            @PathVariable Long id
    ) {
        return service.updateEntidadFederativa(id, entidad);
    }

    @DeleteMapping("/entidades/{id}")
    public void eliminarEntidade(@PathVariable Long id) {
        service.deleteEntidadFederativa(id);
    }
}
