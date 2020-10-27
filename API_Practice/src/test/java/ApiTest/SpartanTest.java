package ApiTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SpartanTest {
    String spartanBaseUrl = "http://54.174.216.245:8000";


    @Test
    public void viewSpartanTest1() {

        Response response = RestAssured.get(spartanBaseUrl + "/api/spartans");
        //print the status code
        System.out.println("status code = " + response.statusCode());
        //print body
        System.out.println(response.body().prettyPrint());


    }

    /*When user send GET request to /api/spartans end point
    Then status code must be 200
    And body should contains Allen
     */

    @Test
    public void viewSpartanTest2() {

        Response response = RestAssured.get(spartanBaseUrl + "/api/spartans");
        //verify status code 200
        Assert.assertEquals(response.statusCode(), 200);

        //verify body contains Adan
        Assert.assertTrue(response.body().asString().contains("Marina"));

    }

    /*Given accept type is Json
    When user sends a ger request to spartan All URL
    Then response status code is 200
    And response body should be json format
     */

    @Test
    public void viewSpartanTest3() {

        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .when()
                .get(spartanBaseUrl + "/api/spartans");
        //verify statuscode
        Assert.assertEquals(response.statusCode(), 200);

        //verify response body json
        Assert.assertEquals(response.contentType(), "application/json;charset=UTF-8");


    }

}
