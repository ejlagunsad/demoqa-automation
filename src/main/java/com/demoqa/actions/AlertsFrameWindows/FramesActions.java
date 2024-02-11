package com.demoqa.actions.AlertsFrameWindows;

import com.demoqa.pages.AlertsFrameWindows.FramesPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FramesActions extends FramesPage {
    public FramesActions(WebDriver driver) {
        super(driver);
    }

    public void verify1stFrames() {
        Assert.assertTrue(awaitForElementVisibility(frame1Wrap) && frame1.isDisplayed(), "Frame 1 is not displayed");
        switchToIframe(frame1);
        Assert.assertTrue(awaitForElementVisibility(frameHeading), "Frame 1 Heading is not displayed");
        Assert.assertTrue(frameHeading.getText().contains("This is a sample page"), "Incorrect Heading Text");
    }

    public void verify2ndFrame() {
        Assert.assertTrue(awaitForElementVisibility(frame2Wrap) && frame2.isDisplayed(), "Frame 1 is not displayed");
        switchToIframe(frame2);
        Assert.assertTrue(awaitForElementVisibility(frameHeading), "Frame 2 Heading is not displayed");
        Assert.assertTrue(frameHeading.getText().contains("This is a sample page"), "Incorrect Heading Text");

    }

}