package UDEMY._14_;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class _112_MaximizingWindowsAndDeletingCookies {

    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        // driver.manage().deleteCookieNamed("sessionKey");


        //click on any link
        //login page- verify login url

        String url = "http://google.com";
        driver.get(url);

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:\\Users\\Elena\\screenshot.png"));


    }
}
