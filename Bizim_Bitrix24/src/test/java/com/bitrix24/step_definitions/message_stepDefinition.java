package com.bitrix24.step_definitions;

import com.bitrix24.pages.LoginPage;
import com.bitrix24.utulities.ConfigurationReader;
import com.bitrix24.utulities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class message_stepDefinition {
    LoginPage loginPage=new LoginPage();
    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
    }

    @Then("User logs in as {string}")
    public void userLogsIn(String arg0) {
        loginPage.login();
    }

    @And("User navigates to {string}")
    public void userNavigatesTo(String arg0) {
    }

    @When("User clicks {string} button")
    public void userClicksButton(String arg0) {
    }

    @And("User clicks {string} icon")
    public void userClicksIcon(String arg0) {
    }

    @And("User upload files and images")
    public void userUploadFilesAndImages() {
    }

    @And("User clicks send button")
    public void userClicksSendButton() {
    }

    @Then("User should able to see the picture on page")
    public void userShouldAbleToSeeThePictureOnPage() {
    }

    @Then("user navigates to {string}")
    public void user_navigates_to(String string) {

    }
}
