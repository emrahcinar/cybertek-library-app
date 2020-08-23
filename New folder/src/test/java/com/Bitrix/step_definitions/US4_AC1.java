package com.Bitrix.step_definitions;

import com.Bitrix.pages.UserStory4;
import com.Bitrix.utilities.ConfigurationReader;
import com.Bitrix.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;

public class US4_AC1 {
    UserStory4 story4 = new UserStory4();

    @Given("User is on the Login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("bitrix_url"));

    }

    @Then("User logs in as marketing credential")
    public void user_logs_in_as_marketing_credential() throws Exception {


        story4.userName.sendKeys(ConfigurationReader.getProperty("usernameBitrixMarketing"));
        story4.userPassword.sendKeys(ConfigurationReader.getProperty("passwordBitrixMarketing") +
                Keys.ENTER);

    }

    @Then("User should be able to see dashboard")
    public void user_should_be_able_to_see_dashboard() {
//        String actualTitle=Driver.getDriver().getTitle();
//        String expectedTitle="Portal";
//        Assert.assertEquals(actualTitle,expectedTitle);

    }

    @Then("user click to file under more dropdown")
    public void user_click_to_file_under_more_dropdown() throws Exception {
//        bitrixSearchPage.moreButton.click();
//        Thread.sleep(5000);
//        bitrixSearchPage.fileButton.click();

    }

    @Then("user should be able to see uploads file and images icon")
    public void user_should_be_able_to_see_uploads_file_and_images_icon() {

    }

    @Then("user should be able to see download from external drive icon")
    public void user_should_be_able_to_see_download_from_external_drive_icon() {

    }

    @Then("user should be able to see select document from Bixtrix24 icon")
    public void user_should_be_able_to_see_select_document_from_bixtrix24_icon() {

    }

    @Then("user should be able to see create files to upload icon")
    public void user_should_be_able_to_see_create_files_to_upload_icon() {

    }
}
