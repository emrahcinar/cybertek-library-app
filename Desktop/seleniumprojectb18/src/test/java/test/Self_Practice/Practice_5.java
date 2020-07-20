package test.Self_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice_5 {
    public static void main(String[] args) {

        //TC #5: Basic authentication Zero Bank
        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        // 2.Go to http://zero.webappsecurity.com/login.html
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/login.html");
        // 3.Enter username: username
        driver.findElement(By.id("user_login")).sendKeys("username");
        // 4.Enter password: password
        driver.findElement(By.name("user_password")).sendKeys("password");
        // 5.Click sign in button
        driver.findElement(By.name("submit")).click();
        // 6.Verify username is displayed on the page

        System.out.println(driver.findElement(By.linkText("username")).getText());

        // 7.Verify the title Zero –Account Summary
        String actualTitle=driver.getTitle();
        String expectedTitle="Account Summary";
        if (actualTitle.equals("Account Summary")){
            System.out.println("Account Summary location verify PASSED!!");
        }else{
            System.out.println("Account Summary location verify FAILED!!");
        }

        // 8.Verify the link Account Summary’s href value contains: “account-summary”
        // Print out results in validation formats


    }
}
