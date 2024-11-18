package org.example.registro_clientes;

import org.example.registro_clientes.models.EntidadFederativa;
import org.example.registro_clientes.models.Municipio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RegistroClientesApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RegistroClientesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("---Registros clientes---");
    }
}
