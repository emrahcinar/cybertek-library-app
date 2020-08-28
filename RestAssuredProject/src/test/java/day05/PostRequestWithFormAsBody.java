package day05;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class PostRequestWithFormAsBody {

    //posting in library app
    //body is not json, it's x-urlencoded-form-data

    //http://library1.cybertekschool.com/rest/v1/login
    //baseURI is http://library1.cybertekschool.com
    //basPath is /rest/v1
    //we are working on POST /login

    //post body, x-urlencoded-form-data
    //email: librarian69@library
    //password: KNPXrm3S

    //in URLs if you do no see port, because it's commited because it's so common
    //http--->>80
    //https-->443
    //anything other than above 2 ports needs to be explicitly set in the URL
    //for example spartan app use port 8000 -->>yourip:8000

    @BeforeAll
    public static void init() {

        RestAssured.baseURI = "http://library1.cybertekschool.com";
        RestAssured.basePath = "/rest/v1";

    }

    @DisplayName("POST/login request test")
    @Test
    public void testLoginEndPoint() {

        given()
                .log().all()
                .contentType(ContentType.URLENC)
                .formParam("email", "librarian69@library")
                .formParam("password", "KNPXrm3S")
                .when().post("/login")
                .then()
                .log().all()
                .statusCode(200)
                // we can not actually validate the token since it's dynamic
                // what we can validate though -- token field exists and it's not null
                .body("token", is(notNullValue()));


        //Create a method loginAndGetToken(String username, String password)
        //return: String as the token value
        //

    }

    @DisplayName("Testing out the utility")
    @Test
        public void runningUtilityMethod(){

        System.out.println(loginAndGetToken("librarian69@library","KNPXrm3S") );

    }

    /**
     * A static utility method to get the token by providing username and password
     * as Post request to /Login endpoint and capture the token field from response json
     * @param username
     * @param password
     * @return the token as String from the response json
     */
    public static String loginAndGetToken(String username, String password) {

        String token = "";

        Response response = given()
                .log().all()
                .contentType(ContentType.URLENC)
                .formParam("email", username)
                .formParam("password", password)
                .when().post("/login");

        // token=response.path("token");//this is using path method
        token = response.jsonPath().getString("token");
        return token;

    }

}
