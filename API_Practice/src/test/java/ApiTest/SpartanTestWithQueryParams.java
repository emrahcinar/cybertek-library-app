package ApiTest;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;
public class SpartanTestWithQueryParams {
    @BeforeClass
    public void Class() {

        baseURI = "http://54.174.216.245:8000";
    }

    /*
    Given accept Type is json
    And query parameters values are:
    gender\Female
    nameContains\e
    When user sends GET request to /api/spartans/search
    Then response status code should be 200
    And response content-type: application/json;charset=UTF-8
    And "Female" should be in response payload
    And "Janette" should be in response payload
     */
    @Test
    public void QueryParam1() {
Response response= given().accept(ContentType.JSON)
                .and().queryParam("gender","Female")
                .queryParam("nameContains","M")
                .when().get("/api/spartans/search");

        assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(),"application/json;charset=UTF-8");
        assertTrue(response.body().asString().contains("Female"));
        assertTrue(response.body().asString().contains("Marina"));

    }

    @Test
    public void queryParams2(){
        //creating Map for Query Params

        Map<String,Object> paramsMap=new HashMap<>();
        paramsMap.put("gender","Female");
        paramsMap.put("nameContains","M");

        //send request

        Response response=   given().accept(ContentType.JSON)
                .queryParams(paramsMap)
                .when().get("/api/spartans/search");

        assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(),"application/json;charset=UTF-8");
        assertTrue(response.body().asString().contains("Female"));
        assertTrue(response.body().asString().contains("Marina"));

    }

}
