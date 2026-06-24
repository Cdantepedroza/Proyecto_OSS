package org.upc.open.software.source.g2.models.responses;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@RequiredArgsConstructor
public class TripResponse {
    public final Integer id;
    public final LocalDate fecha;
    public final String numeroFolio;
    public final LocalTime horaInicio;
    public final LocalTime horaFin;
    public final String estadoViaje;
    public final String estadoFicha;
    public final String observacion;
    public final Integer conductorId;
    public final Integer ayudanteId;
    public final Integer cisternaId;
    public final Integer surtidorId;
    public final Integer zonaId;
    public final Integer contratistaId;
    public final LocalDateTime fechaCreacion;
}
