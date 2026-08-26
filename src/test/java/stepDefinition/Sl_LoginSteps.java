package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Sl_HomePage;
import pages.Sl_LoginPage;
import base.BaseClass;

public class Sl_LoginSteps extends BaseClass {

   Sl_LoginPage loginObj = new Sl_LoginPage();
   Sl_HomePage homeObj = new Sl_HomePage();

   //Valid scenario

   @Given("User is on Login page") //Copied Given teststep under Test Scenario
    public void User_is_on_Login_page () { //Given Given Statement as method name separated by underscore

       //Its work has been already Done by Hooks

    }

    @When("User enters username and Password")
    public void User_enters_username_and_Password () {

        loginObj.FillUsername(prop.getProperty("username"));
        loginObj.FillPassword(prop.getProperty("password"));

    }

    @And("User clicks on Login button")
    public void User_clicks_on_Login_button () throws InterruptedException {

        loginObj.clickLoginbtn();
    }

    @Then("User should be logged in successfully")
    public void User_should_be_logged_in_successfully () {

        homeObj.validateLogin();

    }

    //Invalid scenario:

    //@given is common

    @When("User enters wrong username and Password")
    public void User_enters_wrong_username_and_Password(){

        loginObj.FillUsername("Wrong_username"); //hard coded values
        loginObj.FillPassword("Wrong_secret_password");
    }

    //@And is common

    @Then("Error message should be displayed")
    public void Error_message_should_be_displayed  (){

        //Using direct assertion unlike prev. @then where we invoked method containing assertion

        boolean isErrorDisplayed = loginObj.isErrorMessageDisplayed();

        Assert.assertTrue("Error Message Not displayed for ivalid login ",isErrorDisplayed );

        System.out.println("Error message displayed successfully for ivalid login");
    }






}
