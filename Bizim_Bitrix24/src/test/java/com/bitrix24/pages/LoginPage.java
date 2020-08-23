package com.bitrix24.pages;

import com.bitrix24.utulities.ConfigurationReader;
import com.bitrix24.utulities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(name="USER_LOGIN")
    private WebElement loginUsername;

    @FindBy(name="USER_PASSWORD")
    private WebElement loginPassword;

    @FindBy(className="login-btn")
    private WebElement button;


    public void login(){
        String userName= ConfigurationReader.getProperty("username");
        String password=ConfigurationReader.getProperty("password");
        loginUsername.sendKeys(userName);
        loginPassword.sendKeys(password);
        button.click();


    }

}
