package org.upc.open.software.source.g2.models.responses;

import java.time.LocalDateTime;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class UserResponse {
    public final Integer id;
    public final String nombres;
    public final String apellidos;
    public final String email;
    public final String rol;
    public final String estado;
    public final LocalDateTime fechaCreacion;
}
