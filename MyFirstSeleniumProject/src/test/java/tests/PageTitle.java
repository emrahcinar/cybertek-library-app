package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageTitle {
    public static void main(String[] args) {
        //to setup chrome driver
        WebDriverManager.chromedriver().setup();
        //to create object of chromeDriver class
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();//to make it FULL SCREEN
        //finding to TITLE
        driver.get("http://google.com");
        String title = driver.getTitle();
        System.out.println(title);






    }


}
