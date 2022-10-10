package com.obtaincare.UI.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserPage extends BasePage{

    @FindBy(xpath = "//div[@class='tl-title tl-ellipsis']")
    public WebElement textOfAddUserPage;

    public String getTextOfAddUserPage(){
        return helper.getText(textOfAddUserPage);
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

    @FindBy(xpath = "//input[@name='submit_personal_details']")
    public WebElement addUserButton;

    public AddUserPage inputFirstName(String userFirstName) {
        helper.sendKeys(firstNameInput, userFirstName);
        return this;
    }

    public AddUserPage inputLastName(String userLastName) {
        helper.sendKeys(lastNameInput, userLastName);
        return this;
    }

    public AddUserPage inputEmail(String userEmail) {
        helper.sendKeys(emailAddressInput, userEmail);
        return this;
    }

    public AddUserPage inputUserName(String userName) {
        helper.sendKeysWithClear(usernameInput, userName);
        return this;
    }

    public AddUserPage inputPassword(String userPassword) {
        helper.sendKeys(passwordInput, userPassword);
        return this;
    }

    public AddUserPage inputBio(String userBio) {
        helper.sendKeys(bioInput, userBio);
        return this;
    }

    public AddUserPage selectUserType(String userType) {
        helper.selectFromDropDown(userTypeSelect,userType);
        return this;
    }

    public AddUserPage selectTimeZone(String timeZone) {
        helper.selectFromDropDown(timeZoneSelect,timeZone);
        return this;
    }

    public AddUserPage selectLanguage(String language) {
        helper.selectFromDropDown(languageSelect,language);
        return this;
    }

    public AddUserPage clickAddUserButton(){
        helper.click(addUserButton);
        return this;
    }

    public AddUserPage inputAllUserInfo(String userFirstName,String userLastName, String userEmail, String userName,
                                        String userPassword, String userBio, String userType, String timeZone, String language){
        inputFirstName(userFirstName).inputLastName(userLastName)
                .inputEmail(userEmail).inputUserName(userName)
                .inputPassword(userPassword).inputBio(userBio)
                .selectUserType(userType).selectTimeZone(timeZone)
                .selectLanguage(language).clickAddUserButton();
        return this;
    }
}
