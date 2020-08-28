package day05;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.Spartan;

import java.util.*;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class SecureSpartanTest {

    //add @Before all and use spartanApp ID with basic auth
    // make a simple get request /spartans/{id}

    @BeforeAll
    public static void init() {
        RestAssured.baseURI = "http://23.23.75.140";
        RestAssured.port = 8000;
        RestAssured.basePath = "/api";
    }


    //add a test
    //make a simple get request/spartans/{id}
    @DisplayName("Test GET /spartans/{id} Endpoint with No Credential ")
    @Test
    public void testGetSingleSpartanSecured() {

        given()
                .log().all()
                .pathParam("id",174).
                when()
                .get("/spartans/{id}").
                then()
                .log().all()
                .statusCode( 401 )
        ;

    }


    @DisplayName("Test GET/spartan/{id} Endpoint with Credentials")
    @Test
    public void testGettingSpartanWithCredentials() {
        int newId = createRandomSpartan();

        given()
                .log().all()
                .auth().basic("admin", "admin")
                .pathParam("id", newId).
                when()
                .get("/spartans/{id}").
                then()
                .log().all()
                .statusCode(200);


    }

    public static int createRandomSpartan() {


        Faker faker = new Faker();
        String name = faker.name().firstName();
        String gender = faker.demographic().sex();
        long phone = faker.number().numberBetween(100000000L, 9999999999L);
        // this what we are going pass for post body
        Spartan sp = new Spartan(name, gender, phone);

        Response response = given()
                .log().ifValidationFails()
                .auth().basic("admin","admin")
                .contentType(ContentType.JSON)
                .body(sp).
                        when()
                .post("/spartans")
                .prettyPeek();
        return response.jsonPath().getInt("data.id");


    }
}
