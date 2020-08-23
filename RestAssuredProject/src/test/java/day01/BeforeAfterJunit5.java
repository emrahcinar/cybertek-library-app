package day01;

import org.junit.jupiter.api.*;

public class BeforeAfterJunit5 {

    //this method will run only once before the entire test
    //same idea as @BeforeClass you learned previously
    //there are JUNIT5 Specific annotations
    @BeforeAll
    public static void setUp(){
        System.out.println("This run Before All");
    }

    //same idea as @beforeMethod you learn previously
    //this is Junit5 specific annotation for same idea
    @BeforeEach
    public void beforeEachTest(){
        System.out.println("Running before each test (BeforeEach)");
    }

    @Test
    public void test1(){
        System.out.println("Test 1 is running");
    }

   // @Disabled //same idea as @ignore  you learned before
    @Test
    public void test2(){
        System.out.println("Test 2 is running");
    }

    //same idea as @afterMEthod you learned previously
    @AfterEach
    public void afterEachTest(){
        System.out.println("Running after each test (AftereEach)");
    }

    //this method will run only once after all the test
    //same idesa as @afterClass annotation you learn previouly
    @AfterAll
    public static void tearDown(){
        System.out.println("This run all the way at the end");
    }

}
