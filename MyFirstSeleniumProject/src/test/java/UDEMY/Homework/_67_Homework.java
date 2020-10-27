package UDEMY.Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Homework {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.cleartrip.com/";
        driver.get(url);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver.findElement(By.id("OneWay")).click();

        driver.findElement(By.cssSelector("input[id='DepartDate']")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active ")).click();

        Select adult = new Select(driver.findElement(By.id("Adults")));
        adult.selectByValue("3");
        Select children = new Select(driver.findElement(By.id("Childrens")));
        children.selectByValue("1");


        driver.findElement(By.cssSelector("a[id='MoreOptionsLink']")).click();
        Select seat = new Select(driver.findElement(By.id("Class")));
        seat.selectByVisibleText("First");

        driver.findElement(By.cssSelector("input[id='AirlineAutocomplete']")).sendKeys("Indigo");


        driver.findElement(By.id("SearchBtn")).click();

        System.out.println(driver.findElement(By.cssSelector("div[id='homeErrorMessage']")).getText());


    }
}
