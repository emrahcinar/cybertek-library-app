package day06;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class LibraryAppTest {
    private static String libraryToken;

    @BeforeAll
    public static void init() {
        RestAssured.baseURI = "http://library1.cybertekschool.com";
        RestAssured.basePath = "/rest/v1";
        libraryToken = loginAndGetToken("librarian69@library", "KNPXrm3S");
    }

    @DisplayName("Send request to//dashboardStat")
    @Test
    public void testDashboardStatsWithToken() {

        given()
                .log().all()
                .header("x-library-token", libraryToken)
                .when()
                .get("/dashboard_stats")
                .then()
                .log().all()
                .statusCode(200)
                .body("book_count", is("985"))
                .body("borrowed_books", is("600"))
                .body("users", is("5042"));

    }


//add a test for the POST /decode endpoint
// this endpoint does not need authorization
// it accept form param as name token value your long token
// and return json response as user information and authority
// assert the email of user is same as the email you used the token

    @DisplayName("Testing POST /decode endpoint")
    @Test
    public void testDecodeJWT_Token() {

        given()
                .log().all()
                .accept(ContentType.JSON)//THIS IS TELLING, I WANT JSON BACK AS RESPONSE
                .contentType(ContentType.URLENC)//This specify  what kind of data you sending to the server in the body
                .formParam("token", libraryToken)
                .when()
                .post("/decode")
                .then()
                .statusCode(200)
                //assert the email is "librarian69@library" because we used this email to get the token
                .body("email", is("librarian69@library"))
                //the token name is same as the token we used to token
                .body("token", is(libraryToken))
        ;
    }

    @DisplayName("Test //get_user_by_id/{id} Endpoint")
    @Test
    public void testSingleUserDate() {

        given()
                .log().all()
                .header("x-library-token", libraryToken)
                .pathParam("id", 2080)
                .when()
                .get("/get_user_by_id/{id}")
                .then()
                .log().all()
                .statusCode(200)
                .body("id", is("2080"))
                .body("full_name", is("Test Student 142"))
                .body("email", is("student142@library"))
                .body("password", is("830f1d9884d7005b9b910148aa73da96"))
                .body("user_group_id", is("3"))
                .body("image", is(nullValue()))
                .body("extra_data", is(nullValue()))//how to use matcher fo null value (Matchres. )
                .body("is_admin", is("0"))
                .body("start_date", is("2020-06-22"))
                .body("end_date", is("2021-06-22"))
                .body("address", is("Test address 142"))
                .body("body", nullValue())
        ;


    }


    /**
     * A static utility method to get the token by providing username and password
     * as Post request to /Login endpoint and capture the token field from response json
     *
     * @param username
     * @param password
     * @return the token as String from the response json
     */
    public static String loginAndGetToken(String username, String password) {
        String token = "";
        Response response = given()
//                                .log().all()
                // explicitly saying the body content type is x-www-urlencoded-form-data
                .contentType(ContentType.URLENC)
                .formParam("email", username)
                .formParam("password", password).
                        when()
                .post("/login");
        //token = response.path("token") ;  // this is using path method
        token = response.jsonPath().getString("token");
        return token;
    }

//ecb0404402db41c1b4e2321050e9bd67
}
