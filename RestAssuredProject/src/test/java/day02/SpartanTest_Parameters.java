package day02;


import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class SpartanTest_Parameters {
    @BeforeAll
    public static void setUp() {

        RestAssured.baseURI = "http://100.25.192.231:8000";
        RestAssured.basePath = "/api";
    }

    @DisplayName("Testing/spartans/{id}")
    @Test
    public void testingSingleSpartan() {

        given()
                .log()
                .all()
                .pathParam("id", 80)
                .when()
                .get("spartans/{id}")
                .then()
                .statusCode(is(200));


    }

    @DisplayName("Testing2 /spartans/{id}")
    @Test
    public void testingSingleSpartan2() {

        given()
                .log()
                .all()
                .when()
                .get("spartans/{id}", 80)
                .then()
                .statusCode(is(200));
    }

    @DisplayName("Testing /spartans/{id} Body")
    @Test
    public void testSingleSpartanBody() {

        given()
                .log()
                .all()
                .pathParam("id", 80)
                .when()
                .get("spartans/{id}")
                .then()
                .log()
                .all()
                .statusCode(is(200))
                // .body("JSON PATH", is("THE VALUE"))
                .body("id", is(80))
                .body("name", is("Serdar"))
                .body("gender", is("Male"))
                .body("phone", is(1236547890));


    }




}
