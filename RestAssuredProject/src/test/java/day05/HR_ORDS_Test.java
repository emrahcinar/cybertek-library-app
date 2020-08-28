package day05;


import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.Region;
import pojo.Spartan;

import java.util.*;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class HR_ORDS_Test {
    @BeforeAll
    public static void init() {
        RestAssured.baseURI = "http://54.174.216.245";
        RestAssured.port = 1000;
        RestAssured.basePath = "ords/hr";
    }

    @DisplayName("Testing the / regions/{id} endpoint")
    @Test
    public void testRegion() {

        Response response = given()
                .accept(ContentType.JSON)
                .pathParam("region_id", 1)
                .when()
                .get("/regions/{region_id}")
                .prettyPeek();

        Region r1 = response.as(Region.class);
        System.out.println("r1 = " + r1);
    }

    @DisplayName("Testing the/regions endpoint")
    @Test
    public void testRegionJsonArrayToPojoList() {

        //send a request to/regions endpoint to get all regions
        //save the json array into pojo List
        //you already have taken care of unknown properties so no extra action needed
        //just call the method of jsonPath object to get the list you want
//Response response=given()
//        .accept(ContentType.JSON)
//        .log().all()
//        .when()
//        .get("/regions")
//

        Response response = get("/regions").prettyPeek();


        JsonPath jp = response.jsonPath();
        //Get first region_name from the response usin jsonPath
        System.out.println("first region_name = " + jp.getString("items[0].region_name"));
        //Get first region_name from the response usin jsonPath
        System.out.println("Get last region_id = " + jp.getInt("items[3].region_id"));
        //or use -1 index to get last one
        System.out.println("Get last region_id = " + jp.getInt("items[-1].region_id"));

        // get the list of region name from the response and save it to List<String>
        List<Region> allnames = jp.getList("items.region_name");
        System.out.println("allnames = " + allnames);

        // get a List<Region> from the response json

        List<Region> regionList = jp.getList("items", Region.class);
        System.out.println("regionList = " + regionList);


    }

}

