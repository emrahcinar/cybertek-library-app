package UDEMY.Eight;

import javafx.beans.binding.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class _58_updatedDropdown {
    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.spicejet.com/";
        driver.get(url);

        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());

        System.out.println(driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_SeniorCitizenDiscount']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());

        //.ui-state-default.ui-state-highlight.ui-state-active
     //   System.out.println("enable "+driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
        System.out.println("style "+driver.findElement(By.cssSelector("div[id='Div1']")).getAttribute("style"));
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        //System.out.println("enable "+driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
        System.out.println("style "+driver.findElement(By.cssSelector("div[id='Div1']")).getAttribute("style"));
       if (driver.findElement(By.cssSelector("div[id='Div1']")).getAttribute("style").contains("1")){
           System.out.println("its enabled");
           Assert.assertTrue(true);
       }else{
           Assert.assertTrue(false);
       }

        //Count the number of checkboxes
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());


        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText()); //1 adult

        Select select = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
        select.selectByValue("5");
        String expected=driver.findElement(By.id("divpaxinfo")).getText();
        Assert.assertEquals(expected,"5 Adult");
        System.out.println(expected);//5 adult


    }
}
