package org.upc.open.software.source.g2.models.responses;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class CisternResponse {
    public final Integer id;
    public final String placa;
    public final BigDecimal capacidadM3;
    public final String estadoOperativo;
    public final Boolean disponible;
    public final LocalDateTime fechaRegistro;
}
