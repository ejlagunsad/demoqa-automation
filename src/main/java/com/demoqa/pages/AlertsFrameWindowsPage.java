package com.demoqa.pages;

import com.demoqa.actions.BaseActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsFrameWindowsPage extends BaseActions {

    public AlertsFrameWindowsPage(WebDriver driver) {
        super(driver);
    }

    //Locators:
    @FindBy(css = ".left-pannel .element-group:nth-child(3)")
    protected WebElement alertsFrameWindowsGroupLocator;


    @FindBy(css = ".left-pannel .element-group:nth-child(3) .menu-list #item-1")
    protected WebElement alertsFrameWindowsMenuListAlertsLocator;

    @FindBy(css = ".left-pannel .element-group:nth-child(3) .menu-list #item-0")
    protected WebElement alertsFrameWindowsMenuListWindowsLocator;

    @FindBy(css = ".left-pannel .element-group:nth-child(3) .menu-list #item-2")
    protected WebElement alertsFrameWindowsMenuListFramesLocator;

    @FindBy(css = ".left-pannel .element-group:nth-child(3) .menu-list #item-3")
    protected WebElement alertsFrameWindowsMenuListNestedFramesLocator;


}
