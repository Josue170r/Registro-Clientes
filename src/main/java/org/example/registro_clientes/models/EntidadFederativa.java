package org.example.registro_clientes.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "EntidadFederativa")
public class EntidadFederativa implements Serializable {
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEntidad;
    @Setter
    @Column(name = "nombreEntidad", length = 200, nullable = false)
    private String nombreEntidad;
    @Setter
    @Column (name = "abrevEntidad", length = 10, nullable = false)
    private String abrevEntidad;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idEntidad")
    @JsonIgnoreProperties(value = {"clientes", "handler", "hibernateLazyInitializer"}, allowSetters = true)
    private List<Municipio> municipios;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idEntidad")
    private List<Cliente> clientes;

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
        for (Municipio municipio : municipios) {
            municipio.setIdEntidad(this);
        }
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
        for (Cliente cliente : clientes) {
            cliente.setIdEntidad(this);
        }
    }
    @Override
    public String toString() {
        return "EntidadFederativa{" +
                "idEntidad=" + idEntidad +
                ", nombreEntidad='" + nombreEntidad + '\'' +
                ", abrevEntidad='" + abrevEntidad + '\'' +
                '}';
    }
}
