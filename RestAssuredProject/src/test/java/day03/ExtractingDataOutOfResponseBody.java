package day03;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ExtractingDataOutOfResponseBody {

    @DisplayName("Getting Movie Info")
    @Test
    public void test1() {

        //provide your baseURI in the test
        //add query prameters
        //apikey yourAPIkey here
        //t =Boss Baby
        //Save the response into response object

        Response response = given()
                .log().all()
                .baseUri("http://www.omdbapi.com")
                .queryParam("apikey", "26aa5b74")
                .queryParam("t", "Boss Baby")
                .when()
                .get();

        //    response.prettyPrint();
        System.out.println(response.statusCode());

        // if you want to get single data out for example just title , just year
        // use path method of Response object and provide the jsonPath
        String title = response.path("Title");
        System.out.println("title = " + title);
        //using name example - print out -- Year , Director, Actors
        //Optionally -- First Rating Source

        String year = response.path("Year");
        System.out.println("Year = " + year);

        String director = response.path("Director");
        System.out.println("Director= " + director);

        String actors = response.path("Actors");
        System.out.println("Actors = " + actors);

        // getting the first Rating source
        // the jsonPath for first Rating source is Ratings[0].Source
        String rating = response.path("Ratings[0].Source");
        System.out.println("First Rating Source = " + rating);

        String ratingValue = response.path("Ratings[0].Value");
        System.out.println("First Rating Value = " + ratingValue);



    }
}


