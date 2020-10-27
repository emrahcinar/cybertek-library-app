package UDEMY._13_;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.util.concurrent.ExecutionException;

public class _107_Importance_of_Javascript_Executor {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://ksrtc.in/oprs-web/";
        driver.get(url);

        driver.findElement(By.id("fromPlaceName")).sendKeys("BENG");
        driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
        Thread.sleep(2000);
        // driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
        System.out.println(driver.findElement(By.id("fromPlaceName")).getText());


        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "return document.getElementById(\"fromPlaceName\").value;";
        String text = (String) js.executeScript(script);
        System.out.println(text);
        int i=0;

        while (!text.equalsIgnoreCase("BENGALURU INTERNATION AIRPORT")) {
                i++;
            driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
            text = (String) js.executeScript(script);
            System.out.println(text);
            if (i>10){
                break;
            }
        }
        if (i>10){
            System.out.println("Element not found");
        }else
            System.out.println("Element found");

    }
}
