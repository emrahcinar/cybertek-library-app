package test.Self_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice_3 {

    public static void main(String[] args) throws InterruptedException{
        //TC #3: PracticeCybertek/ForgotPassword URL verification
        // 1.Open Chrome browser
        // 2.Go to http://practice.cybertekschool.com/forgot_password
        // 3.Enter any email into input box
        // 4.Click on Retrieve password
        // 5.Verify URL contains: Expected: “email_sent”
        // 6.Verify textbox displayed the content as expected.
        // Expected: “Your e-mail’s been sent!”
        // Hint: You need to use getText method for this practice.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.findElement(By.name("email")).sendKeys("emrah@gmail.com" );
        Thread.sleep(2000);

        driver.findElement(By.id("form_submit")).click();
        boolean actualTitle = driver.getCurrentUrl().endsWith("email_sent");
        System.out.println(actualTitle);

        String expected2 = "Your e-mail’s been sent!";
        String actual2=driver.findElement(By.tagName("h4")).getText();
        if (actual2.equals(expected2)) {
            System.out.println("PASSED!");
        } else {
            System.out.println("FAILED!!!");
        }


    }
}
