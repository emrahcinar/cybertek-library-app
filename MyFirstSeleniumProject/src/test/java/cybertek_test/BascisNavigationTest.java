package cybertek_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.DriverManager;

public class BascisNavigationTest {
    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        String url="http://fanatik.com.tr";
        driver.get(url);
        Thread.sleep(3000);

        driver.navigate().refresh();
        Thread.sleep(3000);
        String url2="http://google.com";
        driver.navigate().to(url2);
        Thread.sleep(3000);

        driver.navigate().back();
        Thread.sleep(3000);

        driver.navigate().forward();
        Thread.sleep(3000);

        driver.close();






    }
}
