package com.demoqa.pages;

import com.demoqa.actions.BaseActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseActions {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".category-cards .card:nth-child(1)")
    protected WebElement elementsBtn;

    @FindBy(css = ".category-cards .card:nth-child(2)")
    protected WebElement formsBtn;

    @FindBy(css = ".category-cards .card:nth-child(3)")
    protected WebElement alertsFrameWindowsBtn;

}
