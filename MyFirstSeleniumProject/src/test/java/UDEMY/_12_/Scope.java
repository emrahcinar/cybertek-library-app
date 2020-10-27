package UDEMY._12_;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Scope {
    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://rahulshettyacademy.com/AutomationPractice/";
        driver.get(url);

        //1. Count of links on the page
        System.out.println(driver.findElements(By.tagName("a")).size());

        //2.Count of the footer section
        WebElement footerdriver = driver.findElement(By.id("gf-BIG"));//limiting webdriver scoop
        System.out.println(footerdriver.findElements(By.tagName("a")).size());

        //3. Count of link at Discount section
        WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(columndriver.findElements(By.tagName("a")).size());

        //4.click on each link in the column and check if the pages are opening

        for (int i = 1; i < columndriver.findElements(By.tagName("a")).size(); i++) {
            String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
            Thread.sleep(3000);
        }
            Set<String> abc = driver.getWindowHandles();
            Iterator<String> it = abc.iterator();


            while (it.hasNext()) {

                driver.switchTo().window(it.next());
                System.out.println(driver.getTitle());

            }

        }
    }
