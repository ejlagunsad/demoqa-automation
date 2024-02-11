package com.demoqa.test.alertsframewindows;

import com.demoqa.actions.AlertsFrameWindows.AlertsActions;
import com.demoqa.actions.AlertsFrameWindowsActions;
import com.demoqa.actions.HomepageActions;
import com.demoqa.base.TestUtilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AlertsTests extends TestUtilities {

    @Test
    public void alertTest() {
        HomepageActions homepageActions = new HomepageActions(driver);
        homepageActions.openPage();

        AlertsFrameWindowsActions alertsFrameWindowsActions = homepageActions.clickAlertsFrameWindowsBtn();
        AlertsActions alertsActions = alertsFrameWindowsActions.clickMenuListAlerts();
        alertsActions.verifyAlerts();
    }

    @Test
    public void alertTestAppearAfterSec() {
        HomepageActions homepageActions = new HomepageActions(driver);
        homepageActions.openPage();

        AlertsFrameWindowsActions alertsFrameWindowsActions = homepageActions.clickAlertsFrameWindowsBtn();
        AlertsActions alertsActions = alertsFrameWindowsActions.clickMenuListAlerts();
        alertsActions.verifyAlertsAppearAfterGivenSec(5);
    }

    @Test
    public void alertTestConfirmResultAccept() {
        HomepageActions homepageActions = new HomepageActions(driver);
        homepageActions.openPage();

        AlertsFrameWindowsActions alertsFrameWindowsActions = homepageActions.clickAlertsFrameWindowsBtn();
        AlertsActions alertsActions = alertsFrameWindowsActions.clickMenuListAlerts();
        alertsActions.verifyAlertsConfirm("Accept");
    }

    @Test
    public void alertTestConfirmResultDismiss() {
        HomepageActions homepageActions = new HomepageActions(driver);
        homepageActions.openPage();

        AlertsFrameWindowsActions alertsFrameWindowsActions = homepageActions.clickAlertsFrameWindowsBtn();
        AlertsActions alertsActions = alertsFrameWindowsActions.clickMenuListAlerts();
        alertsActions.verifyAlertsConfirm("Dismiss");
    }

    @Parameters({"name"})
    @Test
    public void alertTestInputTextAccept(String name) {
        HomepageActions homepageActions = new HomepageActions(driver);
        homepageActions.openPage();

        AlertsFrameWindowsActions alertsFrameWindowsActions = homepageActions.clickAlertsFrameWindowsBtn();
        AlertsActions alertsActions = alertsFrameWindowsActions.clickMenuListAlerts();
        alertsActions.verifyAlertsPrompt("Accept", name);
    }

    @Parameters({"name"})
    @Test
    public void alertTestInputTextDismiss(String name) {
        HomepageActions homepageActions = new HomepageActions(driver);
        homepageActions.openPage();

        AlertsFrameWindowsActions alertsFrameWindowsActions = homepageActions.clickAlertsFrameWindowsBtn();
        AlertsActions alertsActions = alertsFrameWindowsActions.clickMenuListAlerts();
        alertsActions.verifyAlertsPrompt("Dismiss", name);
    }
}