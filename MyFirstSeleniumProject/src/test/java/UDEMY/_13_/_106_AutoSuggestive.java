package UDEMY._13_;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _106_AutoSuggestive {
    public static void main(String[] args) throws Exception{

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.priceline.com/?tab=flights";
        driver.get(url);

        driver.findElement(By.id("flight-departure-airport0")).sendKeys("IST" + Keys.ENTER);
        driver.findElement(By.id("flight-arrival-airport0")).sendKeys("ATL" + Keys.ENTER);
        driver.findElement(By.id("flight-date-range")).click();






    }
}
