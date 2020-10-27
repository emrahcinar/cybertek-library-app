package cybertek_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import tests.BrowserFactory;

public class CssPractice {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/registration_form");

        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("Emrah");
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("CINAR");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("emrahc");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("anyemail@gmail.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("12345678");
        driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("477-499-5399");
        driver.findElement(By.cssSelector("input[value='male']")).click();
        driver.findElement(By.cssSelector("input[name='birthday']")).sendKeys("10/04/2000");
        Select select=new Select(driver.findElement(By.cssSelector("select[name='job_title']")));
        select.selectByVisibleText("Scrum Master");
        driver.findElement(By.cssSelector("input[value='java']")).click();
        driver.findElement(By.cssSelector("button[id='wooden_spoon']")).click();



    }
}
