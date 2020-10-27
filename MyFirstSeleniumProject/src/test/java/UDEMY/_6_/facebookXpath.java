package UDEMY.Six;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class facebookXpath {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "http://facebook.com";
        driver.get(url);//hit url on the browser

//        driver.findElement(By.xpath("//*[@name='email']")).sendKeys("xpath");
//        driver.findElement(By.xpath("//*[@name='pass']")).sendKeys("pass");
//        driver.findElement(By.xpath("//*[@name='login']")).click();


        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("myowncss");
        driver.findElement(By.cssSelector("input[name='pass']")).sendKeys("pass");
        driver.findElement(By.cssSelector("[name='login']")).click();


    }
}
