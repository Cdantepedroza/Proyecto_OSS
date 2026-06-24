package org.upc.open.software.source.g2.models.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "cisternas",
        uniqueConstraints = @UniqueConstraint(
                name = "uq_cisternas_placa",
                columnNames = "placa"
        )
)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cistern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cisterna_id", nullable = false)
    private Integer id;

    @NotBlank
    @Size(max = 20)
    @Column(name = "placa", nullable = false, unique = true, length = 20)
    private String placa;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    @Column(name = "capacidad_m3", nullable = false, precision = 10, scale = 2)
    private BigDecimal capacidadM3;

    @NotBlank
    @Size(max = 50)
    @Column(name = "estado_operativo", nullable = false, length = 50)
    private String estadoOperativo = "DISPONIBLE";

    @NotNull
    @Column(name = "disponible", nullable = false)
    private Boolean disponible = true;

    @Column(
            name = "fecha_registro",
            nullable = false,
            insertable = false,
            updatable = false
    )
    private LocalDateTime fechaRegistro;
}
