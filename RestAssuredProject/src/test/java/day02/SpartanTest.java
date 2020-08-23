package day02;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class SpartanTest {


    @DisplayName("Get All Spartan")
    @Test
    public void testAllSpartan() {

        // String spartanURL="http://100.25.192.231:8000/api/spartans";
        //how to set bas URL , port, base path so I can use them
        RestAssured.baseURI = "http://100.25.192.231:8000";
        RestAssured.basePath = "/api";

        //it will create the request URL as is
        //baseURI +basePath + what is after get ( "This Part" )


        given().
                header("Accept", "application/json").
                when().
                get("/spartans").
                then().
                statusCode(is(200));

    }

    @DisplayName("Get All Spartan 2")
    @Test
    public void testAllSpartans2(){

        //send me the same requst specifiying the accept header is application/json
        //use baseURI basepath, check status code 200 , contentType header is json

        given()
                .baseUri("http://100.25.192.231:8000")  //alternative way of doing it
                .basePath("/api")
               // .accept("application/json")
                .accept(ContentType.JSON)
                .when()
                .get("/spartans")
                .then()
                .statusCode(is(200))
                //.contentType("application/json;charset=utf-8")
                //.contentType(is ("application/json; charset=utf-8"))
                //easiset way for contentType is using contentType enum
                .contentType(ContentType.JSON);




    }



}
