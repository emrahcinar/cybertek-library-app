package ApiTest;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.responseSpecification;
import static org.testng.Assert.*;
import static io.restassured.RestAssured.given;

public class SpartanTestsWithPathParameters {

    @BeforeClass
    public void Class() {

        baseURI = "http://54.174.216.245:8000";

    }
    /*
    Given accept type is json
    And path param Id is 10
    When user sends a get request to "/api/spartans/{id}"
    Then status code is 200
    And content-type is "application/json;char"
    And response payload values match the following:
         id is 11,
         name is "Alice"
         gender is "Female"
         phone is  9906873020
    */

    @Test
    public void test1() {

    Response response=    given().accept(ContentType.JSON)
                .pathParam("id",11)
                .when()
                .get("/api/spartans/{id}");

        assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(),"application/json;charset=UTF-8");

        //pringting values of json keys
        System.out.println("id = " + response.body().path("id").toString());
        System.out.println("name = " + response.body().path("name").toString());
        System.out.println("gender = " + response.body().path("gender").toString());
        System.out.println("phone = " + response.body().path("phone").toString());

        int id=response.path("id");
        String name=response.body().path("name");
        String gender=response.body().path("gender");
        long phone=response.body().path("phone");

        System.out.println("id = " + id);
        System.out.println("name = " + name);
        System.out.println("gender = " + gender);
        System.out.println("phone = " + phone);

        //verify json keys and values
        assertEquals(id,11);
        assertEquals(name,"Alice");
        assertEquals(gender,"Female");
        assertEquals(phone,9906873020l);



    }
@Test

public void test2(){
      Response response=  get("/api/spartans");

      //extrac first id
    int firstId=response.path("id[0]");
    System.out.println("firstId = " + firstId);
//extrac first Index name
    String firstIndexName=response.path("name[0]");
    System.out.println("firstName = " + firstIndexName);
//extrac last index name
    String firstLastIndexName=response.path("name[-1]");
    System.out.println("firstName = " + firstLastIndexName);

    //extract all firstNames and print them
    List<String> names=response.path("name");
    System.out.println(names);
    System.out.println("names = "+names.size());

    List<Object>phone=response.path("phone");
    for (Object phoneNumbers: phone) {
        System.out.println("phone = " + phoneNumbers);
    }
}


}
