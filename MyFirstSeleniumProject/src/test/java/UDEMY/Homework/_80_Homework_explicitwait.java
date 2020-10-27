package UDEMY.Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _80_Homework_explicitwait {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.setup", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "http://www.itgeared.com/demo/1506-ajax-loading.html";
        driver.get(url);

        WebDriverWait w = new WebDriverWait(driver, 5);
        w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Click to load get data via Ajax!")));

        driver.findElement(By.linkText("Click to load get data via Ajax!")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='results']")));
        String output = driver.findElement(By.cssSelector("div[id='results']")).getText();
        System.out.println(output);


    }

}
