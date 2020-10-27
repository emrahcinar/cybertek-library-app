package UDEMY.Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class _88_Homework {
    public static void main(String[] args) {

        System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://the-internet.herokuapp.com/windows";
        driver.get(url);


        driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
        driver.getTitle();

        Set<String> first = driver.getWindowHandles();
        Iterator<String> second = first.iterator();
        String parent = second.next();
        String child = second.next();
        driver.switchTo().window(child);
        System.out.println(driver.getTitle());
        driver.switchTo().window(parent);
        System.out.println(driver.getTitle());

        /*
System.setProperty("webdriver.chrome.driver", "C://work//chromedriver.exe");
WebDriver driver=new ChromeDriver();
driver.get("http://the-internet.herokuapp.com/");
driver.findElement(By.linkText("Multiple Windows")).click();
driver.findElement(By.cssSelector("a[href*='windows']")).click();
Set<String> abc=driver.getWindowHandles();
Iterator<String> it=abc.iterator();
String parentWindow=it.next();
driver.switchTo().window(it.next());
System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
driver.switchTo().window(parentWindow);
System.out.println(driver.findElement(By.xpath("//div[@id='content']/div/h3")).getText());
         */

    }
}
