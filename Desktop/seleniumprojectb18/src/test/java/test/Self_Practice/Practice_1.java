package test.Self_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice_1 {
    public static void main(String[] args) {

        //Open Chrome Browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.com");

        //go to https://www.youtube.com/
        driver.get("https://www.youtube.com/");

        //search for "Besiktas 112. yil marsi"
        driver.findElement(By.name("search_query")).sendKeys("Besiktas 112. yil marsi");

       // locating and clicking to the search button using class
        driver.findElement(By.id("search-icon-legacy")).click();

        driver.findElement(By.linkText("GURURLAN-112. YIL MARŞI- birolcan")).click();


    }

}
