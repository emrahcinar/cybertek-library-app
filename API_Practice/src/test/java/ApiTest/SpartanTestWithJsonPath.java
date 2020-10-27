package ApiTest;


import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.responseSpecification;
import static org.testng.Assert.*;
import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.baseURI;

public class SpartanTestWithJsonPath {


    @BeforeClass
    public void Class() {
        baseURI = "http://54.174.216.245:8000";


    }
    /*
    Given accept type is json
    And path param spartan id is 11
    When user sends a get request to /api/spartans/{id}
    Then status code is 200
    And content type is Json
    And "id":11
        "name":"Nona"
        "gender":"Female"
        "phone":7959094216
     */

    @Test
    public void test1() {
        Response response = given().accept(ContentType.JSON)
                .pathParam("id", 11)
                .when().get("/api/spartans/{id}");


        //how to read with path()method
        assertEquals(response.statusCode(), 200);
        int id = response.path("id");
        System.out.println("id = " + id);

        //how to read value with JsonPath
        JsonPath jsonData = response.jsonPath();
        int id1 = jsonData.getInt("id");
        String name = jsonData.getString("name");
        String gender = jsonData.getString("gender");
        long phone = jsonData.getLong("phone");
        System.out.println("id1 = " + id1);
        System.out.println("name = " + name);
        System.out.println("gender = " + gender);
        System.out.println("phone = " + phone);

        assertEquals(id,11);
        assertEquals(name,"Alice");
        assertEquals(gender,"Female");
        assertEquals(phone,9906873020l);


//VIDEO 13 IZLENDI
    }

}