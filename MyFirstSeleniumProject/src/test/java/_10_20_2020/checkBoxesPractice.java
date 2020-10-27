package _10_20_2020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class checkBoxesPractice {
    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "http://practice.cybertekschool.com/checkboxes";
        driver.get(url);
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//input[@type='checkbox'][1]")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//input[@type='checkbox'][2]")).click();
//        Thread.sleep(2000);


        List<WebElement>checkboxes=driver.findElements(By.tagName("input"));

                for(WebElement checkbox: checkboxes){
                    Thread.sleep(2000);
                    if (!checkbox.isSelected()){
                        checkbox.click();
                    }
                }


        driver.quit();
    }
}
