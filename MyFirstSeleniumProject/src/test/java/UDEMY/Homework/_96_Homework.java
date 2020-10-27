package UDEMY.Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class _96_Homework {
    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://rahulshettyacademy.com/AutomationPractice/";
        driver.get(url);

       driver.findElement(By.cssSelector("input[id='checkBoxOption2']")).click();

        String text = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]")).getText();

        WebElement dropdown = driver.findElement(By.cssSelector("select[id='dropdown-class-example']"));

        Select s = new Select(dropdown);
        s.selectByVisibleText(text);

        driver.findElement(By.name("enter-name")).sendKeys(text);
        driver.findElement(By.id("alertbtn")).click();
        String alert = driver.switchTo().alert().getText();

        if (alert.contains(text)){
            System.out.println("Succes");
        }else {
            System.out.println("Failed");
        }


    }
}
