package test.day5_testing_intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumEasy2 {
    public static void main(String[] args) throws InterruptedException {
        // TC	#3:	SeleniumEasy	Checkbox	Verification	–Section	2
        // 1.Open	Chrome	browser
        // 2.Go	to	https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        // 3.Verify	“Check	All”	button	text	is	“Check	All”
        WebElement checkAllbutton = driver.findElement(By.xpath("//input[@value='Check All']"));
//input[@value='Uncheck All']
        if (checkAllbutton.isDisplayed()) {
            System.out.println("Check All button PASSED");
        } else {
            System.out.println("Check All button FAILED");
        }
        // 4.Click	to	“Check	All”	button
        checkAllbutton.click();

        // 5.Verify	all	check	boxes	are	checked
        List<WebElement> AllButtons = driver.findElements(By.xpath("//input[@class='cb1-element']"));

        for (WebElement eachButton : AllButtons) {
            if (eachButton.isDisplayed()) {
                System.out.println("PASSED");
            } else {
                System.out.println("FAILED");
            }
        }
        // 6.Verify	button	text	changed	to	“Uncheck	A
        Thread.sleep(2000);
        WebElement uncheckbutton = driver.findElement(By.xpath("//input[@value='Uncheck All']"));
        uncheckbutton.click();

        if (uncheckbutton.isDisplayed()) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }

    }
}
