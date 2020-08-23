package day03;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class PutRequestExample {
    @BeforeAll


    public static void init() {

        RestAssured.baseURI = "http://54.158.178.13";
        RestAssured.port = 8000;
        RestAssured.basePath = "/api";
    }


    @DisplayName("Updating existing Data")
    @Test
    public void updateSpartan() {

        String updatedBody = " {\n" +
                "        \"id\": 821,\n" +
                "        \"name\": \"Mimi\",\n" +
                "        \"gender\": \"Female\",\n" +
                "        \"phone\": 1234567890\n" +
                "    }";

        given()
                .contentType(ContentType.JSON)
                .body(updatedBody)
                .log()
                .all()
                .when()
                .put("/spartans/{id}", 821)
                .then()
                .log().all()
                .statusCode(204);

    }

    @Test
    public void testDelete() {

        when()
                .delete("/spartans/{id}", 864)
                .then()
                .statusCode(204)
        .body(is(empty()));


    }
}
