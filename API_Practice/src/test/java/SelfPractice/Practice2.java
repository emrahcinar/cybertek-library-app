package SelfPractice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Practice2 {

    @Test
    public void test1() {
        baseURI = "http://54.197.77.137:8000";
        basePath = "/api/spartans";

        given().header("Accept", "application/json").when()
                .get()
                .then()
                .log().all()
                .statusCode(200);


    }


    @Test
    public void test2(){

      given().accept(ContentType.JSON)
              .when().get("/spartans")
              .then().statusCode(200)
      .contentType(ContentType.JSON);

    }

}
