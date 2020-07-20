package test.Self_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC02_FindElements_Apple {
    public static void main(String[] args) {
        //1.Open Chrome Browser
        //2.Go to https://www.apple.com
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.apple.com");

        //3.Click to iPhone
        WebElement iPhoneclick=driver.findElement(By.xpath("//a[@href='/iphone/']"));
        iPhoneclick.click();

        //4.Print out the texts of all links
        //body//a ==> will return all of the links inside of B
        List<WebElement>ListOfLinks=driver.findElements(By.xpath("//body//a"));
        int linkwithoutText=0;
        int linkwithText=0;

        for (WebElement eachLink:ListOfLinks){
            String textOfEachLink=eachLink.getText();
            System.out.println(textOfEachLink);
            if (textOfEachLink.isEmpty()){
                linkwithoutText++;
            }else
                linkwithText++;
        }

        //5.Print out how many links is missing text
        System.out.println("Missing text number : "+linkwithoutText);
        //6.Print out how many link has text
        System.out.println("Text number : "+linkwithText);
        //7.Print out how many total link
        System.out.println("Total link: "+ListOfLinks.size());




    }
}
