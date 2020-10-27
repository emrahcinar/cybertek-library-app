package UDEMY.Three;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class How_to_run_test_16 {

    public static void main(String[] args) {
        //   WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "http://google.com";
        driver.get(url);//hit url on the browser
        System.out.println(driver.getTitle());//Validate if your page title is correct
        System.out.println(driver.getCurrentUrl());//validate if you are landed correct URL
        System.out.println(driver.getPageSource());//print page source

        String url2= "http://yahoo.com";
        driver.get(url2);//hit url on the browser
        driver.navigate().back();
        driver.navigate().forward();
        driver.close();//close current browser
        driver.quit();//close all browser


    }
}
