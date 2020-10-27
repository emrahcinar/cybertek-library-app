package UDEMY._14_;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class _114_Strategy_to_Automate_broken_links {
    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Broken url
        //Step  - IS to get all urls tied up to the links using selenium
        //Java methods will call URL's and gets you the status code
        //If status code>0 than that url is not working->link which tied to url is broken
        //$('a[href*="soapui"]')
        String urls = "https://www.rahulshettyacademy.com/AutomationPractice/";
        driver.get(urls);
        // String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");

        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert a= new SoftAssert();

        for (WebElement link : links) {
            String url = link.getAttribute("href");


            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int respCode = conn.getResponseCode();
            System.out.println(respCode);
           a.assertTrue(respCode < 400,"The link with Text " + link.getText() + " is broken with code " + respCode);

        }
        a.assertAll();
    }
}
