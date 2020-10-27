package UDEMY.Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _105_Homework {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        String url="https://rahulshettyacademy.com/AutomationPractice/";
        driver.get(url);

        WebElement table=driver.findElement(By.cssSelector("table[id='product']"));

        System.out.println(table.findElements(By.xpath("//table[@id='product']/tbody/tr")).size());
        System.out.println(table.findElements(By.xpath("//table[@id='product']/tbody/tr/th")).size());

        String row3=table.findElement(By.xpath("//table[@id='product']/tbody/tr[3]")).getText();
        System.out.println(row3);


    }
}
