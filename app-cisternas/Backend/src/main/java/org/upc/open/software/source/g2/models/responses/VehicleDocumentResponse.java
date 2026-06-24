package org.upc.open.software.source.g2.models.responses;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class VehicleDocumentResponse {

    public final Integer id;
    public final String tipoDocumento;
    public final LocalDate fechaEmision;
    public final LocalDate fechaVencimiento;
    public final String estado;
    public final Integer cisternaI;
}
