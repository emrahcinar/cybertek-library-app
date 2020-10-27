package cybertek_test;

import jdk.nashorn.internal.ir.IfNode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.BrowserFactory;

import java.util.List;

public class CheckBoxesTest {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().timeouts();
        driver.get("http://practice.cybertekschool.com/checkboxes");
        List<WebElement> checkboxes= driver.findElements(By.tagName("input"));

        for (WebElement boxes:checkboxes){
            if (!boxes.isSelected()){
                boxes.click();
            }
        }


    }
}
