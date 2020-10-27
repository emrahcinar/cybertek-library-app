package cybertek_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {

    public static void main(String[] args) throws Exception{
        //to setup chrome driver
       // WebDriverManager.chromedriver().setup();
        System.setProperty("Webdriver.chrome.driver","chromedriver.exe");
        //to create object of chromeDriver class
        ChromeDriver driver=new ChromeDriver();
        String url="http://google.com";
        String url2="http://amazon.com";

        //will open browser with URL
        driver.get(url);
        Thread.sleep(3000);

        //will refresh the page
        driver.navigate().refresh();

        //navigate to amazon.com
        driver.navigate().to(url2);
        Thread.sleep(3000);

        //will navigate to previous URL(www.google.com)
        driver.navigate().back();
        Thread.sleep(3000);

        //will navigate to forward URL(www.amazon.com)
        driver.navigate().forward();
        Thread.sleep(3000);

        //will close browser
        driver.close();



    }
}
