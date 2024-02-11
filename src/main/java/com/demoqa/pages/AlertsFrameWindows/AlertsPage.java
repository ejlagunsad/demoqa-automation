package com.demoqa.pages.AlertsFrameWindows;


import com.demoqa.actions.BaseActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends BaseActions {

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "alertButton")
    protected WebElement alertBtn;

    @FindBy(id = "timerAlertButton")
    protected WebElement alertTimeBtn;

    @FindBy(id = "confirmButton")
    protected WebElement alertConfirmBtn;

    @FindBy(id = "confirmResult")
    protected WebElement alertConfirmResult;

    @FindBy(id = "promtButton")
    protected WebElement alertPromptBtn;

    @FindBy(id = "promptResult")
    protected WebElement alertPromptResult;

}
