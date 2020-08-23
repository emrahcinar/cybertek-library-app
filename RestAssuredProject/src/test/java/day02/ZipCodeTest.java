package day02;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


@DisplayName("Testing Zip Code API")
public class ZipCodeTest {
// Please open up new class called ZipCode Test
//	    Add baseURI as "http://api.zippopotam.us"
//	    	basePath as /us/
//	    under @BeforeAll
//	    add
//	    	path variable {zipcode} in given section
//	    send Get request
//	    then  check the status code 200
//	    check the contentype header is json
//	         body : post code -- the zipcode you entered
//	         		country  United States
//	         	    longitude  -- the expected value
//	         	    state    --  the expected value

    @BeforeAll
    public static void init() {

        RestAssured.baseURI = "http://api.zippopotam.us";
        RestAssured.basePath = "/us";
    }

    @DisplayName("Zip to City Test")
    @Test
    public void TestZiptoCity() {


        given()
                .pathParam("zip", 30084)
                .log().all()
                .when()
                .get("/{zip}")
                .then()
                .log().all()
                .statusCode(is(200))
                .contentType(ContentType.JSON)
                .body("country", is("United States"))
                .body("places.'state'[0]", is("Georgia"))
                .body("\"post code\"", is("30084"))
                //get the place name
                .body("places[0].'place name' ", is("Tucker"))
        ;
        //if a field/key you are trying to get has space
        //then add'' for example " ' post code ' "

    }

    @DisplayName("City to Zip")
    @Test
    public void testCityToZip() {

        given()
                .pathParam("state", "GA")
                .pathParam("city", "Atlanta")
                .log().all()
                .when()
                .get("/{state}/{city}")
                //.get("/{state}/{city}","GA","Tucker")//secondway
                .then()
                .log().all()
                .statusCode(is(200))
                .body("'country abbreviation'", is("US"))
                //test the latittude of first place is "33.857"
                .body("places[0].latitude", is("33.8444"))
                //jsonPath hack for getting last item from jsonArray
                //-1 index indicate the last item ,only works here not in postman
               .body("places[-1].latitude", is("33.8913"))
        ;


    }

}
