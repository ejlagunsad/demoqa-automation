package com.demoqa.pages.AlertsFrameWindows;

import com.demoqa.actions.BaseActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramesPage extends BaseActions {

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "frame1")
    protected WebElement frame1;

    @FindBy(id = "frame1Wrapper")
    protected WebElement frame1Wrap;

    @FindBy(css = "h1#sampleHeading")
    protected WebElement frameHeading;

    @FindBy(id = "frame2")
    protected WebElement frame2;

    @FindBy(id = "frame2Wrapper")
    protected WebElement frame2Wrap;
}
