package com.demoqa.actions.AlertsFrameWindows;

import com.demoqa.pages.AlertsFrameWindows.WindowsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.Assert;

public class WindowsActions extends WindowsPage {

    public WindowsActions(WebDriver driver) {
        super(driver);
    }

    String expectedRedirectionUrl = "https://demoqa.com/browser-windows";

    protected void verifyWindowsRedirection() {
        Assert.assertEquals(getCurrentUrl(),expectedRedirectionUrl, "Redirect to incorrect page");
    }

    protected void verifyWindowsSection() {
        Assert.assertTrue(awaitForElementVisibility(windowsSection), "Windows section is not displayed");
    }

    public void verifyNewTab() {
        verifyWindowsRedirection();
        verifyWindowsSection();

        Assert.assertTrue(awaitForElementVisibility(newTabBtn), "New Tab button is not displayed");
        newTabBtn.click();
        switchToWindowWithTitle("https://demoqa.com/sample");
        Assert.assertTrue(awaitForElementVisibility(newTabSampleHeading), "Sample heading is not displayed");
    }

    public void verifyNewWindow() {
        verifyWindowsRedirection();
        verifyWindowsSection();

        Assert.assertTrue(awaitForElementVisibility(newWindowBtn), "New Tab button is not displayed");
        newWindowBtn.click();
        switchToWindowWithTitle("https://demoqa.com/sample");
        Assert.assertTrue(awaitForElementVisibility(newTabSampleHeading), "Sample heading is not displayed");
    }

    public void verifyNewWindowMessage() {
        verifyWindowsRedirection();
        verifyWindowsSection();

        Assert.assertTrue(awaitForElementVisibility(newMessageWindowBtn), "New Tab button is not displayed");
        newMessageWindowBtn.click();
        switchToWindowWithTitle("about:blank");
        Assert.assertTrue(getPageSource().contains("Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization."), "Page Content is not displayed");
    }

}
