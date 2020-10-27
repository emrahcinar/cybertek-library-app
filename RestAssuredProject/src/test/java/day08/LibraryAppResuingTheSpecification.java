package day08;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utility.ConfigurationReader;
import utility.LibraryUtil;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;

public class LibraryAppResuingTheSpecification {
    static RequestSpecification requestSpec;
    static ResponseSpecification responseSpec;

    @Test
    public void init() {

        RestAssured.baseURI = ConfigurationReader.getProperty("library1.base_url");
        RestAssured.basePath = "/rest/v1";

        String theToken = LibraryUtil.loginAndGetToken("librarian69@library", "KNPXrm3S");

        requestSpec = given().accept(ContentType.JSON)
                .log().all()
                .header("x-library-token", theToken);

        responseSpec = expect().statusCode(200)
                .contentType(ContentType.JSON)
                .logDetail(LogDetail.ALL);


    }

    @DisplayName("Testing GET / get_book_categories Endpoint with spec")
    @Test
    public void testLibrary() {

        given()
                .spec(requestSpec)
                .when()
                .get("get_book_categories")
                .then()
                .spec(responseSpec);


    }

}
