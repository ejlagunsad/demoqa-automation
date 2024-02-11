package com.demoqa.actions;

import com.demoqa.pages.ElementsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ElementsActions extends ElementsPage {

    public ElementsActions(WebDriver driver) {
        super(driver);
    }

    String expectedRedirectionUrl = "https://demoqa.com/elements";

    protected void verifyElementsSideNav() {
        Assert.assertEquals(getCurrentUrl(),expectedRedirectionUrl, "Redirect to incorrect page");
        Assert.assertTrue(awaitForElementVisibility(elementGroupLocator), "Elements groups is not available on Left Panel");
    }

    public void verifyElementsTextBox(String name, String email, String currAdd, String permaAdd) {
        verifyElementsSideNav();
        Assert.assertTrue(awaitForElementVisibility(elementsMenuListTextBoxLocator), "Elements Text box is not available on Left Panel");
        click(elementsMenuListTextBoxLocator);
//        elementsMenuListTextBoxLocator.click();

        Assert.assertTrue(awaitForElementVisibility(textFieldCont), "Textbox field Container is not available");
        Assert.assertEquals(nameLabel.getText(), "Full Name", "Name incorrect Label");
        type(name, nameField);
//        nameField.sendKeys(name);
        Assert.assertEquals(emailLabel.getText(), "Email", "Email incorrect Label");
        type(email, emailField);
//        emailField.sendKeys(email);
        Assert.assertEquals(currAddressLabel.getText(), "Current Address", "Current Address incorrect Label");
        type(currAdd, currAddressField);
//        currAddressField.sendKeys(currAdd);
        Assert.assertEquals(permaAddressLabel.getText(), "Permanent Address", "Permanent Address incorrect Label");
        type(permaAdd, permaAddressField);
//        permaAddressField.sendKeys(permaAdd);
        click(submitBtn);
//        submitBtn.click();

        Assert.assertTrue(awaitForElementVisibility(output), "Output is not displayed");
        Assert.assertEquals(find(nameOutput).getText(), "Name:"+name,"Entered Name don't match Output Name");
        Assert.assertEquals(find(emailOutput).getText(), "Email:"+email,"Entered Email don't match Output Email");
        Assert.assertEquals(find(currAddOutput).getText(), "Current Address :"+currAdd,"Entered Current Address don't match Output Current Address");
        Assert.assertEquals(find(permaAddOutput).getText(), "Permananet Address :"+permaAdd,"Entered Permanent Address don't match Output Permanent Address");
    }

    public void verifyElementsCheckBox() {
        verifyElementsSideNav();

        click(elementsMenuListCheckBox);
        Assert.assertTrue(awaitForElementVisibility(checkboxTreeWrapper), "Checkbox Tree Wrapper is not displayed");

        //Collapse Home
        Assert.assertTrue(homeCollapseBtnElement.getAttribute("class").contains("close"),"Home is not Collapse by default");
        click(homeCollapseBtnElement);
        Assert.assertTrue(homeCollapseBtnElement.getAttribute("class").contains("open"),"Failed to Expand Home Collapse");

        // Collapse Desktop-------------
        Assert.assertTrue(desktopCollapseBtnElement.getAttribute("class").contains("close"),"Desktop is not Collapse by default");
        click(desktopCollapseBtnElement);
        Assert.assertTrue(desktopCollapseBtnElement.getAttribute("class").contains("open"),"Failed to Expand Desktop Collapse");

        verifyDesktopTreeCheckbox(); //Verify Desktop and Child Checkbox behavior

        // Collapse Document-------------
        Assert.assertTrue(documentsCollapseBtnElement.getAttribute("class").contains("close"),"Document is not Collapse by default");
        click(documentsCollapseBtnElement);
        Assert.assertTrue(documentsCollapseBtnElement.getAttribute("class").contains("open"),"Failed to Expand Document Collapse");

        // Collapse WorkSpace

        Assert.assertTrue(workspaceCollapseBtnElement.getAttribute("class").contains("close"),"Workspace is not Collapse by default");
        click(workspaceCollapseBtnElement);
        Assert.assertTrue(workspaceCollapseBtnElement.getAttribute("class").contains("open"),"Failed to Expand Workspace Collapse");

        // Collapse Office

        Assert.assertTrue(officeCollapseBtnElement.getAttribute("class").contains("close"),"Office is not Collapse by default");
        click(officeCollapseBtnElement);
        Assert.assertTrue(officeCollapseBtnElement.getAttribute("class").contains("open"),"Failed to Expand Office Collapse");

        // Collapse Downloads

        Assert.assertTrue(downloadCollapseBtnElement.getAttribute("class").contains("close"),"Download is not Collapse by default");
        click(downloadCollapseBtnElement);
        Assert.assertTrue(downloadCollapseBtnElement.getAttribute("class").contains("open"),"Failed to Download Office Collapse");
    }

    public void verifyDesktopTreeCheckbox() {

        //Verify default if checkbox are unchecked
        Assert.assertTrue(desktopCheckboxElement.getAttribute("class").contains("uncheck"),"Desktop is not unchecked by default");
        Assert.assertTrue(notesCheckboxElement.getAttribute("class").contains("uncheck"),"Notes is not unchecked by default");
        Assert.assertTrue(commandsCheckboxElement.getAttribute("class").contains("uncheck"),"Commands is not unchecked by default");

        //verify after Desktop checkbox is checked
        click(desktopCheckboxElement); //check desktop checkbox
        Assert.assertTrue(desktopCheckboxElement.getAttribute("class").contains("check"),"Unable to check Desktop checkbox");
        Assert.assertTrue(notesCheckboxElement.getAttribute("class").contains("check"),"Notes checkbox is not checked when Desktop checkbox is checked");
        Assert.assertTrue(commandsCheckboxElement.getAttribute("class").contains("check"),"Commands checkbox is not checked when Desktop checkbox is checked");

        //verify after Desktop checkbox is unchecked
        click(desktopCheckboxElement); //uncheck desktop checkbox
        Assert.assertTrue(desktopCheckboxElement.getAttribute("class").contains("uncheck"),"Unable to check Desktop checkbox");
        Assert.assertTrue(notesCheckboxElement.getAttribute("class").contains("uncheck"),"Notes checkbox is not checked when Desktop checkbox is checked");
        Assert.assertTrue(commandsCheckboxElement.getAttribute("class").contains("uncheck"),"Commands checkbox is not checked when Desktop checkbox is checked");

        //Check each checkbox under Desktop
        click(notesCheckboxElement);
        Assert.assertTrue(notesCheckboxElement.getAttribute("class").contains("check"),"Notes to check Desktop checkbox");
    }

}
