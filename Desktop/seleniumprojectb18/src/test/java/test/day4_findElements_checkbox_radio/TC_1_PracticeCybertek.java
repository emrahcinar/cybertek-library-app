package test.day4_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

/*
XPATH PRACTICESDO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/forgot_password
3. Locate all the WebElements on the page using XPATH locator only (total of 6)
a. “Home” link
b. “Forgot password” header
c.“E-mail” text
d. E-mail input box
e. “Retrieve password” button
f. “Powered byCybertek School” text
4. Verify all WebElements are displayed.
 */
public class TC_1_PracticeCybertek {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        Thread.sleep(2000);
        WebElement web = driver.findElement(By.xpath("//a[.='Home']"));
        web.click();

        driver.findElement(By.xpath("//a[.='Forgot Password']")).click();
        driver.findElement(By.xpath("//label[contains(@for,'email')]"));
        WebElement emailbox = driver.findElement(By.xpath("//input[contains(@pattern,'[a-z0-9.')]"));
        emailbox.sendKeys("bilal@cybertek.com");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[contains(@id,'form_submit')]")).click();

       WebElement  actualresult= driver.findElement(By.xpath("//div[contains(@style,'align')]"));
       if (actualresult.isDisplayed()){
           System.out.println("PASSED");
       }else{
           System.out.println("Failed");
       }

    }

}
