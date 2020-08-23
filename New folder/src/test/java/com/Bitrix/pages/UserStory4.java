package com.Bitrix.pages;

import com.Bitrix.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.cert.X509Certificate;

public class UserStory4 {

    public UserStory4() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(name = "USER_LOGIN")
    public WebElement userName;

    @FindBy(name = "USER_PASSWORD")
    public WebElement userPassword;

    @FindBy(id = "feed-add-post-form-link-text")
    public WebElement moreButton;

    @FindBy(className = "menu-popup-item-text")
    public WebElement fileButton;

    @FindBy(xpath = "//*[@id='diskuf-selectdialog-B00EawF']/div[2]/table/tbody/tr[1]/td[1]/div/span/span/span[1]/span")
    public WebElement UploadFiles;

    //AC3 scenario
    @FindBy (className = "feed-add-post-micro-title")
    public WebElement sendMessageSpace;

    @FindBy (xpath = "//*[@id='bx-b-link-blogPostForm']/span")
    public WebElement linkIconclick;

    @FindBy (xpath = "//*[@id='bx-b-video-blogPostForm']/span")
    public WebElement videoIconClicking;

    @FindBy(id = "video_idPostFormLHE_blogPostForm-source")
    public WebElement videoSourceSpace;

    @FindBy(id = "undefined")
    public WebElement SaveButtonAfterVideoSource;

    @FindBy(id = "linkidPostFormLHE_blogPostForm-href")
    public WebElement sendLinkButton;

    @FindBy(xpath = "//*[@id='feed-add-buttons-blockblogPostForm']//button[1]")//under message SEND Button
    public WebElement sendButton;


    



}
