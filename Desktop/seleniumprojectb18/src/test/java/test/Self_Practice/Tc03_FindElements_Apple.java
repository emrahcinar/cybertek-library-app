package test.Self_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class Tc03_FindElements_Apple {
    public static void main(String[] args) {
//   TC #03: FINDELEMENTS_APPLE
//    1.Open Chrome browser
//    2.Go to https://www.apple.com
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.apple.com");
//    3.Click to all of the headers one by one
//    a.Mac, iPad, iPhone, Watch, TV, Music, Support
        WebElement links=driver.findElement(By.xpath("//ul[@class='ac-gn-header']"));
//    4.Printout how many links on each pagewiththe titles of the pages
//    5.Loop through all
//    6.Print out how many link is missing textTOTAL
//    7.Print out how many link has textTOTAL
//    8.Print out how many total linkTOTA



    }
}
