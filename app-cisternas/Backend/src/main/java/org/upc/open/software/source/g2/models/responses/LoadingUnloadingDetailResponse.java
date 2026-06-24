package org.upc.open.software.source.g2.models.responses;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@RequiredArgsConstructor
public class LoadingUnloadingDetailResponse {
    public final Integer id;
    public final BigDecimal lecturaInicial;
    public final BigDecimal lecturaFinal;
    public final BigDecimal volumenDistribuidoM3;
    public final String tipoLiquido;
    public final BigDecimal cloroResidualMgl;
    public final Integer viajeId;
}
