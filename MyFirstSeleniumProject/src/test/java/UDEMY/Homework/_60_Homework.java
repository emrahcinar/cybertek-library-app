package UDEMY.Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class _60_Homework {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.setup", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://rahulshettyacademy.com/AutomationPractice/";
        driver.get(url);


        driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());

        List<WebElement> boxes= driver.findElements(By.cssSelector("div[id='checkbox-example']"));

        for (WebElement result : boxes){
            List<WebElement> box=result.findElements(By.cssSelector("input[type='checkbox']"));
            int num=box.size();
            System.out.println(num);

            driver.switchTo().alert().accept();
        }

    }
}
