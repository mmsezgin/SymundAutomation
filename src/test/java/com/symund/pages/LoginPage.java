package com.symund.pages;

import com.symund.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "user")
    public WebElement username;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(id = "submit-form")
    public WebElement submit;
    @FindBy(css = ".warning.wrongPasswordMsg")
    public WebElement error;
    @FindBy(xpath = "//a//img")
    public WebElement eyesign;
    @FindBy(id = "lost-password")
    public WebElement forgotPassword;
    @FindBy(id = "reset-password-submit")
    public WebElement resetPassword;

    @FindBy(xpath = "//img[contains(@srcset, '/index.php/avatar/Employee81/64?v=0')]")
    public WebElement userInfo;
    @FindBy(xpath = "//li[@data-id='logout']")
    public WebElement logout;




    public void login(String userName,String passWord){
        username.sendKeys(userName);
        password.sendKeys(passWord);

    }



}