package UDEMY._12_;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Calendar {
    public static void main(String[] args) throws Exception{

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
     WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.path2usa.com/travel-companions";
        driver.get(url);

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[id='travel_date']")).click();


        while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText()
                .contains("April")){

            driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
        }

       

        List<WebElement> dates = driver.findElements(By.className("day"));

        int count = driver.findElements(By.className("day")).size();
        for (int i = 0; i < count; i++) {

            String text = driver.findElements(By.className("day")).get(i).getText();
            if (text.equalsIgnoreCase("23")) {
                driver.findElements(By.className("day")).get(i).click();
                break;

            }

        }
    }
}
