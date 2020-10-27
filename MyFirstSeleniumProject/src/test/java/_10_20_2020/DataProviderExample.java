package _10_20_2020;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {


    @Test (description = "Verify Page Title", dataProvider = "testData")
    public void test1(String url,String title){

        //System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        Assert.assertTrue(driver.getTitle().contains(title));
        driver.quit();
    }

    @DataProvider(name = "testData")
    public Object[][] testData(){

        return new Object[][]{  {"http://google.com","Google"},
                                {"http://amazon.com","Amazon"},
                                {"http://etsy.com","Etsy"}};


    }


}
