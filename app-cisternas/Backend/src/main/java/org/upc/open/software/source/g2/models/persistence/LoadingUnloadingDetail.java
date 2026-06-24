package org.upc.open.software.source.g2.models.persistence;

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
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "detalles_carga_descarga")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoadingUnloadingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detalle_id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "lectura_inicial", nullable = false, precision = 10, scale = 2)
    private BigDecimal lecturaInicial;

    @NotNull
    @Column(name = "lectura_final", nullable = false, precision = 10, scale = 2)
    private BigDecimal lecturaFinal;

    @NotNull
    @DecimalMin("0.0")
    @Column(
            name = "volumen_distribuido_m3",
            nullable = false,
            precision = 10,
            scale = 2
    )
    private BigDecimal volumenDistribuidoM3;

    @NotBlank
    @Size(max = 100)
    @Column(name = "tipo_liquido", nullable = false, length = 100)
    private String tipoLiquido;

    @DecimalMin("0.0")
    @Column(name = "cloro_residual_mgl", precision = 10, scale = 2)
    private BigDecimal cloroResidualMgl;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "viaje_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_detalles_viajes")
    )
    private Trip viaje;

}
