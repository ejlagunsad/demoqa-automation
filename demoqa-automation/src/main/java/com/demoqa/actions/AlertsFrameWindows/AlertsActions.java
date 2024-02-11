package com.demoqa.actions.AlertsFrameWindows;

import com.demoqa.pages.AlertsFrameWindows.AlertsPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AlertsActions extends AlertsPage {

    public AlertsActions(WebDriver driver) {
        super(driver);
    }

    String expectedRedirectionUrl = "https://demoqa.com/alerts";

    protected void verifyAlertsRedirection() {
        Assert.assertEquals(getCurrentUrl(),expectedRedirectionUrl, "Redirect to incorrect page");
    }

    public void verifyAlerts() {
        verifyAlertsRedirection();

        Assert.assertTrue(awaitForElementVisibility(alertBtn),"Alert button is not displayed");
        alertBtn.click();
        Assert.assertTrue(awaitAlertVisibility(3), "Alert is not displayed");
        Assert.assertEquals(getAlertText(), "You clicked a button", "Alert text displayed is incorrect");
        clickAlertAcceptBtn();
        Assert.assertFalse(awaitAlertVisibility(3), "Alert is still displayed");
    }

    public void verifyAlertsAppearAfterGivenSec(int duration) {
        verifyAlertsRedirection();

        Assert.assertTrue(awaitForElementVisibility(alertTimeBtn),"Alert button is not displayed");
        alertTimeBtn.click();
        Assert.assertTrue(awaitAlertVisibility(duration), "Alert is not displayed");
        Assert.assertEquals(getAlertText(), "This alert appeared after 5 seconds", "Alert text displayed is incorrect");
        clickAlertAcceptBtn();
        Assert.assertFalse(awaitAlertVisibility(duration), "Alert is still displayed");
    }

    public void verifyAlertsConfirm(String selection) {

        String expectedAlertMsg;

        verifyAlertsRedirection();

        Assert.assertTrue(awaitForElementVisibility(alertConfirmBtn),"Alert button is not displayed");
        alertConfirmBtn.click();
        Assert.assertTrue(awaitAlertVisibility(3), "Alert is not displayed");
        Assert.assertEquals(getAlertText(), "Do you confirm action?", "Alert text displayed is incorrect");

        //Verify Button selection
        if (selection.equals("Accept")) {
            expectedAlertMsg = "You selected Ok";
            clickAlertAcceptBtn();
        } else {
            expectedAlertMsg = "You selected Cancel";
            clickAlertDismissBtn();
        }

        Assert.assertFalse(awaitAlertVisibility(3), "Alert is still displayed");
        Assert.assertTrue(alertConfirmResult.getText().contains(expectedAlertMsg), "Alert Accepted Output is not correct");
    }

    public void verifyAlertsPrompt(String selection, String name) {

        verifyAlertsRedirection();

        Assert.assertTrue(awaitForElementVisibility(alertPromptBtn),"Alert button is not displayed");
        alertPromptBtn.click();
        Assert.assertTrue(awaitAlertVisibility(3), "Alert is not displayed");
        Assert.assertEquals(getAlertText(), "Please enter your name", "Alert text displayed is incorrect");
        inputTextOnAlertField(name);

        //Verify Button selection
        if (selection.equals("Accept")) {
            clickAlertAcceptBtn();
        } else {
            clickAlertDismissBtn();
        }

        Assert.assertFalse(awaitAlertVisibility(3), "Alert is still displayed");

        //Verify Button selection
        if (selection.equals("Accept")) {
            Assert.assertTrue(alertPromptResult.getText().contains("You entered " + name), "Alert Result Output is not correct");
        } else {
            Assert.assertTrue(awaitForElementInVisibility(alertPromptResult), "Alert Result output is still displayed even for Dismiss button");
        }

    }

}
