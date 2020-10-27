package UDEMY.Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _109_Homework {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://rahulshettyacademy.com/AutomationPractice/";
        driver.get(url);

        driver.findElement(By.cssSelector("input[id='autocomplete']")).sendKeys("UNITED");
        WebElement united = driver.findElement(By.cssSelector("input[id='autocomplete']"));
        united.sendKeys(Keys.DOWN);
        united.sendKeys(Keys.DOWN);
        united.sendKeys(Keys.DOWN);
        united.sendKeys(Keys.DOWN, Keys.ENTER);

        System.out.println(united.getAttribute("value"));

    }
}
