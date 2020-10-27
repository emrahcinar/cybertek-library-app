package UDEMY._11_;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class _86_exercise {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://accounts.google.com/signup";
        driver.get(url);

        driver.findElement(By.xpath("//a[contains(text(),'Help')]")).click();
        System.out.println("### Before Switching");
        System.out.println(driver.getTitle());

        Set<String> ids = driver.getWindowHandles();
        Iterator<String> it = ids.iterator();
        String parentid = it.next();
        String childid = it.next();
        driver.switchTo().window(childid);
        System.out.println("### After Switching");
        System.out.println(driver.getTitle());

        driver.switchTo().window(parentid);
        System.out.println("### Switching back to parent");
        System.out.println(driver.getTitle());
    }
}
