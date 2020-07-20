package test.day6_testing_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class Amazon {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        //TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values
        // 1.Open Chrome browser
        // 2.Go to http://practice.cybertekschool.com/dropdown
        // 3.Verify “Simple dropdown” default selected value is correct
        // Expected: “Please select an option”
        // 4.Verify“State selection” default selected value is correc
        // tExpected: “Select a State

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.amazon.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void TestNG() {
        Select AllDepDropdown = new Select(driver.findElement(By.xpath("//select[@id='searchDropdownBox']")));
        System.out.println(AllDepDropdown.getFirstSelectedOption().getText());

        AllDepDropdown.selectByValue("search-alias=warehouse-deals");
        String expected = "Amazon Warehouse";
        String actual = AllDepDropdown.getFirstSelectedOption().getText();

      //  Assert.assertEquals(actual, expected);
        //  Assert.assertTrue(actual,expected);

    }


    @AfterTest
    public void AfterMethod() {
        // driver.close();
    }


}
