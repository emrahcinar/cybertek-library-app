package test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook {

    public static void main(String[] args) throws InterruptedException{

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com");
        driver.findElement(By.id("email")).sendKeys("emrah-c@hotmail.com");
        Thread.sleep(2000);
        driver.findElement(By.name("pass")).sendKeys("12345");
        Thread.sleep(2000);
        driver.findElement(By.id("u_0_b")).click();

    }
}
