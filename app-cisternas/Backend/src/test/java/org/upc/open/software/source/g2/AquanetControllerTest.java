package org.upc.open.software.source.g2;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class AquanetControllerTest {

    @Test
    void shouldAuthenticateActiveUserAndReturnRoleAccesses() {
        given()
                .contentType("application/json")
                .body("""
                        {
                          "username": "admin",
                          "password": "admin123"
                        }
                        """)
                .when()
                .post("/aquanet/authentication")
                .then()
                .statusCode(200)
                .body("username", is("admin"))
                .body("role", is("ADMIN"))
                .body("accesses", contains("link1", "link2"));
    }

    @Test
    void shouldReturnCustomErrorWhenUserIsInactive() {
        given()
                .contentType("application/json")
                .body("""
                        {
                          "username": "inactivo",
                          "password": "inactivo123"
                        }
                        """)
                .when()
                .post("/aquanet/authentication")
                .then()
                .statusCode(403)
                .body("code", is("USER_INACTIVE"))
                .body("message", is("El usuario se encuentra inactivo"));
    }

    @Test
    void shouldReturnCustomErrorWhenUserDoesNotExist() {
        given()
                .contentType("application/json")
                .body("""
                        {
                          "username": "desconocido",
                          "password": "password"
                        }
                        """)
                .when()
                .post("/aquanet/authentication")
                .then()
                .statusCode(404)
                .body("code", is("USER_NOT_FOUND"))
                .body("message", is("El usuario no existe"));
    }

    @Test
    void shouldRejectIncorrectPassword() {
        given()
                .contentType("application/json")
                .body("""
                        {
                          "username": "admin",
                          "password": "incorrecta"
                        }
                        """)
                .when()
                .post("/aquanet/authentication")
                .then()
                .statusCode(401)
                .body("code", is("INVALID_CREDENTIALS"))
                .body("message", is("La contraseña es incorrecta"));
    }
}
