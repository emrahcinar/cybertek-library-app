package UDEMY.Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _90_Homework {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://the-internet.herokuapp.com";
        driver.get(url);

        driver.findElement(By.xpath("//a[contains(text(),'Nested Frames')]")).click();

        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-middle");

        System.out.println(driver.findElement(By.id("content")).getText());
    }
}
