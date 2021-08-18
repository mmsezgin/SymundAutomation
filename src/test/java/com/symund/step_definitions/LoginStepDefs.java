package com.symund.step_definitions;

import com.symund.pages.DashboardPage;
import com.symund.pages.LoginPage;
import com.symund.utilities.BrowserUtils;
import com.symund.utilities.ConfigurationReader;
import com.symund.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;

public class LoginStepDefs {

    //symu-419
    @Given("the user is on login page")
    public void the_user_is_on_login_page() {
        String url= ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        LoginPage loginPage=new LoginPage();
        loginPage.username.sendKeys(ConfigurationReader.get("username"));
        loginPage.password.sendKeys(ConfigurationReader.get("password"));
    }

    @When("the user click Login button")
    public void the_user_click_Login_button() {
        LoginPage loginPage=new LoginPage();
        loginPage.submit.click();
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        BrowserUtils.waitFor(2);
        String expect="dashboard";
        String actual=Driver.get().getCurrentUrl();
        Assert.assertTrue(actual.contains(expect));
    }

    @Then("username should be seen under Profile icon")
    public void username_should_be_seen_under_Profile_icon() {
        DashboardPage dashboardPage=new DashboardPage();
        BrowserUtils.waitFor(3);
        dashboardPage.profilename.click();
        String expect=ConfigurationReader.get("username");
        String actual=dashboardPage.title.getText();
        Assert.assertEquals(expect,actual);

        System.out.println("SYMU-419 completed");
    }
    // symu-420


    @And("the user presses Enter key")
    public void the_user_presses_Enter_key() {
        String url= ConfigurationReader.get("url");
        Driver.get().get(url);
        LoginPage loginPage=new LoginPage();
        loginPage.username.sendKeys(ConfigurationReader.get("username"));
        loginPage.password.sendKeys(ConfigurationReader.get("password")+ Keys.ENTER);
        System.out.println("SYMU-420 completed");

    }

    //@symu-421
    @When("the user enters {string} and {string}")
    public void the_user_enters_and(String actualUsername, String actualPassword) {
        LoginPage loginPage=new LoginPage();
        String expectedUsername = ConfigurationReader.get("username");
        String expectedPassword = ConfigurationReader.get("password");
        Assert.assertEquals(expectedUsername,actualUsername);
        Assert.assertEquals(expectedPassword,actualPassword);

    }

    @Then("{string} error message should be seen")
    public void error_message_should_be_seen(String actualWrongUserPassMessage) {
        LoginPage loginPage=new LoginPage();
        actualWrongUserPassMessage ="Wrong username or password.";
        String expectedWrongUserPassMessage=loginPage.error.getText();
        Assert.assertEquals("Wrong username or password",expectedWrongUserPassMessage,actualWrongUserPassMessage);
    }

    @Then("the user should not be able to login")
    public void the_user_should_not_be_able_to_login() {
        BrowserUtils.waitFor(2);
        String expect="dashboard";
        String actual=Driver.get().getCurrentUrl();
        Assert.assertFalse(actual.contains(expect));
        System.out.println("SYMU-421 invalid credentials FAILED completed");

    }
    //@symu-422 Verify that user should see Error message when a credential is left blank
    @When("the user left {string} as blank")
    public void the_user_left_as_blank( String blankText) {
        LoginPage loginPage=new LoginPage();
        System.out.println(blankText);
        //loginPage.username.sendKeys(ConfigurationReader.get("username"));
        //loginPage.password.sendKeys(ConfigurationReader.get("password"));

    }

    @Then("Please fill in this field message for {string} should be seen")
    public void please_fill_in_this_field_message_for_should_be_seen(String messageBlank) {

        LoginPage loginPage=new LoginPage();
        String actualMessage ="";
        if ( loginPage.username.getText().isEmpty()){
            System.out.println("Blank username");
            actualMessage= loginPage.username.getAttribute("validationMessage");

        }else if (loginPage.password.getText().isEmpty()){
            System.out.println("Blank password");
            actualMessage= loginPage.username.getAttribute("validationMessage");
        }
        String message="Please fill in this field.";
        Assert.assertEquals(message,actualMessage);
    }
    //  @symu-423 Scenario: Verify that user can see the password in a form of dots
    @Then("the user can see password in a form of dots by default")
    public void the_user_can_see_password_in_a_form_of_dots_by_default() {
        LoginPage loginPage=new LoginPage();
        String expect="password";
        String actual=loginPage.password.getAttribute("type");
        Assert.assertEquals(expect,actual);
    }
    // @symu-424 Scenario: Verify that user should be able to see password explicitly
    @When("the user click {string}")
    public void the_user_click(String string) {
        LoginPage loginPage=new LoginPage();
        loginPage.eyesign.click();
    }

    @Then("the user should be able to see password explicitly")
    public void the_user_should_be_able_to_see_password_explicitly() {
        LoginPage loginPage=new LoginPage();
        String expect="text";
        String actual=loginPage.password.getAttribute("type");
        Assert.assertEquals(expect,actual);
    }
    // @symu-425   Scenario: Verify that user can see "forgot password" on the login page
    @Then("the link {string} should be displayed on the login page")
    public void the_link_should_be_displayed_on_the_login_page(String string) {
        LoginPage loginPage=new LoginPage();
        Assert.assertTrue(loginPage.forgotPassword.isDisplayed());
    }
    // @symu-426 Scenario: Verify that user should be able to see "Reset password" button
    @Then("Reset password button should be seen")
    public void reset_password_button_should_be_seen() {
        BrowserUtils.waitFor(3);
        LoginPage loginPage=new LoginPage();
        loginPage.forgotPassword.click();
        String expected="Reset password";
        String actual=loginPage.resetPassword.getAttribute("value");
        Assert.assertEquals(expected,actual);
    }
    // @symu-427 Scenario Outline: Verify that user can see valid placeholders on Username and Password fields
    @Then("the user should be able to see {string} for {string} field")
    public void the_user_should_be_able_to_see_for_field(String typeUserOrPasswd, String textInside) {
        LoginPage loginPage=new LoginPage();
        if (typeUserOrPasswd.equals("Username")){
            textInside =loginPage.username.getAttribute("placeholder");
            Assert.assertEquals(typeUserOrPasswd, textInside);

        }else if(typeUserOrPasswd.equals("Password")){
            textInside=loginPage.password.getAttribute("placeholder");
            Assert.assertEquals(typeUserOrPasswd, textInside);
        }
        System.out.println("Inside 427");
    }

}
