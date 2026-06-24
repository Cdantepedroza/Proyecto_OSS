package org.upc.open.software.source.g2.models.responses;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class ZoneResponse {

    public final Integer id;
    public final String nombre;
    public final String estado;
}
