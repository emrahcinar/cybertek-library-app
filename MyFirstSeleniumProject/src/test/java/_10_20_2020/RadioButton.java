package _10_20_2020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class RadioButton {
    public static void main(String[] args) throws Exception {

        System.setProperty("Webdrive.chrome.driver","chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        String url="http://practice.cybertekschool.com/radio_buttons";
        driver.get(url);
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//label[text()='Yellow']/preceding-sibling::input")).click();
//        Thread.sleep(3000);
//        System.out.println(driver.findElement(By.xpath("//label[contains(text(),'Green')]/preceding-sibling::input")).isEnabled());
//        driver.findElement(By.xpath("//label[contains(text(),'Green')]/preceding-sibling::input")).click();


        List<WebElement> radioButtons=driver.findElements(By.cssSelector("input[type='radio']"));

        for (WebElement radio:radioButtons){

            System.out.println(radio.getAttribute("id"));
        }
        Thread.sleep(3000);

        driver.close();
    }
}
