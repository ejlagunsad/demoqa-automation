package com.demoqa.test.alertsframewindows;

import com.demoqa.actions.AlertsFrameWindows.NestedFramesActions;
import com.demoqa.actions.AlertsFrameWindowsActions;
import com.demoqa.actions.HomepageActions;
import com.demoqa.base.TestUtilities;
import org.testng.annotations.Test;

public class NestedFramesTests extends TestUtilities {

    @Test
    public void verifyNestedFrames() {
        HomepageActions homepageActions = new HomepageActions(driver);
        homepageActions.openPage();

        AlertsFrameWindowsActions alertsFrameWindowsActions = homepageActions.clickAlertsFrameWindowsBtn();
        NestedFramesActions nestedFramesActions = alertsFrameWindowsActions.clickMenuListNestedFrames();
        nestedFramesActions.verifyNestedFrame();
    }



}
