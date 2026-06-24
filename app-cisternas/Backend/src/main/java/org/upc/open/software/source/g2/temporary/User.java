package org.upc.open.software.source.g2.temporary;

import lombok.*;

import java.util.Map;

public class User {

    @Getter
    @Setter
    public String user;
    @Getter
    @Setter
    public String password;
    @Getter
    @Setter
    public String rol;
    @Getter
    @Setter
    public boolean estado;

    public User(String user, String password, String rol, boolean estado) {
        this.estado = estado;
        this.user = user;
        this.password = password;
        this.rol = rol;
    }

    public static final Map<String, User> USERS = Map.of(
            "admin", new User("admin123","admin123", "ADMIN", true),
            "operador", new User("operador123","operador123", "OPERADOR", true),
            "inactivo", new User("inactivo123","inactivo123", "OPERADOR", false)
    );
}

