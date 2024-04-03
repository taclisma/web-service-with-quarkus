package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

@QuarkusTest
public class ConversionResourceTest {

    @Test
    public void testConversionKmMiles() {
        given()
            .contentType(ContentType.TEXT)
            // 50 quilômetros por hora
            .body("50")
        .when()
            .post("/Conversion/km-to-miles")
        .then()
            .statusCode(200)
            // O resultado esperado para 50 km/h
            .body(equalTo("31.06855"));
    }

    @Test
    public void testConversionKnotsKm() {
        given()
            .contentType(ContentType.TEXT)
        .when()
            .get("/Conversion/knots-to-km/1")
        .then()
            .statusCode(200)
            // O valor esperado para 1 nó em km/h é 1.852
            .body("valor", is(1.852f));
    }
}