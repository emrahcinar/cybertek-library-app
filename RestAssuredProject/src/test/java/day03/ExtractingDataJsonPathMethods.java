package day03;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ExtractingDataJsonPathMethods {


    @DisplayName("Getting Movie Info")
    @Test
    public void test1() {

        Response response =
                given()
                        .log().all()
                        // .baseUri("http://www.omdbapi.com")
                        .queryParam("apikey", "26aa5b74")
                        .queryParam("t", "Boss Baby")
                        .when()
                        .get("http://www.omdbapi.com");

        //the  JsonPath is a class that have a lot of methods
        // to get the body data in different format or data types
        //we get this object by calling the method of Response object called.jsonPath()
        JsonPath jp = response.jsonPath();
        //get the title as String
        String title = jp.getString("Title");
        // get the year as int 
        int year = jp.getInt("Year");
        System.out.println("Title = " + title);
        System.out.println("Year = " + year);

        String director = jp.getString("Director");
        System.out.println("Director = " + director);

        //get the first rating source as we did in previous class
        String rating1Src = jp.getString("Ratings[0].Source");
        System.out.println("rating1Src = " + rating1Src);

        //store the entire response as Map<String, Object>
        //since our result is a Json object with key value pair
        //we can directly call getMap method and provide the path
        //store the whole thing into a MAp object
        Map<String, Object> responseMap = jp.getMap("");
        System.out.println("responseMap = " + responseMap);

        //print out the Awards key from above Map
        System.out.println("Awards are " + responseMap.get("Awards"));

        //one more example of Map
        //Store first Rating Json Object into a map
        /*
           {
            "Source": "Internet Movie Database",
            "Value": "6.3/10"
        },
         */

        Map<String, Object> firstRatingMap = jp.getMap("Ratings[0]");
        System.out.println("firstRatingMap = " + firstRatingMap);
        // above code is doing below when getMap method is being called
//        Map<String,Object> manualMap = new HashMap<>();
//        manualMap.put("Source","Internet Movie Database");
//        manualMap.put("Value","6.3/10");

        // I want to store all the source of ratings into the list of String
        // your result should be ["Internet Movie Database","Rotten Tomatoes","Metacritic"]
        // JsonPath getList method will store items in jsonArray into the list

        // get me the list of Source field of the Ratings jsonArray from the response
         List<String>sourceList= jp.getList("Rating.Source") ;
        System.out.println("sourceList = "+sourceList);
        
//        System.out.println("=====================================");
//        for (int i = 0; i < response.jsonPath().get().toString().length(); i++) {
//            System.out.println(responseMap = jp.getMap("") );
//            break;
//        }

    }
}
