package UDEMY.Eight;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class _64_e2e {
    public static void main(String[] args) throws Exception{
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.spicejet.com/";
        driver.get(url);
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@value='DEL']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']"))
                .click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-active']")).click();
        Thread.sleep(2000);
        if (driver.findElement(By.cssSelector("div[id='Div1']")).getAttribute("style").contains("0.5")){
            System.out.println("its disenabled");
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }
        driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_SeniorCitizenDiscount']")).click();
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);

        Select select = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
        select.selectByValue("5");
        String expected=driver.findElement(By.id("divpaxinfo")).getText();
        Assert.assertEquals(expected,"5 Adult");
        System.out.println(expected);

        driver.findElement(By.cssSelector("input[id='ctl00_mainContent_btn_FindFlights']")).click();

    }
}
