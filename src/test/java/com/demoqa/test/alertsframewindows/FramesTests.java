package com.demoqa.test.alertsframewindows;

import com.demoqa.actions.AlertsFrameWindows.FramesActions;
import com.demoqa.actions.AlertsFrameWindowsActions;
import com.demoqa.actions.HomepageActions;
import com.demoqa.base.TestUtilities;
import org.testng.annotations.Test;

public class FramesTests extends TestUtilities {

    @Test
    public void verify1stFrames() {
        HomepageActions homepageActions = new HomepageActions(driver);
        homepageActions.openPage();

        AlertsFrameWindowsActions alertsFrameWindowsActions = homepageActions.clickAlertsFrameWindowsBtn();
        FramesActions framesActions = alertsFrameWindowsActions.clickMenuListFrames();
        framesActions.verify1stFrames();
    }

    @Test
    public void verify2ndFrames() {
        HomepageActions homepageActions = new HomepageActions(driver);
        homepageActions.openPage();

        AlertsFrameWindowsActions alertsFrameWindowsActions = homepageActions.clickAlertsFrameWindowsBtn();
        FramesActions framesActions = alertsFrameWindowsActions.clickMenuListFrames();
        framesActions.verify2ndFrame();
    }

}
