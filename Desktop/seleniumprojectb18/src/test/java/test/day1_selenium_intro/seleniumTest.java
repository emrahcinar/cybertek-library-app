package test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumTest {
    public static void main(String[] args) throws InterruptedException {
        //1-This line creats the connection between driver and selenium.
        //And sets up the driver.
        WebDriverManager.chromedriver().setup();

        //2-Creating the instance of ChromeDriver to be able to do action on ChromeBrowser
        WebDriver driver = new ChromeDriver();

        //The line below maximazia the page after opening it
        driver.manage().window().maximize();
         // driver.manage().window().fullscreen();

        //To use firefox driver
        // WebDriver driver=new FirefoxDriver();

        //3-We get www.google.com
        //String googleUrl="https://www.google.com"

        driver.get("https://www.google.com");
        System.out.println("driver.getTitle()-->" + driver.getTitle());
        System.out.println("driver.getCurrentUrl()-->" + driver.getCurrentUrl());

        //BROWSER NAVIGATIONS
        //this line will take user to the previous page
        Thread.sleep(2000);//thus line add 2000miliseconds of wait==2 seconds
        driver.navigate().back();

        //  Thread.sleep is being added just to be able to see selenium movements
        Thread.sleep(2000);
        driver.navigate().forward();

        Thread.sleep(2000);
        driver.navigate().refresh();//This line will refresh the page

        driver.navigate().to("https://www.facebook.com");

        System.out.println("driver.getTitle()-->" + driver.getTitle());
        System.out.println("driver.getCurrentUrl()-->" + driver.getCurrentUrl());
        System.out.println(driver.getPageSource());

        driver.close();
        driver.quit();


    }
}
