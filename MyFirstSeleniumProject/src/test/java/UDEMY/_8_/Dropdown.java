package UDEMY._8_;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.spicejet.com/";
        driver.get(url);
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(3000);
        Select select = new Select(driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Adult']")));
        select.selectByValue("2");
        select.selectByIndex(6);
        select.selectByVisibleText("5");




    }
}
