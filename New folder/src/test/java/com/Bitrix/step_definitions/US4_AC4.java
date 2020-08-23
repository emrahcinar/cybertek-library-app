package com.Bitrix.step_definitions;

import com.Bitrix.pages.UserStory4;
import com.Bitrix.utilities.Driver;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;

import java.util.concurrent.TimeUnit;

public class US4_AC4 {
    UserStory4 story4 = new UserStory4();

    @Then("user clicking to send message empty space")
    public void user_clicking_to_send_message_empty_space() {
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        story4.sendMessageSpace.click();


    }

    @Then("user clicks to video icon button")
    public void user_clicks_to_video_icon_button() {
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        story4.videoIconClicking.click();
    }

    @Then("user should entering video URL and hit enter button")
    public void user_should_entering_video_url_and_hit_enter_button() throws Exception {
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);



        story4.videoSourceSpace.sendKeys("https://www.youtube.com/watch?v=7zp1TbLFPp8");
        Thread.sleep(5000);
        story4.SaveButtonAfterVideoSource.click();
    }

    @Then("user clickin to send button")
    public void user_clickin_to_send_button() {
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        story4.sendButton.click();
    }


}
