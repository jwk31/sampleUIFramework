package com.obtaincare.UI.asserts;

import com.obtaincare.UI.helperMethods.Helper;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AssertClass extends Helper {

    public void assertTextWithGetText(String expected, WebElement actual){
        waitElementToBeDisplayed(actual);
        assertEquals(expected, actual.getText());
    }

    public void assertTextWithValueByAttribute(String expected, WebElement actual){
        waitElementToBeDisplayed(actual);
        assertEquals(expected, actual.getAttribute("value"));
    }

    public void assertTextWithGetTextFromSelect(String expected, WebElement select, int indexOfList){
        waitElementToBeDisplayed(select);
        String [] list = select.getText().split("\n");
        assertEquals(expected, list[indexOfList]);
    }


}
