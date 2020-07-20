package test.day4_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

/*
TC #2: PracticeCybertek.com_AddRemoveElements WebElement verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/add_remove_elements
3. Click to “Add Element” button
4. Verify “Delete” button is displayed after clicking.
5. Click to “Delete” button.
6. Verify “Delete” button is NOT displayed after clicking.
USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
 */
public class TC_2_PracticeCybertek {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();

        WebElement elementButton = driver.findElement(By.xpath("//button[@class='added-manually']"));

        if (elementButton.isDisplayed()) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
        elementButton.click();


        WebElement deleteButton = driver.findElement(By.xpath("//div[(@id='elements')]"));


        if (deleteButton.isDisplayed()) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }

    }
}
