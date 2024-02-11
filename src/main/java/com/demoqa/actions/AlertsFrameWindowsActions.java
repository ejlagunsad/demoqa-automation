package com.demoqa.actions;

import com.demoqa.actions.AlertsFrameWindows.AlertsActions;
import com.demoqa.actions.AlertsFrameWindows.FramesActions;
import com.demoqa.actions.AlertsFrameWindows.NestedFramesActions;
import com.demoqa.actions.AlertsFrameWindows.WindowsActions;
import com.demoqa.pages.AlertsFrameWindowsPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AlertsFrameWindowsActions extends AlertsFrameWindowsPage {

    public AlertsFrameWindowsActions(WebDriver driver) {
        super(driver);
    }

    String expectedRedirectionUrl = "https://demoqa.com/alertsWindows";

    protected void verifyAlertsFrameWindowsSideNav() {
        Assert.assertEquals(getCurrentUrl(),expectedRedirectionUrl, "Redirect to incorrect page");
        Assert.assertTrue(awaitForElementVisibility(alertsFrameWindowsGroupLocator), "Elements groups is not available on Left Panel");
    }

    public AlertsActions clickMenuListAlerts() {
        verifyAlertsFrameWindowsSideNav();
        Assert.assertTrue(awaitForElementVisibility(alertsFrameWindowsMenuListAlertsLocator), "Alerts box is not available on Left Panel");
        alertsFrameWindowsMenuListAlertsLocator.click();
        return new AlertsActions(driver);
    }

    public WindowsActions clickMenuListWindows() {
        verifyAlertsFrameWindowsSideNav();
        Assert.assertTrue(awaitForElementVisibility(alertsFrameWindowsMenuListWindowsLocator), "Windows is not available on Left Panel");
        alertsFrameWindowsMenuListWindowsLocator.click();
        return new WindowsActions(driver);
    }

    public FramesActions clickMenuListFrames() {
        verifyAlertsFrameWindowsSideNav();
        Assert.assertTrue(awaitForElementVisibility(alertsFrameWindowsMenuListFramesLocator), "Windows is not available on Left Panel");
        alertsFrameWindowsMenuListFramesLocator.click();
        return new FramesActions(driver);
    }

    public NestedFramesActions clickMenuListNestedFrames() {
        verifyAlertsFrameWindowsSideNav();
        Assert.assertTrue(awaitForElementVisibility(alertsFrameWindowsMenuListNestedFramesLocator), "Windows is not available on Left Panel");
        alertsFrameWindowsMenuListNestedFramesLocator.click();
        return new NestedFramesActions(driver);
    }
}
