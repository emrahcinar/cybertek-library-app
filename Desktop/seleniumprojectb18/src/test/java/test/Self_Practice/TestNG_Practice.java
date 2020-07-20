package test.Self_Practice;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

public class TestNG_Practice {
    @BeforeSuite
    public void beforeSuit() {
        System.out.println("Before Suit");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @BeforeClass
    public void beforeClss() {
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void setup() {
        System.out.println("Before method...");
    }

    @Test(priority = 3)
    public void test1() {
        String word1 = "java";
        String word2 = "java";
        System.out.println("Test1");
        Assert.assertEquals(word1, word2);
    }


    @Test(priority = 2)
    public void test2() {
        String word1 = "javascript";
        String word2 = "javascript";
        System.out.println("Test2");
        Assert.assertEquals(word1, word2);
    }


    @Test(priority = 1)
    public void test3() {
        System.out.println("Test3");
        Assert.assertTrue(15 > 10);
        throw new SkipException("Just Skipped");
    }

    @AfterMethod
    public void teardown() {
        System.out.println("After Method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    @AfterSuite
    public void afterSuit() {
        System.out.println("After Suit");
    }
}
