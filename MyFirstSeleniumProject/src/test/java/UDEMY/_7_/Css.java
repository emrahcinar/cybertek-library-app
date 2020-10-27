package UDEMY._7_;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Css {
    public static void main(String[] args) throws Exception{

        // xpath =  //input[@id='username'] or  //*[@id='username']
        // Css  =     input[id='username']  or     [id='username']

        WebDriver driver=new ChromeDriver();
        String url="https://login.salesforce.com";
        driver.get(url);
        driver.findElement(By.cssSelector("[id='username']")).sendKeys("fewrew");

        driver.findElement(By.cssSelector("input[id='password']")).sendKeys("43537");

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='Login']")).click();





    }
}
