package org.example.registro_clientes.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Clientes")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCliente;
    @Size(min = 3, max = 20, message = "Nombre debe estar entre 3 y 20")
    @Column(name = "nombreCliente", length = 100, nullable = false)
    private String nombreCliente;
    @Size(min = 3, max = 20, message = "Apellido no debe ser mayor a 20")
    @Column(name = "apellidoPaterno", length = 100, nullable = false)
    private String apellidoPaterno;
    @Size(min = 3, max = 20, message = "Apellido no debe ser mayor a 20")
    @Column(name = "apellidoMaterno", length = 100)
    private String apellidoMaterno;
    @Size(min = 3, max = 50, message = "Email no debe ser mayor a 50")
    @Column(name = "email", length = 150, nullable = false)
    private String email;
    @Column(name = "calle", length = 255, nullable = false)
    private String calle;
    @Column(name = "colonia", length = 255, nullable = false)
    private String colonia;
    @Column(name = "numero",length = 255, nullable = false)
    private int numero;
    @Column(name = "telefono", length = 12, nullable = false)
    private String telefono;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMunicipio", nullable = false)
    @JsonManagedReference
    private Municipio idMunicipio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEntidad", nullable = false)
    private EntidadFederativa idEntidad;
}
