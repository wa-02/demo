package org.example.schoology.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.SharedDriver;
import org.example.schoology.pages.*;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class CommonStepdefs {

    private Home home;

    private SubMenu subMenu;

    private Resources resources;
    private AddQuestionPopup addQuestionPopup;

    public CommonStepdefs(SharedDriver sharedDriver){

    }

    @Given("I log in as {string} user")
    public void iLogInAsUser(String account) {
        Login login = new Login();
        home = login.loginAs("magnethus01@gmail.com", "TheTop86!");
    }


    @When("I navigate to {string}")
    public void iNavigateToCoursesGroups(String menu) {
        subMenu = home.clickMenu(menu);
        subMenu.clickViewListLink(menu);
    }

    @Then("I should see the {string} message")
    public void iShouldSeeTheMessage(String message) {
        Assert.assertEquals(message, new ViewList().getMessage());
    }
}


