package day02;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class OpenMovieDB_Test {

    @BeforeAll
    public static void init() {
        baseURI = "http://www.omdbapi.com";

    }

    /// make a request
//    by adding few query parameters like
//    apikey =  your APIKEY
//    t =  the movie you want to search
//    plot =  full
//    then status code 200
//    contentype is json
//            body
//    title is what you are searching for
//    year is as you expected
//    first rating value
//    last rating value
    @DisplayName("Test Movie API")
    @Test
    public void testMovies() {
        given()
                .log().all()
                .header("Accept","application/json")

                .queryParam("apiKey", "26aa5b74")
                .queryParam("t", "Boss Baby")
                .queryParam("plot", "full")
                .when().get().then()
                .log().all()
                .statusCode(is(200))
                //.body("Title", containsString("The Boss Baby"))
                .header("Content-Type",is("application/json; charset=utf-8"))
                .body("Title", is("The Boss Baby"))
                .body("Ratings[0].Value", is("6.3/10"))
                .body("Ratings[-1].Value", is("50/100"))
        ;
    }
}
