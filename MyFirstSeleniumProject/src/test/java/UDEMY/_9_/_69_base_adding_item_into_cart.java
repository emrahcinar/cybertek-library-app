package UDEMY._9_;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class _69_base_adding_item_into_cart {


    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait w = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
        String url = "https://rahulshettyacademy.com/seleniumPractise/";
        driver.get(url);
        String itemsNeeded[] = {"Cucumber", "Brocolli", "Beetroot", "Carrot"};
        Thread.sleep(3000);
        addItems(driver, itemsNeeded);

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();


        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());


        _69_base_adding_item_into_cart b = new _69_base_adding_item_into_cart();
        b.addItems(driver, itemsNeeded);


    }

    public static void addItems(WebDriver driver, String itemsNeeded[]) {
        int j = 0;
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0; i < products.size(); i++) {
            //Brocolli - 1Kg
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();
            List itemNeededList = Arrays.asList(itemsNeeded);
            // int j = 0;
            if (itemNeededList.contains(formattedName)) {
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if (j == itemsNeeded.length) {
                    break;
                }
            }
        }
    }


}
