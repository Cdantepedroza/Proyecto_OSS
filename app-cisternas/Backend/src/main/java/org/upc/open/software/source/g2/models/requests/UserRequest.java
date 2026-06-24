package org.upc.open.software.source.g2.models.requests;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserRequest {
    public final String nombres;
    public final String apellidos;
    public final String email;
    public final String password;
    public final String rol;
    public final String estado;
}
