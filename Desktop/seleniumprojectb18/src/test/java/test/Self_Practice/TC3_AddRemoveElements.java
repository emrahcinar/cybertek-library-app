package test.Self_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC3_AddRemoveElements {
    public static void main(String[] args) {
        //TC #3: PracticeCybertek.com_AddRemoveElements WebElement verification
        // 1. Open Chrome browser
        // 2. Go to http://practice.cybertekschool.com/add_remove_elements
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");
        // 3. Click to “Add Element” button 50 times
        WebElement clickAddElement = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        for (int i = 0; i < 50; i++) {
            clickAddElement.click();
        }
        // 4. Verify 50 “Delete” button is displayed after clicking.
        List<WebElement> ListOfDeleteButton = driver.findElements(By.xpath("//button[.='Delete']"));
        WebElement deleteButton = driver.findElement(By.xpath("//button[.='Delete']"));
        System.out.println("Number of button "+ListOfDeleteButton.size());

        // 5. Click to ALL “Delete” buttons to delete them.
        for (WebElement eachDelete : ListOfDeleteButton) {
            eachDelete.click();
        }

        // 6. Verify “Delete” button is NOT displayed after clicking.
        try {
            if (!deleteButton.isDisplayed()) {
                System.out.println("PASSED");
            } else {
                System.out.println("FAILED");
            }
        }catch (StaleElementReferenceException exception){
            System.out.println("StaleElementException has been thrown.");
            System.out.println("It means element completely dete from the page");
            System.out.println("Delete button is not displayed. Verification PASSED");
        }

        // USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS Hint: Need to use findElements method


    }
}
