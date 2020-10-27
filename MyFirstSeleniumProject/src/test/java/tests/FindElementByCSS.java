package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LocatorsPracticeCSS {

    public static void main(String[] args) throws Exception {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().timeouts();
        driver.get("http://practice.cybertekschool.com/registration_form");
        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("Bilal");
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("USLU");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("email@cybertekschool.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("qwerty123456");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("supersdet");
        driver.findElement(By.cssSelector("input[name='birthday']")).sendKeys("10/10/1990");
        driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("777-777-7777");
        Select select=new Select(driver.findElement(By.cssSelector("select[name='job_title']")));
        driver.findElement(By.cssSelector("input[value='male']")).click();
        select.selectByVisibleText("SDET");
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(3000);
        driver.close();


    }

}
