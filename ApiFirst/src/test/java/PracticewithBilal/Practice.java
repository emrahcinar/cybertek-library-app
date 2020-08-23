package PracticewithBilal;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Practice {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://34.224.4.31:8000";

    }

    @Test
    public void test1() {
     Response response= RestAssured.get("/api/spartans");
        System.out.println("response.statusCode() = " + response.statusCode());
    }

}


