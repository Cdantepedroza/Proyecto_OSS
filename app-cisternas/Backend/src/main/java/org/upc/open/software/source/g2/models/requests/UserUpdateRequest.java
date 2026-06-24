package org.upc.open.software.source.g2.models.requests;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserUpdateRequest {
    private final String nombres;
    private final String apellidos;
    private final String email;
    private final String rol;
}
