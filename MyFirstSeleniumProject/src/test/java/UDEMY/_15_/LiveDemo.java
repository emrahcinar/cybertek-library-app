package UDEMY._15_;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LiveDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://rahulshettyacademy.com/seleniumPractise/#/offers";
        driver.get(url);
        //click on column
        driver.findElement(By.xpath("//tr//th[1]")).click();

        //capture all webelements into list
        List<WebElement> elementsList = driver.findElements(By.xpath("//tr//td[1]"));

        //capture text of all webelements into new (original) list
        List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());

        //sort on the original list of step 3 - > sorted list
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        //compare original list vs sorted list
        Assert.assertTrue(originalList.equals(sortedList));

        List<String> price;
        //scan the name column and if we getText ->Beans -> print the price of the Rice
        do {
            List<WebElement> rows = driver.findElements(By.xpath("//tr//td[1]"));
       price = rows.stream().filter(s -> s.getText().contains("Rice")).
                    map(s -> getPriceVeggie(s)).collect(Collectors.toList());

            price.forEach(a -> System.out.println(a));

            if (price.size() < 1) {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        }while (price.size()<1);
    }
    private static String getPriceVeggie(WebElement s) {
        String priceValue = s.findElement(By.xpath("//tr//td[1]//following-sibling::td[1]")).getText();

        return priceValue;
    }
}