package test.day3_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P4_ZeroBankURLVerification {
    public static void main(String[] args) {
        //TC #4: Zero Bank
        // .Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // 2.Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");
        // 3.Get attribute value of href from the “forgot your password”link
        WebElement forgotPasswordLink = driver.findElement(By.partialLinkText("Forgot"));
        // 4.Verify attribute value contains
        // Expected: “/forgot-password.html”

        String actualHrefValue = forgotPasswordLink.getAttribute("href");
        String expextedHrefValue = "/forgot-password.html";

        System.out.println("ActualHrefValue= " + actualHrefValue);

        if (actualHrefValue.contains(expextedHrefValue)){
            System.out.println("Href verification verification PASSED!!");
        }else{
            System.out.println("Href verification verification FAILED!!");
        }
        System.out.println("Is forgot password displayed? "+forgotPasswordLink.isDisplayed());
        System.out.println(driver.findElement(By.className("offset3")).isDisplayed());
    }
}
