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

import static io.restassured.RestAssured.given;

public class putPractice {


    @BeforeAll
    public static void init() {
        RestAssured.baseURI = "http://100.25.192.231";
        RestAssured.port = 8000;
        RestAssured.basePath = "/api";
    }
    @DisplayName("Testing PUT /api/spartans")
    @Test
            public void testPutSpartan() {
        Map<String, Object> put = new LinkedHashMap<>();

        put.put("name", "LoveYou");
        put.put("gender", "Female");
        put.put("phone", 1987654321);

        for (int i = 0; i <800 ; i++) {



        given().contentType(ContentType.JSON)
                .pathParam("id",i)
                .log().all()
                .body(put)
                .when()
                .put("/spartans/{id}")
                .then()
                .log().all();
                //.statusCode(204);

        }
    }

}
