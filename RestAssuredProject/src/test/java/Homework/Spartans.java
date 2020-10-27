package Homework;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Spartans {
    static RequestSpecification requestVariable;
    static ResponseSpecification responseVariable;

    @BeforeAll
    public static void set() {
        RestAssured.baseURI = "http://54.160.106.84";
        RestAssured.port = 8000;
        RestAssured.basePath = "/api";

        requestVariable = given()
                .auth().basic("admin", "admin");

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();

        responseVariable = responseSpecBuilder.expectStatusCode(200)
                .expectBody("[11].name", is("Kermit"))
                .expectBody("[11].id", notNullValue())
                .expectBody("[11].phone", is(7973232685l))
                .expectBody("[11].gender", notNullValue(String.class)).build();

//                then()
//                .statusCode(200)
//                .body("[11].name", is("Kermit"));

    }

    @Test
    public void testAllSpartans() {
        Response response = given()
                .auth().basic("admin", "admin")
                .when()
                .get("/spartans")
                .then()
                .statusCode(200)
                .body("[11].name", is("Kermit")).extract().response();

    }

    @Test
    public void testAllSpartansThen() {

        Response response = given()
                .auth().basic("admin", "admin")
                .when()
                .get("/spartans");
//                .then()
//                .statusCode(200)
//                .body("[11].name",is("Kermit")).extract().response();

        assertThat("Kermit", is(response.jsonPath().getString("[11].name")));
    }

    @Test
    public void testAllSpartansReuse() {
        given()
                .spec(requestVariable)
                .accept(ContentType.JSON)
                .when()
                .get("/spartans")
                .prettyPeek()
                .then()
                .spec(responseVariable);

    }
}