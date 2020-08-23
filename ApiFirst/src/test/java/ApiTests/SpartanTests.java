package ApiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class SpartanTests {

    String spartanBaseURL = "http://54.174.216.245:8000";
    @Test
    public void viewSpartanTest1() {
        Response response = RestAssured.get(spartanBaseURL + "/api/spartans");
        //Print status code
        System.out.println(response.statusCode());//200
        //Print body
        System.out.println(response.body().prettyPrint());
    }
    /*
    When user send GET request to /api/spartans end point
     Then status code must be 200
    And body should contains Allen
     */
    @Test
    public void viewSpartanTest2() {
        Response response =   RestAssured.get(spartanBaseURL+"/api/spartans");

        //verify status code 200
       Assert.assertEquals(response.statusCode(),200);

        //verify body contains Allen
        Assert.assertTrue(response.body().asString().contains("Wyatt"));

    }


    /*
    Given accept type is Json
    When user send a get request to spartanAllURL
    Thenresponse status code is 200
    And response body should be json format
     */
    @Test
    public void viewSpartanTest3(){
  Response response=      RestAssured.given().accept(ContentType.JSON)
                .when().get(spartanBaseURL+"/api/spartans");
        //verify status code
        Assert.assertEquals(response.statusCode(),200);

        //verify response body json
        Assert.assertEquals(response.contentType(),"application/json;charset=UTF-8");
    }






}
