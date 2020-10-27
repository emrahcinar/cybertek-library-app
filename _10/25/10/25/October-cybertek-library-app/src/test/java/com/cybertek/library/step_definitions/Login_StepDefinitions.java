package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.LandingPage;
import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_StepDefinitions {

    LoginPage loginPage=new LoginPage();
    LandingPage landingPage=new LandingPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        String url= ConfigurationReader.getProperty("qa2_url");
        Driver.getDriver().get(url);
    }

    @When("I login as a librarian")
    public void i_login_as_a_librarian() {

        String userName=ConfigurationReader.getProperty("lib50_user");
        String password=ConfigurationReader.getProperty("lib50_pass");

        loginPage.usernameInput.sendKeys(userName);
        loginPage.passwordInput.sendKeys(password);
        loginPage.signInButton.click();

    }
    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        String expected="dashboard";

        wait.until(ExpectedConditions.urlContains(expected));
        String actual=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actual.contains(expected));
        Driver.closeDriver();

    }


    @When("I login as a Student")
    public void iLoginAsAStudent() {
        String userName=ConfigurationReader.getProperty("student100_user");
        String password=ConfigurationReader.getProperty("student100_pass");

        loginPage.usernameInput.sendKeys(userName);
        loginPage.passwordInput.sendKeys(password);
        loginPage.signInButton.click();
    }

    @Then("books should be displayed")
    public void booksShouldBeDisplayed() {
        String expected="books";
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.urlContains(expected));
        String actual=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actual.contains(expected));
        Driver.closeDriver();
    }
    @When("I enter user name {string}")
    public void i_enter_user_name(String userName) {
       // String userName;
        loginPage.usernameInput.sendKeys(userName);
    }

    @When("I enter password {string}")
    public void i_enter_password(String password) {

        loginPage.passwordInput.sendKeys(password);

    }
    @When("click the sign in button")
    public void click_the_sign_in_button() {

        loginPage.signInButton.click();

    }
    @Then("there should be {int} users")
    public void there_should_be_users(Integer int1) {

        int expectedUserNumber=int1;
        wait.until(ExpectedConditions.visibilityOf(landingPage.userCount));
        String expected=String.valueOf(expectedUserNumber);
        String actual=landingPage.userCount.getText();

        Assert.assertEquals("Actual user numbers is not as expected!",actual,expected);


    }

    @When("I login using {string} and {string}")
    public void iLoginUsingAnd(String userName , String password) {

        loginPage.usernameInput.sendKeys(userName);
        loginPage.passwordInput.sendKeys(password);

        loginPage.signInButton.click();

    }
}
