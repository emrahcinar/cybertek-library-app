package tests;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyFirstTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
    }
}