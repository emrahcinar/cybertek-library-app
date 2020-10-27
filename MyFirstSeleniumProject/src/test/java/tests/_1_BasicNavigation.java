package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1_BasicNavigation {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
       // WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url="http://google.com";
        driver.get(url);
        System.out.println(driver.getTitle());
       // driver.get("http://practice.cybertekschool.com/open_new_tab");
        //Thread.sleep(4000);
        driver.close();//will close current web page
        //driver.quit();//will close entire browser
        //driver.get(URL);//open website




    }
}
