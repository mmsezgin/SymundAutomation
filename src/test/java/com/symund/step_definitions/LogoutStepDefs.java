package com.symund.step_definitions;

import com.symund.pages.LoginPage;
import com.symund.utilities.BrowserUtils;
import com.symund.utilities.ConfigurationReader;
import com.symund.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogoutStepDefs {

    @Given("the user logged in")
    public void the_user_logged_in() {
        String url= ConfigurationReader.get("url");
        Driver.get().get(url);
        LoginPage loginPage=new LoginPage();
        loginPage.username.sendKeys(ConfigurationReader.get("username"));
        loginPage.password.sendKeys(ConfigurationReader.get("password")+ Keys.ENTER);
        BrowserUtils.waitFor(2);
        String expect="dashboard";
        String actual=Driver.get().getCurrentUrl();
        Assert.assertTrue(actual.contains(expect));
    }

    @When("the user click user info and click Log out")
    public void the_user_click_user_info_and_click_Log_out() {
        LoginPage loginPage=new LoginPage();
        loginPage.userInfo.click();
        loginPage.logout.click();
    }

    @Then("the user should be able to log out")
    public void the_user_should_be_able_to_log_out() {
        String url = "symund.com/index.php/login?clear=1";
        String actual=Driver.get().getCurrentUrl();
        System.out.println(actual);
        BrowserUtils.waitFor(4);
        Assert.assertTrue(actual.trim().contains(url));
    }

    @Given("the user navigates to user info at righthand corner and clicks log out")
    public void the_user_navigates_to_user_info_at_righthand_corner_and_clicks_log_out() {
        LoginPage loginPage=new LoginPage();
        loginPage.userInfo.click();
        loginPage.logout.click();
    }

    @When("the user clicks go back button")
    public void the_user_clicks_go_back_button() {

        String actualUrl=Driver.get().getCurrentUrl();

        if (actualUrl.contains("symund.com/index.php/apps/files/?dir=/&fileid=6954")) {
            System.out.println("I'm closing the driver !!!!!!!!!!!");
            Driver.closeDriver();
        }
    }

    @Then("the user should not see home page")
    public void the_user_should_not_see_home_page() {
        String url= ConfigurationReader.get("url");
        Driver.get().get(url);
    }
}
