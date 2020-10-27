package UDEMY._11_;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class _84_actionsDemo {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome,driver","chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        String url="https://www.amazon.com/";
        driver.get(url);
        Actions a=new Actions(driver);
        WebElement move=driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));


        a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).
                click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();


        //Moves to specific element
        a.moveToElement(move).contextClick().build().perform();
            //draganddrop
      //  a.moveToElement(move).



    }
}
