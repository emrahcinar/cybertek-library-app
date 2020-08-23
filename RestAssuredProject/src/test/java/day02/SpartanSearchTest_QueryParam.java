package day02;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class SpartanSearchTest_QueryParam {

    @BeforeAll
    public static void setUp() {

        RestAssured.baseURI = "http://100.25.192.231:8000";
        RestAssured.basePath = "/api";
    }

    //http://100.25.192.231:8000/api/spartans/search?gender=male&nameContains=ea
    @DisplayName("Testing/spartans/search Endpoint")
    @Test
    public void testSearch() {

        given()
                .log().all()
                .queryParam("gender","Male")
                .queryParam("nameContain","ea")
                .when()
                .get("spartans/search")
                .then()
                .log().all()
                .statusCode(is(200))
        .body("numberOfElements",is(99));


    }

}
