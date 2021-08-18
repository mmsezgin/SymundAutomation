package com.symund.pages;

import com.symund.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage {
    public DashboardPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//div//img[@height='32']")
    public WebElement profilename;
    @FindBy(xpath = "//div//span[@title]")
    public WebElement title;


}