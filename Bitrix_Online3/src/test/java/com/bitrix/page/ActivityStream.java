package com.bitrix.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utulities.Driver;

import java.util.List;

public class ActivityStream {

    public void Loginpage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//a[.='Like']")
    public WebElement likebutton;

    @FindBy(xpath =  "//a[.='Comment']")
    public WebElement commentbutton;

    @FindBy(xpath =  "//a[.='Unfollow']")
    public WebElement submitbutton;

    @FindBy(xpath =  "//span[@datareaction='like']")
    public List<WebElement> likeIcon;
}
