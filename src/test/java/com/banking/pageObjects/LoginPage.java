package com.banking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver ldriver;
    public LoginPage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);

    }
    @FindBy(name="uid")
    @CacheLookup
    WebElement txtUsername;
    @FindBy(name="password")
    @CacheLookup
    WebElement password;
    @FindBy(name="btnLogin")
    WebElement LoginButton;
    @FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
    WebElement logoutLink;

    public void setUsername(String uname){
        txtUsername.sendKeys(uname);

    }
    public void setPassword(String pwd){
        password.sendKeys(pwd);
    }
    public void clickButton(){
        LoginButton.click();
    }
    public void clickLogout(){
        logoutLink.click();

    }
}
