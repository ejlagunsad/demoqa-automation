package com.demoqa.actions;

import com.demoqa.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomepageActions extends HomePage {

    public HomepageActions(WebDriver driver) {
        super(driver);
    }

    String pageUrl = "https://demoqa.com/";

    public void openPage() {
        openUrl(pageUrl);
    }

    public ElementsActions clickElementsBtn() {
        Assert.assertTrue(awaitForElementVisibility(elementsBtn), "Elements button is not displayed");
        elementsBtn.click();
        return new ElementsActions(driver);
    }

    public AlertsFrameWindowsActions clickAlertsFrameWindowsBtn() {
        Assert.assertTrue(awaitForElementVisibility(alertsFrameWindowsBtn), "Alerts, Frame and Windows button is not displayed");
        alertsFrameWindowsBtn.click();
        return new AlertsFrameWindowsActions(driver);
    }

    public FormsActions clickFormsBtn() {
        Assert.assertTrue(awaitForElementVisibility(formsBtn), "Forms button is not displayed");
        formsBtn.click();
        return new FormsActions(driver);
    }

}
