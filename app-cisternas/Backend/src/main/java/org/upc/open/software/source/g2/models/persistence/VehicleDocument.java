package org.upc.open.software.source.g2.models.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "documentos_vehiculares")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VehicleDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "documento_id", nullable = false)
    private Integer id;

    @NotBlank
    @Size(max = 100)
    @Column(name = "tipo_documento", nullable = false, length = 100)
    private String tipoDocumento;

    @NotNull
    @Column(name = "fecha_emision", nullable = false)
    private LocalDate fechaEmision;

    @NotNull
    @Column(name = "fecha_vencimiento", nullable = false)
    private LocalDate fechaVencimiento;

    @NotBlank
    @Size(max = 30)
    @Column(name = "estado", nullable = false, length = 30)
    private String estado = "VIGENTE";

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "cisterna_id",
            nullable = false,
            foreignKey = @jakarta.persistence.ForeignKey(
                    name = "fk_documentos_cisternas"
            )
    )
    private Cistern cisterna;

    @AssertTrue(message = "La fecha de vencimiento no puede ser anterior a la fecha de emisión")
    public boolean isDateRangeValid() {
        return fechaEmision == null
                || fechaVencimiento == null
                || !fechaVencimiento.isBefore(fechaEmision);
    }
}
