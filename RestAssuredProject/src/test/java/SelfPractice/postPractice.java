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

public class postPractice {
    @BeforeAll
    public static void init() {
        RestAssured.baseURI = "http://100.25.192.231";
        RestAssured.port = 8000;
        RestAssured.basePath = "/api";
    }

    @DisplayName("Testing POST /api/spartans")
    @Test
    public void testPostSpartan() {

        Map<String, Object> post = new LinkedHashMap<>();

        post.put("name", "Tirsina");
        post.put("gender", "Female");
        post.put("phone", 1987654321);


        given().contentType(ContentType.JSON)
                .log().all()
                .body(post)
                .when()
                .post("/spartans")
                .then()
                .log().all()
                .statusCode(201)
                .body("data.name",is("Tirsina"))
                .body("success",is("A Spartan is Born!"));




    }

}
