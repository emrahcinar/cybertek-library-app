package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {

    public UserPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy()
    public WebElement showRecordsdropdown;
}
