package test.day2_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P4_GoogleTitleVerification {
    public static void main(String[] args) throws InterruptedException{
        //TC#4:	Google	search
        // 1-Open	a	chrome	browser
        //for manuel importing : Windows: alt+enter Mac: option+enter
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2-Go	to:	https://google.com
        driver.get("https://www.google.com");

        // 3-Write	“apple”	in	search	box
        //driver.findElement(By.name("q")).sendKeys("apple" + Keys.ENTER);
        driver.findElement(By.name("q")).sendKeys("apple");
        Thread.sleep(2000);
        //  driver.findElement()
        // 4-Click	google	search	button
        driver.findElement(By.name("btnK")).click();
        // 5-Verify	title:
        String actualTitle = driver.getTitle();
        String expectedInTItle = "apple";

        if (actualTitle.startsWith(expectedInTItle)) {
            System.out.println("Google search title verification PASSED!");
        } else {
            System.out.println("Google search title verification FAILED!!!");
        }
        // Expected:	Title	should	start	with	“apple”	wor


    }
}
