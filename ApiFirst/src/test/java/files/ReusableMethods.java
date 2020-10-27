package files;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReusableMethods {


    public static JsonPath rawToJson(Response response) {
        JsonPath js1 = response.jsonPath();
        return js1;


    }
}
