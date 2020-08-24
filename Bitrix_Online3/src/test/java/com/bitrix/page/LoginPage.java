package com.bitrix.page;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utulities.*;

import java.sql.DriverAction;

public class LoginPage {

    public void Loginpage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
        @FindBy(xpath = "//a[@class='bx-ilike-test']")
        public WebElement loginname;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submitbutton;

}
