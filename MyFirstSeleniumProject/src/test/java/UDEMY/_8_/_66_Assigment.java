package UDEMY.Eight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _66_Assigment {
    public static void main(String[] args) throws Exception{

        String text = "Emrah";
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://rahulshettyacademy.com/AutomationPractice/";
        driver.get(url);
        Thread.sleep(2000);
        driver.findElement(By.id("name")).sendKeys(text);
        Thread.sleep(2000);
        driver.findElement(By.id("alertbtn")).click();
        Thread.sleep(2000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
          driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(2000);
        System.out.println(driver.switchTo().alert().getText());
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();



    }
}
