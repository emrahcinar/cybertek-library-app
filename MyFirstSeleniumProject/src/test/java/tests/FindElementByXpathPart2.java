package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

////span[@class="h1y"]
public class FindElementByXpathPart2 {

    public static void main(String[] args) throws Exception{

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");

        //RELATIVE XPATH
        WebElement headerText=driver.findElement(By.xpath("//span[@class='h1y']"));
        WebElement contextMenuLink=driver.findElement(By.xpath("//a[.='Context Menu']"));
                                                        //      //a[@href="/drag_and_drop"]
        System.out.println("h1 text : "+headerText.getText());
        contextMenuLink.click();
        Thread.sleep(3000);
        driver.close();


    }

}
