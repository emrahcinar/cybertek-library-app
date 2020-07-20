package test.Self_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class Easy_Checkbox1 {
    public static void main(String[] args) {
        //TC	#2:	SeleniumEasy	CheckboxVerification–Section	1
        // 1.Open	Chrome	browser
        // 2.Go	to	https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        // 3.Verify	“Success	–Check	box	is	checked”	message	is	NOTdisplayed.
        WebElement succesCheck = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
        WebElement succesMessage = driver.findElement(By.xpath("//div[@id='txtAge']"));
        if (!succesCheck.isSelected() && !succesMessage.isDisplayed()) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
        // 4.Click	to	checkbox	under	“Single	Checkbox	Demo”	section
        try {
            Thread.sleep(1000);
        } catch (Exception exception){}
            succesCheck.click();
            // 5.Verify	“Success	–Check	box	is	checked”	message	isdisplayed
            if (succesCheck.isDisplayed()) {
                System.out.println("PASSED");
            } else {
                System.out.println("FAILED");

            }


        }
    }
