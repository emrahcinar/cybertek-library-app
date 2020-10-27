package first;


import files.payLoad;
import io.restassured.path.json.JsonPath;

import org.junit.jupiter.api.Test;
import org.testng.Assert;


public class SumValidation {
    ////Verify if Sum of all Course prices matchs with Purchace amount
    //        int price=0;
    //        for (int i = 0; i < count; i++) {
    //         price +=   js.getInt("courses["+i+"].price")*js.getInt("courses["+i+"].copies");
    //        }
    //        System.out.println(price);


    @Test
    public void sumOfCourses() {

        JsonPath js = new JsonPath(payLoad.CoursePrice());
        int count = js.getInt("courses.size()");

        int sum = 0;
        for (int i = 0; i < count; i++) {

            int price = js.getInt("courses[" + i + "].price");
            int copies = js.getInt("courses[" + i + "].copies");
            int amount = price * copies;
            System.out.println("amount = " + amount);
            sum += amount;

        }
        System.out.println("sum = " + sum);
        int purchaseAmount = js.getInt("dashboard.purchaseAmount");
        Assert.assertEquals(sum, purchaseAmount);
    }

}
