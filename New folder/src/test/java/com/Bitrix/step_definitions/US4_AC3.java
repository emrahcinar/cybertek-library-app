package com.Bitrix.step_definitions;

import com.Bitrix.pages.UserStory4;
import com.Bitrix.utilities.Driver;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;


import java.util.concurrent.TimeUnit;

public class US4_AC3 {

    UserStory4 story4 = new UserStory4();

    @Then("user clicks to send message empty space")
    public void user_clicks_to_send_message_empty_space() {
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        story4.sendMessageSpace.click();


    }

    @Then("user clicks to link icon button")
    public void user_clicks_to_link_icon_button() {
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        story4.linkIconclick.click();


    }
    @Then("user should send link to link URL space and hit enter button")
    public void user_should_send_link_to_link_url_space_and_hit_enter_button() {
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        story4.sendLinkButton.sendKeys("https://www.youtube.com/" + Keys.ENTER);

    }
    @Then("user should click send button")
    public void user_should_click_send_button() {
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        story4.sendButton.click();

    }




}
