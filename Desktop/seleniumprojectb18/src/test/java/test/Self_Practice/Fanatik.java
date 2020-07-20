package test.Self_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class Fanatik {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.fanatik.com.tr/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
        @Test
        public void TestNG(){
            Select SelectMultiple1 = new Select(driver.findElement(By.xpath("//select[@id='liveScoreTournamentPicker']")));
            System.out.println(SelectMultiple1.getFirstSelectedOption().getText());

           SelectMultiple1.selectByVisibleText("LIGUE 1");
            SelectMultiple1.selectByIndex(3);
            String expected="İNGİLTERE PREMIER LİG";
            String actual=SelectMultiple1.getFirstSelectedOption().getText();
            Assert.assertEquals(expected,actual);
    }




    @AfterTest
    public void AfterMethod(){
      //  driver.close();
    }
}
