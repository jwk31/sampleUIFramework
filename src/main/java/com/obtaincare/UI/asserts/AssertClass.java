package com.obtaincare.UI.asserts;

import com.obtaincare.UI.helperMethods.Helper;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class AssertClass extends Helper {

    public void assertText(String expected, WebElement actual){
        waitElementToBeDisplayed(actual);
        assertEquals(expected, actual.getText());
    }
}
