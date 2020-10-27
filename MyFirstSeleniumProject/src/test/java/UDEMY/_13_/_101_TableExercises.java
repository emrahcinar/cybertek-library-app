package UDEMY._13_;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _101_TableExercises {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.cricbuzz.com/live-cricket-scorecard/30419/srh-vs-kxip-22nd-match-indian-premier-league-2020";
        driver.get(url);

        WebElement table = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
        int rowcount = table.findElements(By.cssSelector("cb-col cb-col-100 cb-scrd-itms")).size();
        int count = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();

        int sum = 0;
        for (int i = 0; i < count - 2; i++) {
            String value = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();

            int valueInteger = Integer.parseInt(value);
            sum += valueInteger;
        }
        //  System.out.println(sum);
        String extras = driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();

        int extraValue = Integer.parseInt(extras);

        int totalValue = sum + extraValue;
        System.out.println("totalValue = " + totalValue);
        String actualTotal = driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
        int actualTotalValue = Integer.parseInt(actualTotal);

        if (actualTotalValue==totalValue){
            System.out.println("Matches");
        }else{
            System.out.println("Fail");
        }
    }
}
