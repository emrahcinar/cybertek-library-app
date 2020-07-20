package test.day7_javafaker_webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class dropdowns {

    //TC #3: Selecting date on dropdown and verifying
    // 1.Open Chrome browser
    // 2.Go to http://practice.cybertekschool.com/dropdown
    // 3.Select “December 1st, 1921” and verify it is selected.
    // Select year using: visible text
    // Select month using : value attribute
    // Select day using: index number

    WebDriver driver;

    @Test
    public void test3_date_verification() {

        //1 and 2
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //3

        Select selectMonth = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        selectMonth.selectByValue("11");

        Select selectDay = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        selectDay.selectByValue("1");

        Select selectYear = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        selectYear.selectByValue("1921");

    }

    //TC #4: Selecting value from multiple select dropdown
    // 1.Open Chrome browser
    // 2.Go to http://practice.cybertekschool.com/dropdown
    // 3.Select all the options from multiple select dropdown.
    // 4.Print out all selected values.
    // 5.Deselect all values.


    @Test
    public void test4_date_verification() throws Exception {

        //1 and 2
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //3
        Select selectMultiple = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        selectMultiple.selectByIndex(0);
        selectMultiple.selectByValue("js");
        selectMultiple.selectByIndex(2);
        selectMultiple.selectByIndex(3);
        selectMultiple.selectByIndex(4);
        selectMultiple.selectByVisibleText("C");

        //4
        List<WebElement> allOptions = selectMultiple.getAllSelectedOptions();
        for (WebElement element : allOptions) {
            System.out.println("Selected options: " + element.getText());
        }
        //5
        Thread.sleep(2000);
        selectMultiple.deselectAll();
    }
    @Test
    public void test5_nonselected_fropdown() {
        //TC #5: Selecting value from non-select dropdown
        // 1.Open Chrome browser
        // 2.Go to http://practice.cybertekschool.com/dropdown
        // 3.Click to non-select dropdown
        // 4.Select Facebook from dropdown
        // 5.Verify title is “Facebook -Log In or Sign Up”

        //1 and 2
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //3
        WebElement element1 = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        element1.click();
        // 4-
        WebElement element2 = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/']"));
        element2.click();
        // 5-
        String actualTitle = "Facebook - Log In or Sign Up";
        String expectedTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
