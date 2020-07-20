package test.Self_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice_2 {
    public static void main(String[] args) {
        //TC #2: Zero Bankheader verification
        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        //2.Go to http://zero.webappsecurity.com/login.html
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");



// 3.Verify header textExpected: “Log in to ZeroBank”

        driver.get("http://zero.webappsecurity.com/login.html");
        driver.findElement(By.tagName("h3"));

        String actualTitle = driver.findElement(By.tagName("h3")).getText();
        String expectedInTItle = "Log in to ZeroBank";

        if (actualTitle.equals(expectedInTItle)) {
            System.out.println("PASSED!");
        } else {
            System.out.println("FAILED!!!");
        }



    }

}
