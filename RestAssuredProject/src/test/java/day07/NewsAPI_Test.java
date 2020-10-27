package day07;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class NewsAPI_Test {


    @DisplayName("News API get all news Author if the source id not null")
    @Test
    public void testNews() {

        String apiToken="87eb9bf287554b19af52dd56cfdc64a8";

     Response response= given()
                .baseUri("http://newsapi.org")
                .basePath("/v2")
                .header("Authorization","Bearer "+apiToken)
                .queryParam("country","us")
                .log().all()
                .when()
                .get("/top-headlines");

        JsonPath jp =response.jsonPath();
        List<String> allAuthor=jp.getList("articles.author");
        System.out.println("allAuthor.size() = " + allAuthor.size());
        allAuthor.forEach(eachAuthor-> System.out.println("eachAuthor = "+eachAuthor));

        List<String>  allAuthorFiltered=jp.getList("articles.findAll{it.source.id!=null }.author");

       // allAuthorFiltered.forEach(notNull-> System.out.println("  "+notNull));
        for (String author : allAuthorFiltered){
            System.out.println("author = " + author);
        }
        System.out.println("allAuthorFiltered.size() = " + allAuthorFiltered.size());
    }
}
