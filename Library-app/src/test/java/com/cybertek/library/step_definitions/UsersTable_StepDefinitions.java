package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.UsersPage;
import com.cybertek.library.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class UsersTable_StepDefinitions {

    UsersPage usersPage=new UsersPage();


    @Then("table should have following column names:")
    public void tableShouldHaveFollowingColumnNames(List<String> expectedColumnNames) {

//        System.out.println("expectedColumnNames = " + expectedColumnNames);
//        System.out.println("expectedColumnNames.size() = " + expectedColumnNames.size());

        BrowserUtils.waitForVisibility(usersPage.showRecordsdropdown,5);
        List<String> actualColumnNames = BrowserUtils.getElementsText(usersPage.tableHeaders);
        Assert.assertEquals(expectedColumnNames,actualColumnNames);


    }
}
