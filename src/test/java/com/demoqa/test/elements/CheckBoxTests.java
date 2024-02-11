package com.demoqa.test.elements;

import com.demoqa.actions.ElementsActions;
import com.demoqa.actions.HomepageActions;
import com.demoqa.base.TestUtilities;
import org.testng.annotations.Test;

public class CheckBoxTests extends TestUtilities {

    @Test
    public void elementsCheckBox() {
        HomepageActions homepageActions = new HomepageActions(driver);
        homepageActions.openPage();

        ElementsActions elementPageActions = homepageActions.clickElementsBtn();
        elementPageActions.verifyElementsCheckBox();
    }
}
