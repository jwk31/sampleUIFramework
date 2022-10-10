package com.obtaincare.UI.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//div[@class='tl-title tl-ellipsis']")
    public WebElement textOfHomePage;

    public String getTextOfHomePage(){
       return helper.getText(textOfHomePage);
    }

    @FindBy(xpath = "(//a[@href='https://yrysbek.talentlms.com/user/index/gridPref:reset'])[2]")
    public WebElement usersButton;

    public HomePage clickUsersButton(){
        helper.click(usersButton);
        return this;
    }

    @FindBy(xpath = "(//a[@href='https://yrysbek.talentlms.com/user/create'])[2]")
    public WebElement addUserButton;

    public HomePage clickAddUserButton(){
        helper.click(addUserButton);
        return this;
    }


}
