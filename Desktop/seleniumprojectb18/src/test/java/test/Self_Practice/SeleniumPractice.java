package test.Self_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumPractice {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        driver.manage().deleteAllCookies();
      //  driver.findElement(By.cssSelector("button#u_0_13")).click();
        // driver.findElement(By.linkText("Multiple Buttons")).click();
       WebElement wbd = driver.findElement(By.xpath("//a[@class='_8esh']/.."));
        System.out.println(wbd.getAttribute("class"));
    }
}
