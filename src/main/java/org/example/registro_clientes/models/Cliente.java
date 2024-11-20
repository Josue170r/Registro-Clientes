package org.example.registro_clientes.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 20, message = "Nombre debe estar entre 3 y 20")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "El nombre solo puede contener letras y espacios")
    @Column(name = "nombreCliente", length = 100, nullable = false)
    private String nombreCliente;

    @NotBlank(message = "El apellido paterno no puede estar vacío")
    @Size(min = 3, max = 20, message = "Apellido no debe ser mayor a 20")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "El apellido paterno solo puede contener letras y espacios")
    @Column(name = "apellidoPaterno", length = 100, nullable = false)
    private String apellidoPaterno;

    @Size(max = 20, message = "El apellido materno no debe exceder los 20 caracteres")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]*$", message = "El apellido materno solo puede contener letras y espacios")
    @Column(name = "apellidoMaterno", length = 100)
    private String apellidoMaterno;

    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "Formato inválido")
    @Size(min = 3, max = 50, message = "Email no debe ser mayor a 50")
    @Column(name = "email", length = 150, nullable = false)
    private String email;

    @NotBlank(message = "La calle no puede estar vacía")
    @Column(name = "calle", length = 255, nullable = false)
    private String calle;

    @NotBlank(message = "La colonia no puede estar vacía")
    @Column(name = "colonia", length = 255, nullable = false)
    private String colonia;

    @Column(name = "numero",length = 255, nullable = false)
    private int numero;

    @NotBlank(message = "El teléfono no puede estar vacío")
    @Pattern(regexp = "^\\d{10,12}$", message = "El teléfono debe tener entre 10 y 12 dígitos numéricos")
    @Column(name = "telefono", length = 12, nullable = false)
    private String telefono;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMunicipio", nullable = false)
    @JsonIgnoreProperties(value = {"clientes", "idEntidad", "handler", "hibernateLazyInitializer"}, allowSetters = true)
    private Municipio idMunicipio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEntidad", nullable = false)
    @JsonIgnoreProperties(value = {"clientes", "municipios", "handler", "hibernateLazyInitializer"}, allowSetters = true)
    private EntidadFederativa idEntidad;
}
