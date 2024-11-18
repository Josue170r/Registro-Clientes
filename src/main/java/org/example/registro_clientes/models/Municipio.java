package org.example.registro_clientes.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Municipio")
public class Municipio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMunicipio;
    @Column(name = "nombreMunicipio", length = 200, nullable = false)
    private String nombreMunicipio;
    @Column(name = "abrevMunicipio", length = 200, nullable = false)
    private String abrevMunicipio;

    @ManyToOne
    @JoinColumn(name = "idEntidad", nullable = false)
    //Evita la deserialización recursiva
    @JsonIgnoreProperties(value = {"municipios", "handler","hibernateLazyInitializer"}, allowSetters = true)
    private EntidadFederativa idEntidad;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idMunicipio")
    private List<Cliente> clientes;

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
        for (Cliente cliente : clientes) {
            cliente.setIdMunicipio(this);
        }
    }
}
