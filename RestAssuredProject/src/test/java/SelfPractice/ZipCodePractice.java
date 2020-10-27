package SelfPractice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class ZipCodePractice {

    @BeforeAll
    public static void setup1() {
        RestAssured.baseURI = "http://api.zippopotam.us";
        RestAssured.basePath = "/us";
    }

    @DisplayName("Zip to City")
    @Test
    public void testZiptoCity() {

        given()

                .pathParam("zip", 30071)
                .log().all()
                .when()
                .get("/{zip}")
                .then()
                .log().all()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("'post code'", is("30071"))
                .body("country", is("United States"))
                .body("places.'place name'[0]", is("Norcross"))
                .body("places.'latitude'[0]", is("33.9381"))
                .body("places.'longitude'[0]", is("-84.1972"))
        ;


    }


    @Test
    public void cityToZip() {

        given()
                .log().all()

                .pathParam("state", "GA")
                .pathParam("city", "Norcross")
                .when()
                .get("/{state}/{city}")
                .then()
                .log().all()
                .statusCode(200)
                .body("places[0].latitude", is("33.9604"))
        ;


    }


}
