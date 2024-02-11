package com.demoqa.pages.AlertsFrameWindows;

import com.demoqa.actions.BaseActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NestedFramesPage extends BaseActions {
    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "frame1Wrapper")
    protected WebElement frame1Wrap;

    protected By parentFrame = By.xpath("//iframe[contains(@id,'frame1')]");
    protected By childFrame = By.xpath("//iframe[contains(@srcdoc,'Child Iframe')]");

    @FindBy(xpath = "//body")
    protected WebElement iframeBody;

}