package com.demoqa.test.elements;

import com.demoqa.actions.ElementsActions;
import com.demoqa.actions.HomepageActions;
import com.demoqa.base.TestUtilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TextBoxTests extends TestUtilities {

    @Parameters({"name", "email", "currAdd", "permaAdd"})
    @Test
    public void elementsTextBox(String name, String email, String currAdd, String permaAdd) {

        HomepageActions homepageActions = new HomepageActions(driver);
        homepageActions.openPage();

        ElementsActions elementPageActions = homepageActions.clickElementsBtn();
        elementPageActions.verifyElementsTextBox(name, email, currAdd, permaAdd);
    }
}