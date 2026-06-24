package org.upc.open.software.source.g2.models.responses;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class ContractorResponse {

    public final Integer id;
    public final String razonSocial;
    public final String ruc;
    public final String estado;
}
