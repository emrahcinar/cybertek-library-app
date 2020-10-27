package cybertek_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.DriverManager;

public class XpathTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        String url="https://www.etsy.com";
        driver.get(url);

//        WebElement searchBar= driver.findElement(By.xpath("//input[@id='global-enhancements-search-query']"));
//        searchBar.sendKeys("wooden fork"+ Keys.ENTER);


        WebElement searchbox2= driver.findElement(By.xpath("//input[@id='global-enhancements-search-query']"));
        searchbox2.sendKeys("apple");

        driver.findElement(By.xpath("//button[@value='Search']")).click();






    }
}
