package com.bitrix.test;

import com.bitrix.page.ActivityStream;
import com.bitrix.page.LoginPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import sun.rmi.runtime.Log;
import utulities.ConfigurationReader;
import utulities.Driver;

import java.util.concurrent.TimeUnit;

public class login {
    LoginPage loginPage;
    ActivityStream activityStream;

    @Test
    public void login() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loginPage = new LoginPage();

        loginPage.loginname.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.submitbutton.click();
    }
@Test
    public void likeButton() {
        Driver.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        activityStream = new ActivityStream();
//        activityStream.likebutton.get(0).click();
//        Assert.assertTrue(ActivityStream.;


    }
}
