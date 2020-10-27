package cybertek_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2_PageTitleTest {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        String url="http://google.com";
        driver.get(url);
        Thread.sleep(3000);

        System.out.println(driver.getTitle());
        driver.close();//will current page // driver.quit();//will close entire browser


    }
}
