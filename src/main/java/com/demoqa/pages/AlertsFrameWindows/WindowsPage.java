package com.demoqa.pages.AlertsFrameWindows;

import com.demoqa.actions.BaseActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowsPage extends BaseActions {

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "browserWindows")
    protected WebElement windowsSection;

    @FindBy(id = "tabButton")
    protected WebElement newTabBtn;

    @FindBy(id = "sampleHeading")
    protected WebElement newTabSampleHeading;

    @FindBy(id = "windowButton")
    protected WebElement newWindowBtn;

    @FindBy(id = "messageWindowButton")
    protected WebElement newMessageWindowBtn;

}