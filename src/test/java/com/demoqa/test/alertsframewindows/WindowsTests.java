package com.demoqa.test.alertsframewindows;

import com.demoqa.actions.AlertsFrameWindows.WindowsActions;
import com.demoqa.actions.AlertsFrameWindowsActions;
import com.demoqa.actions.HomepageActions;
import com.demoqa.base.TestUtilities;
import org.testng.annotations.Test;

public class WindowsTests extends TestUtilities {

    @Test
    public void verifyWindowsNewTab() {
        HomepageActions home = new HomepageActions(driver);
        home.openPage();

        AlertsFrameWindowsActions alertsFrameWindowsActions = home.clickAlertsFrameWindowsBtn();
        WindowsActions windowsActions = alertsFrameWindowsActions.clickMenuListWindows();
        windowsActions.verifyNewTab();

    }

    @Test
    public void verifyWindowsNewWindow() {
        HomepageActions home = new HomepageActions(driver);
        home.openPage();

        AlertsFrameWindowsActions alertsFrameWindowsActions = home.clickAlertsFrameWindowsBtn();
        WindowsActions windowsActions = alertsFrameWindowsActions.clickMenuListWindows();
        windowsActions.verifyNewWindow();

    }

    @Test(enabled = false) //Unable to fix
    public void verifyWindowsNewMessageWindow() {
        HomepageActions home = new HomepageActions(driver);
        home.openPage();

        AlertsFrameWindowsActions alertsFrameWindowsActions = home.clickAlertsFrameWindowsBtn();
        WindowsActions windowsActions = alertsFrameWindowsActions.clickMenuListWindows();
        windowsActions.verifyNewWindowMessage();
    }

}
