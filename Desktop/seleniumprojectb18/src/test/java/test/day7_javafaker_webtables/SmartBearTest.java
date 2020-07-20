package test.day7_javafaker_webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

//TC #1: Smartbear software link verification
//1. Open browser
//2. Go to website:
//http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
//3. Enter username: "Tester"
//4. Enter password: "test"
//5. Click to Login button
//6. Print out count of all the links on landing page
//7. Print out each link text on this page
public class SmartBearTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //1-2
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //3. Enter username: "Tester"
        WebElement inputUserNAme = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        inputUserNAme.sendKeys("Tester");

        //4. Enter password: "test"
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        inputPassword.sendKeys("test");

        //5. Click to Login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();
    }

    @Test
    public void p1_smartbear_login_test() {

        //6. Print out count of all the links on landing page
        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));

        //System.out.println("Number of the links: "+allLinks.size());
        int expectedNumberOfLinks = 6;
        int actualNumberOfLinks = allLinks.size();
        Assert.assertEquals(actualNumberOfLinks, 6);

        //7. Print out each link text on this page

        for (WebElement link : allLinks) {
            System.out.println(link.getText());
        }
    }

        @Test
        public void p2_smartbear_order_placing() throws InterruptedException{
//TC#2: Smartbear software order placing
//1. Open browser
//2. Go to website:
//http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
//3. Enter username: "Tester"
//4. Enter password: "test"
//5. Click on Login button
//6. Click on Order
            WebElement orderLink=driver.findElement(By.xpath("//a[.='Order']"));
            orderLink.click();

//7. Select familyAlbum from product, set quantity to 2
            Select productDropdown=new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
            productDropdown.selectByVisibleText("FamilyAlbum");

            WebElement quantitiyInput=driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
           // quantitiyInput.clear();//just delete if there is any existing input box.
            Thread.sleep(1000);
            quantitiyInput.sendKeys(Keys.BACK_SPACE);
            Thread.sleep(1000);
            quantitiyInput.sendKeys("2");


//8. Click to "Calculate" button
//9. Fill address Info with JavaFaker
//• Generate: name, street, city, state, zip code
//10. Click on "visa" radio button
//11. Generate card number using JavaFaker
//12. Click on "Process"
//13.Verify success message "New order has been successfully added."






    }


}
