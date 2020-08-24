package day04;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pojo.Spartan;

import static io.restassured.RestAssured.given;

public class PostRequestWithPOJO {

    @BeforeAll
    public static void init() {
        RestAssured.baseURI = "http://54.158.178.13";
        RestAssured.port = 8000;
        RestAssured.basePath = "/api";

    }

    @Test
    public void testPostBodyWithPoho() {

        Spartan sp1 = new Spartan("Emrah CINAR", "Male", 1234567890);

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(sp1)
                .when()
                .post("/spartans")
                .then()
                .log().all()
                .statusCode(201);

    }


}
