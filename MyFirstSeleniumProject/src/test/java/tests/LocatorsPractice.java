package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.awt.windows.ThemeReader;

import java.util.concurrent.TimeUnit;

public class LocatorsPractice {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://amazon.com");
        WebElement signIn = driver.findElement(By.id("twotabsearchtextbox"));
       String actualText= signIn.getAttribute("name");
       // System.out.println("Actual text: "+actualText);
        String expectedText="field-keywords";
        if (actualText.equalsIgnoreCase(expectedText)){
            System.out.println("PASS");
        }else {
            System.out.println("FAILED");
            System.out.println("Expected text: "+expectedText);
            System.out.println("Actual text: "+actualText);
        }

        Thread.sleep(2000);
        driver.close();
    }
}
