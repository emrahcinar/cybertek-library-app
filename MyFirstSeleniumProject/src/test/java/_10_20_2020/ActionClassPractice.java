package _10_20_2020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ActionClassPractice {
    @Test
    public void dragAndDropTest() throws Exception {

        System.setProperty("webdriver.chrome.setup", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "http://demos.telerik.com/kendo-ui/dragdrop/index";
        driver.get(url);


        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droptarget = driver.findElement(By.id("droptarget"));
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, droptarget).perform();

        Thread.sleep(3000);


        Assert.assertEquals(droptarget.getText(), "You did great!");
        driver.close();


    }

    @Test
    public void hoverTest() {
        System.setProperty("webdriver.chrome.setup", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "http://practice.cybertekschool.com/hovers";
        driver.get(url);

        Actions actions = new Actions(driver);
        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        WebElement img1Text = driver.findElement(By.xpath("//*[text()='name: user1']"));
        actions.moveToElement(img1).perform();
        Assert.assertTrue(img1Text.isDisplayed());

        List<WebElement>images=driver.findElements(By.tagName("img"));

        for (WebElement image : images){
            actions.moveToElement(image).pause(2000).perform();
        }

        driver.close();


    }

}
