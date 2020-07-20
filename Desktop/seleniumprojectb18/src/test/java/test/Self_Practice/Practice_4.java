package test.Self_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice_4 {
    public static void main(String[] args) {


        //TC #4: Zero Bank URLverification
        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();

        // 2.Go to http://zero.webappsecurity.com/login.html
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/login.html");
        // 3.Get attribute value of href from the “forgot your password”link
        driver.findElement(By.linkText("Forgot your password ?")).getAttribute("href");
        // 4.Verify attribute value contains
        System.out.println( driver.findElement(By.linkText("Forgot your password ?")).getAttribute("href"));
        // Expected: “/forgot-password.html”
    }
}
