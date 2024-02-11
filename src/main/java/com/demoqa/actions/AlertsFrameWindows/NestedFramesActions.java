package com.demoqa.actions.AlertsFrameWindows;

import com.demoqa.pages.AlertsFrameWindows.NestedFramesPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NestedFramesActions extends NestedFramesPage {
    public NestedFramesActions(WebDriver driver) {
        super(driver);
    }

    public void verifyNestedFrame() {
        Assert.assertTrue(awaitForElementVisibility(frame1Wrap), "Parent Frame wrap is not displayed");
        Assert.assertTrue(awaitForElementVisibility(parentFrame), "Parent Frame is not displayed");
        switchToIframe(parentFrame);
        Assert.assertTrue(
                getPageSource().contains("Parent frame"), //Get pagesource inside iframe
                "Parent frame text is incorrect");
        Assert.assertTrue(awaitForElementVisibility(childFrame), "Child Frame is not displayed");
        switchToIframe(childFrame);
        Assert.assertTrue(iframeBody.getText().contains("Child Iframe"), "Child frame text is incorrect");
    }
}