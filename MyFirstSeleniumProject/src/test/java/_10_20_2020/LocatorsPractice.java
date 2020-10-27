package _10_20_2020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LocatorsPractice {

    public static void main(String[] args) throws Exception {

        System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String url = "http://google.com";
        driver.get(url);
        WebElement btn1 = driver.findElement(By.id("gbqfbb"));
        btn1.click();
        String expectedText = "I'm Feeling Lucky";
        String actualText = btn1.getAttribute("value");
        if (actualText.equalsIgnoreCase(expectedText)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
            System.out.println("expectedText : "+expectedText);
            System.out.println("actualText : "+actualText);
        }

        Thread.sleep(2000);
        driver.close();


    }
}
