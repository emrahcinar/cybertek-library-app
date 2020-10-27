package UDEMY._6_;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class chromeBrowser {
    // static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "http://facebook.com";
        driver.get(url);

//        driver.findElement(By.id("email")).sendKeys("emrah-c@hotmail.com");
//        driver.findElement(By.name("pass")).sendKeys("levin2018");
//       // driver.findElement(By.xpath("//button[@name='login']")).click();
//        driver.findElement(By.linkText("Forgotten password?")).click();

        driver.findElement(By.cssSelector("#email")).sendKeys("hello");
        driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("password");
        driver.findElement(By.xpath("//*[@id='u_0_e']/div[3]/a")).click();




    }

}
