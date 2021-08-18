package com.symund.pages;

import com.symund.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
    public LogOutPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//img[contains(@srcset, '/index.php/avatar/Employee81/64?v=0')]")
    public WebElement userInfo;
    @FindBy(xpath = "//li[@data-id='logout']")
    public WebElement logout;
    @FindBy(xpath = "//a[contains (text(),'Bir aygıt ile oturum açın')]")
    public WebElement loggedOut;







}