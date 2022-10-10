package com.obtaincare.UI.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//input[@name='login']")
    public WebElement userNameOrEmailInputField;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInputField;

    @FindBy(xpath = "//input[@name='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//a[text() = 'password']")
    public WebElement forgotYourPasswordLink;

    public LoginPage inputUserNameOrEmail(String userNameOrEmail){
        helper.sendKeys(userNameOrEmailInputField,userNameOrEmail);
        return this;
    }

    public LoginPage inputPassword(String password){
        helper.sendKeys(passwordInputField,password);
        return this;
    }

    public LoginPage clickLoginButton(){
        helper.click(loginButton);
        return this;
    }

    public void loginToSystem(String userNameOrEmail, String password){
        inputUserNameOrEmail(userNameOrEmail).inputPassword(password).clickLoginButton();
    }
}
