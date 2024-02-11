package com.demoqa.actions;

import com.demoqa.pages.FormsPage;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class FormsActions extends FormsPage {

    public FormsActions(WebDriver driver) {
        super(driver);
    }

    String expectedRedirectionUrl = "https://demoqa.com/forms";

    protected void verifyFormsSideNav() {
        Assert.assertEquals(getCurrentUrl(),expectedRedirectionUrl, "Redirect to incorrect page");
        Assert.assertTrue(awaitForElementVisibility(formsGroupLocator), "Forms groups is not available on Left Panel");
    }

    public void verifyPracticeForm() {
        verifyFormsSideNav();
        Assert.assertTrue(awaitForElementVisibility(formsMenuListPracticeFormLocator), "Forms Practice form is not available on Left Panel");
        click(formsMenuListPracticeFormLocator);

        Assert.assertTrue(awaitForElementVisibility(practiceFormWrap), "Practice Form section is not displayed");
        Assert.assertTrue(formTitle.getText().contains("Student Registration Form"), "Form title is not correct");
        type("fname", firstName);
        type("lname", lastName);
        type("test@test.com", email);
        selectGender("male");
        type("1234567890", mobileNum);
        selectDoB();

        System.out.println("test");
    }

    protected void selectGender(String gender) {
        Assert.assertTrue(gender.equalsIgnoreCase("male") ||
                        gender.equalsIgnoreCase("female") ||
                        gender.equalsIgnoreCase("both")
                        , "Invalid Gender");

        if (gender.equalsIgnoreCase("male")) {
            genderMale.click();
        } else if (gender.equalsIgnoreCase("female")) {
            genderFemale.click();
        } else if (gender.equalsIgnoreCase("both")) {
            genderOther.click();
        }
    }

    protected void selectDoB() {
        dobField.click();
        Assert.assertTrue(awaitForElementVisibility(datePickerCont),"Date of Birth date picker is not displayed");
        selectDoBMonth(5);
        selectDoBYear();
        selectDoBDay();
    }

    protected void selectDoBMonth(int month) {
        dobMonth.click();
        Select dropdown = new Select(dobMonth);
//        dropdown.selectByIndex(month);
        String test = "january";
        dropdown.selectByVisibleText(capitalizeFirstLetter(test));
    }

    protected void selectDoBYear() {
        dobYear.click();
        Select dropdown = new Select(dobYear);
        List<WebElement> years = dropdown.getOptions();

        boolean onList = false;
        for(WebElement year : years) {
           if (year.getText().equalsIgnoreCase("1990")) {
               onList = true;
               break;
           }
        }

        if(onList) {
            dropdown.selectByVisibleText("1990");
        } else {
            throw new Error("Invalid Year");
        }
    }

    protected void selectDoBDay() {
        Assert.assertTrue(awaitForElementVisibility(dobDayCont), "Date Picker day container is not displayed");
        scrollToElement(dobDayCont);

        List<WebElement> days = dobDay;

        boolean isSelected = false;
        for(WebElement day : days) {
            if (day.getText().equals("31") && !day.getAttribute("class").contains("outside-month")) {
                day.click();
                isSelected = true;
                break;
            }
        }

        if(!isSelected) {
            throw new Error("Invalid Year");
        }

    }









}
