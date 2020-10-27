package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.List;

public class RadioButtonsPractice {

    public static void main(String[] args) throws Exception{
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().timeouts();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
      Thread.sleep(3000);
//        driver.findElement(By.xpath("//label[text()='Yellow']/preceding-sibling::input")).click();
//        Thread.sleep(3000);
//        System.out.println(driver.findElement(By.xpath("//label[contains(text(),'Green')]/preceding-sibling::input")));
//        driver.findElement(By.xpath("//label[contains(text(),'Green')]/preceding-sibling::input")).click();

        List<WebElement> radioButtons=driver.findElements(By.cssSelector("input[type='radio']"));
        for (WebElement radio : radioButtons){
            System.out.println(radio.getText()+"-"+radio.isEnabled());
        }
        System.out.println();
        for (WebElement radio : radioButtons){
            System.out.println(radio.getAttribute("name"));
        }
        System.out.println();
        for (WebElement radio : radioButtons){
            System.out.println(radio.getAttribute("id"));
        }
        Thread.sleep(3000);
        driver.close();



    }

}
