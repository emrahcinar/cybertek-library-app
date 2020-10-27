package ApiTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static io.restassured.RestAssured.given;

public class SpartanTestWithPathParameters {

    @BeforeClass
    public void Class() {

        RestAssured.baseURI = "54.174.216.245:8000";

    }

/*
Given accepty type is json
And Id parameter value is 111
When users sends GET request to api/spartans/{id}
Then response status code should be 200
And response content-type: application/json;charset=UTF-8
And "Adam" should be in response payload
 */

    @Test
    public void Test1() {


        Response response = RestAssured.given().accept(ContentType.JSON)
                .pathParam("id", 111)
                .when().get("api/spartans/{id}");

        assertEquals(response.statusCode(), 200);

        assertEquals(response.contentType(), "application/json;charset=UTF-8");
        assertTrue(response.body().asString().contains("Marina"));
        response.body().prettyPrint();


    }


}
