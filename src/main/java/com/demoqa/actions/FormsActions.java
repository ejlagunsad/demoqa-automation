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
        //Select subject - To follow
        String[] hobbies = {"Sports", "Reading", "Music"};
        selectHobbies(hobbies);
        uploadImg("HD1.jpg");
        type("Test Address", currAddress);
        selectStateAndCity();
        verifySubmitFormInfo(); //add to verify table

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
        click(dobField);
        Assert.assertTrue(awaitForElementVisibility(datePickerCont),"Date of Birth date picker is not displayed");
        selectDoBMonth("January");
        selectDoBYear();
        selectDoBDay();
    }

    protected void selectDoBMonth(String month) {
        click(dobMonth);
        Select dropdown = new Select(dobMonth);
        dropdown.selectByVisibleText(capitalizeFirstLetter(month));
    }

    protected void selectDoBYear() {
        click(dobYear);
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

    protected void selectHobbies(String[] hobbies) {
        Assert.assertTrue(awaitForElementVisibility(hobbiesCont), "Hobbies wrapper is not displayed");

        for (String hobby : hobbies) {

            boolean isHobbyFound = false;
            for(WebElement hobbyLabel : hobbiesListLabel) {
                if (hobby.equalsIgnoreCase(hobbyLabel.getText())) {
                    hobbyLabel.click();
                    isHobbyFound=true;
                    break;
                }
            }

            if(!isHobbyFound) {
                throw new Error(hobby + " is not on Hobbies Option");
            }
        }

    }

    protected void uploadImg(String fileName) {
        String filePath = System.getProperty("user.dir") + "//src//test//resources//img//" + fileName;
        type(filePath, picUpload);

        if (!picUpload.getAttribute("value").contains(fileName)) {
            throw new Error("Incorrect Uploaded Image");
        }
    }

    protected void selectStateAndCity() {
        Assert.assertTrue(awaitForElementVisibility(stateAndCityWrap), "State and City wrapper is not displayed");
        selectState();
        selectCity();
    }

    protected void selectState() {
        click(state);
        Assert.assertTrue(awaitForElementVisibility(stateOrCityList), "State List is not displayed");

        boolean onList = false;
        for(WebElement stateOption : stateListOptions) {
            if (stateOption.getText().equalsIgnoreCase("NCR")) {
                stateOption.click();
                onList = true;
                break;
            }
        }

        if(!onList) {
            throw new Error("Invalid State");
        }
    }

    protected void selectCity() {
        if (!city.isEnabled()) {
            throw new Error("City Dropdown field is disabled");
        }
        click(city);
        Assert.assertTrue(awaitForElementVisibility(stateOrCityList), "City List is not  displayed");

        boolean onList = false;
        for(WebElement cityOption : cityListOptions) {
            if (cityOption.getText().equalsIgnoreCase("Delhi")) {
                cityOption.click();
                onList = true;
                break;
            }
        }

        if(!onList) {
            throw new Error("Invalid City");
        }
    }

    private void verifySubmitFormInfo() {
        click(submitBtn);

        Assert.assertTrue(awaitForElementVisibility(submitFormModal), "Submitted form modal is not displayed");

    }
}