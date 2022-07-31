package com.obtaincare.UI.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//div[@class='tl-title tl-ellipsis']")
    public WebElement textOfHomePage;

    public String getTextOfHomePage(){
       return helper.getText(textOfHomePage);
    }


}
