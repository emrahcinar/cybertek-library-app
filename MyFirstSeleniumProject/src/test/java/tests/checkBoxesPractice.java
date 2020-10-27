package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class checkBoxesPractice {

    public static void main(String[] args) throws Exception{
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().timeouts();
        driver.get("http://practice.cybertekschool.com/checkboxes");
//        Thread.sleep(3000);
//        driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(1)")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(2)")).click();
//        Thread.sleep(3000);

        //find all elements with tag name input
        List<WebElement> checkboxes=driver.findElements(By.tagName("input"));
        //loop through this list of elements
        for (WebElement checkbox: checkboxes){
            Thread.sleep(3000);
            //if checkbox is not selected yet
            if (!checkbox.isSelected()) {
                //select it
                checkbox.click();
            }
        }
        driver.quit();
    }

}
