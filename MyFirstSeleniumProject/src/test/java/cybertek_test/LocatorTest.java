package cybertek_test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LocatorTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String url="https://www.etsy.com";
        driver.get(url);

        WebElement element=driver.findElement(By.id("global-enhancements-search-query"));
        String expected=element.getText();
        String actual= element.getAttribute("input");
        System.out.println(expected);
//       if (actual.equals(expected)){
//           System.out.println("PASSED");
//       }else{
//           System.out.println("FAILED");
//           System.out.println("actual = " + actual);
//           System.out.println("expected = " + expected);
//       }
        element.click();




    }
}
