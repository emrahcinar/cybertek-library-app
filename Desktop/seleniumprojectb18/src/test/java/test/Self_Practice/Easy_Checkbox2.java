package test.Self_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Easy_Checkbox2 {
    public static void main(String[] args) {
//TC	#3:	SeleniumEasy	Checkbox	Verification	–Section	2
// 1.Open	Chrome	browser
// 2.Go	to	https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
// 3.Verify	“Check	All”	button	text	is	“Check	All”
        WebElement checkAllButton = driver.findElement(By.xpath("//input[@id='check1']"));
        String actualText = checkAllButton.getAttribute("value");
        String expectedText = "Check All";
        if (actualText.equals("Check All")) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
// 4.Click	to	“Check	All”	button
        checkAllButton.click();
// 5.Verify	all	check	boxes	are	checked
        List<WebElement> allButtons = driver.findElements(By.xpath("//input[@class='cb1-element']"));
        for (WebElement eachButton : allButtons) {
            if (eachButton.isSelected()) {
                System.out.println("PASSED");
            } else {
                System.out.println("FAILED");
            }
        }
// 6.Verify	button	text	changed	to	“Unc
        String actualButtonTextAfterClick = checkAllButton.getAttribute("value");
        String expectedValueAfterClickText = "Uncheck All";
        if (actualButtonTextAfterClick.equalsIgnoreCase(expectedValueAfterClickText)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }

    }
}
