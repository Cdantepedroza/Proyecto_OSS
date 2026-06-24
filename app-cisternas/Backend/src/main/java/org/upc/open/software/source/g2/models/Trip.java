package org.upc.open.software.source.g2.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(
        name = "viajes",
        uniqueConstraints = @UniqueConstraint(
                name = "uq_viajes_numero_folio",
                columnNames = "numero_folio"
        )
)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "viaje_id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @NotBlank
    @Size(max = 50)
    @Column(name = "numero_folio", nullable = false, unique = true, length = 50)
    private String numeroFolio;

    @NotNull
    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "hora_fin")
    private LocalTime horaFin;

    @NotBlank
    @Size(max = 50)
    @Column(name = "estado_viaje", nullable = false, length = 50)
    private String estadoViaje = "PROGRAMADO";

    @NotBlank
    @Size(max = 50)
    @Column(name = "estado_ficha", nullable = false, length = 50)
    private String estadoFicha = "PENDIENTE";

    @Size(max = 500)
    @Column(name = "observacion", length = 500)
    private String observacion;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "conductor_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_viajes_conductor")
    )
    private User conductor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "ayudante_id",
            foreignKey = @ForeignKey(name = "fk_viajes_ayudante")
    )
    private User ayudante;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "cisterna_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_viajes_cisternas")
    )
    private Cistern cisterna;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "surtidor_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_viajes_surtidores")
    )
    private Dispenser surtidor;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "zona_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_viajes_zonas")
    )
    private Zone zona;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "contratista_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_viajes_contratistas")
    )
    private Contractor contratista;

    @Column(
            name = "fecha_creacion",
            nullable = false,
            insertable = false,
            updatable = false
    )
    private LocalDateTime fechaCreacion;

    @AssertTrue(message = "El ayudante debe ser diferente del conductor")
    public boolean isConductorAyudanteValid() {
        if (ayudante == null || conductor == null) {
            return true;
        }

        if (conductor == ayudante) {
            return false;
        }

        return conductor.getId() == null
                || ayudante.getId() == null
                || !conductor.getId().equals(ayudante.getId());
    }
}
