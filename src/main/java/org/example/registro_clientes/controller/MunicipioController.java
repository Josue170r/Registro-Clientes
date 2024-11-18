package org.example.registro_clientes.controller;

import org.example.registro_clientes.models.Municipio;
import org.example.registro_clientes.service.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = {"*"})
public class MunicipioController {
    @Autowired
    private MunicipioService service;

    @GetMapping("/municipios")
    @ResponseStatus(HttpStatus.OK)
    public List<Municipio> getMunicipios() {
        return service.readAllMunicipios();
    }

    @GetMapping("/municipios/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Municipio getMunicipio(@PathVariable Long id) {
        return service.readMunicipio(id);
    }

    @PostMapping("/municipios")
    @ResponseStatus(HttpStatus.CREATED)
    public Municipio crearMunicipio(@RequestBody Municipio municipio) {
        return service.createMunicipio(municipio);
    }

    @PostMapping("/municipios/list")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Municipio> crearMunicipios(@RequestBody List<Municipio> municipios) {
        List<Municipio> finalMunicipios = new ArrayList<>();
        System.out.println(municipios);
        for (Municipio municipio : municipios) {
            Municipio  municipio_db = service.createMunicipio(municipio);
            finalMunicipios.add(municipio_db);
        }
        return finalMunicipios;
    }

    @PutMapping("/municipios/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Municipio actualizarMunicipio(
            @PathVariable Long id,
            @RequestBody Municipio municipio
    ) {
        return service.updateMunicipio(id, municipio);
    }

    @DeleteMapping("/municipios/{id}")
    public void eliminarMunicipio(@PathVariable Long id) {
        service.deleteMunicipio(id);
    }
}
