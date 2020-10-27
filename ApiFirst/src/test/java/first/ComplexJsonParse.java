package first;

import files.payLoad;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

    public static void main(String[] args) {
        //TODO Auto-generated method stub

        JsonPath js = new JsonPath(payLoad.CoursePrice());
        //Print No of course returned by API

        int count = js.getInt("courses.size()");
        System.out.println("count = " + count);

        //Print Puchase amount
        int totalAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println("totalAmount = " + totalAmount);

        //Print Title of the first course
        String titleFirstCourse = js.get("courses[0].title");
        System.out.println("titleFirstCourse = " + titleFirstCourse);

        String titleThirdCourse = js.get("courses[2].title");
        System.out.println("titleThirdCourse = " + titleThirdCourse);
        System.out.println("================================");


        //Print All course titles and their respective Prices
        for (int i = 0; i < count; i++) {
            String courseTitles = js.get("courses[" + i + "].title");
            System.out.println(js.get("courses[" + i + "].price").toString());
            System.out.println("courseTitles = " + courseTitles);
        }


        System.out.println("Print no of copies sold by RPA Course");
        for (int i = 0; i < count; i++) {
            String courseTitles = js.get("courses[" + i + "].title");
            if (courseTitles.equalsIgnoreCase("RPA")) {
                int copies = js.get("courses[" + i + "].copies");
                System.out.println("copies = " + copies);
                break;
            }

        }













    }

}
