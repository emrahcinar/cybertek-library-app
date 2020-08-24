package SelfPractice;

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

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;

public class getPractice {

    @BeforeAll
    public static void init() {
        RestAssured.baseURI = "http://100.25.192.231";
        RestAssured.port = 8000;
        RestAssured.basePath = "/api";
    }

    @DisplayName("Testing GET /api/spartans")
    @Test
    public void testAddSpartan() {

        given()
                .contentType(ContentType.JSON)//json type yazacak
                .log().all()
                .pathParam("id", 237)//hangi id yi gormek istiyorsak
                .when()
                .get("/spartans/{id}")
                .then()
                .log().all().statusCode(200)
                .body("name", is("Ismael"))
                .body("gender", is("Male"))
                .body("phone", is(2122221112));


    }

}
