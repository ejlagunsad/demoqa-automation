package com.demoqa.pages;

import com.demoqa.actions.BaseActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsPage extends BaseActions {

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    String expectedRedirectionUrl = "https://demoqa.com/elements";

    //Locators:
    @FindBy(css = ".left-pannel .element-group:nth-child(1)")
    protected WebElement elementGroupLocator;


    //Textbox Option

    @FindBy(css = ".left-pannel .element-group:nth-child(1) .menu-list #item-0")
    protected WebElement elementsMenuListTextBoxLocator;

    @FindBy(css = ".text-field-container")
    protected WebElement textFieldCont;

        // Textbox Labels:
        @FindBy(id = "userName-label")
        protected WebElement nameLabel;

        @FindBy(id = "userEmail-label")
        protected WebElement emailLabel;

        @FindBy(id = "currentAddress-label")
        protected WebElement currAddressLabel;

        @FindBy(id = "permanentAddress-label")
        protected WebElement permaAddressLabel;

        //Textbox Locators:
        @FindBy(id = "userName")
        protected WebElement nameField;

        @FindBy(id = "userEmail")
        protected WebElement emailField;

        @FindBy(id = "currentAddress")
        protected WebElement currAddressField;

        @FindBy(id = "permanentAddress")
        protected WebElement permaAddressField;

    @FindBy(id = "submit")
    protected WebElement submitBtn;

    @FindBy(id = "output")
    protected WebElement output;

        //Output locators:
        protected By nameOutput = By.id("name");
        protected By emailOutput = By.id("email");
        protected By currAddOutput = By.cssSelector("#output #currentAddress");
        protected By permaAddOutput = By.cssSelector("#output #permanentAddress");

    //Checkbox Option
    @FindBy(css = ".left-pannel .element-group:nth-child(1) .menu-list #item-1")
    protected WebElement elementsMenuListCheckBox;

    @FindBy(css = ".check-box-tree-wrapper")
    protected WebElement checkboxTreeWrapper;

    @FindBy(css = "span:has(label[for*='home']) button svg")
    protected WebElement homeCollapseBtnElement;

    @FindBy(css = "span:has(label[for*='desktop']) button svg")
    protected WebElement desktopCollapseBtnElement;

        //Desktop Tree
        @FindBy(css = "label[for*='desktop'] span[class='rct-checkbox'] svg")
        protected WebElement desktopCheckboxElement;

        @FindBy(css = "label[for*='notes'] span[class='rct-checkbox'] svg")
        protected WebElement notesCheckboxElement;

        @FindBy(css = "label[for*='commands'] span[class='rct-checkbox'] svg")
        protected WebElement commandsCheckboxElement;

    @FindBy(css = "span:has(label[for*='documents']) button svg")
    protected WebElement documentsCollapseBtnElement;

    @FindBy(css = "span:has(label[for*='workspace']) button svg")
    protected WebElement workspaceCollapseBtnElement;

    @FindBy(css = "span:has(label[for*='office']) button svg")
    protected WebElement officeCollapseBtnElement;

    @FindBy(css = "span:has(label[for*='downloads']) button svg")
    protected WebElement downloadCollapseBtnElement;
}