package test.day5_testing_intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Selenium_Apple {
    public static void main(String[] args) {
        //TC #02: FINDELEMENTS_APPLE
        // 1.Open Chrome browser
        // 2.Go to https://www.apple.com
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.apple.com");
        // 3.Click to iPhone
        WebElement appleButton = driver.findElement(By.xpath("//a[@href='/iphone/']"));
        appleButton.click();
        // 4.Print out the texts of all links
        List<WebElement> listOfAllText = driver.findElements(By.xpath("//body//a"));
        //  System.out.println(listOfAllText.get(1).getText());
        int linkwithoutText = 0;
        int linkWithText = 0;
        for (WebElement eachLink : listOfAllText) {
         //  System.out.println(eachLink.getText());
            String textOfEachLink = eachLink.getText();
            if (textOfEachLink.isEmpty()) {
                linkwithoutText++;
            } else {
                System.out.println(textOfEachLink);
                linkWithText++;
            }
        }
        // 5.Print out how many link is missing text
        System.out.println("The links that dont have text : " + linkwithoutText);
        // 6.Print out how many link has text
        System.out.println("The links that  have text : " + linkWithText);
        // 7.Print out how many total linkTC
        System.out.println("Total link is : " + (linkwithoutText + linkWithText));
    }
}
