package com.obtaincare.UI.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserInfoPage extends BasePage{
    @FindBy(xpath = "(//ul[@class='nav nav-tabs']//li[1])[1]")
    public WebElement infoButton;

    public UserInfoPage clickInfoButton(){
        helper.click(infoButton);
        return this;
    }

    @FindBy(xpath = "//input[@name='name']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='surname']")
    public WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailAddressInput;

    @FindBy(xpath = "//input[@name='login']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement bioInput;

    @FindBy(xpath = "//select[@name='acl_user_type_id']")
    public WebElement userTypeSelect;

    @FindBy(xpath = "//select[@name='timezone']")
    public WebElement timeZoneSelect;

    @FindBy(xpath = "//select[@name='language']")
    public WebElement languageSelect;

}
