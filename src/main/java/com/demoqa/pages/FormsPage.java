package com.demoqa.pages;

import com.demoqa.actions.BaseActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FormsPage extends BaseActions {

    public FormsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".left-pannel .element-group:nth-child(2)")
    protected WebElement formsGroupLocator;

    @FindBy(css = ".left-pannel .element-group:nth-child(2) .menu-list #item-0")
    protected WebElement formsMenuListPracticeFormLocator;

    @FindBy(css = ".practice-form-wrapper")
    protected WebElement practiceFormWrap;

    @FindBy(css = ".practice-form-wrapper h5")
    protected WebElement formTitle;

    @FindBy(id = "firstName")
    protected WebElement firstName;

    @FindBy(id = "lastName")
    protected WebElement lastName;

    @FindBy(id = "userEmail")
    protected WebElement email;

    //Gender Options
//        @FindBy(id = "gender-radio-1")
        @FindBy(css = ".custom-control:has(input[value='Male'])")
        protected WebElement genderMale;

//        @FindBy(id = "gender-radio-2")
        @FindBy(css = ".custom-control:has(input[value='Female'])")
        protected WebElement genderFemale;

//        @FindBy(id = "gender-radio-3")
        @FindBy(css = ".custom-control:has(input[value='Other'])")
        protected WebElement genderOther;

    @FindBy(id = "userNumber")
    protected WebElement mobileNum;

    @FindBy(id = "dateOfBirthInput")
    protected WebElement dobField;

    @FindBy(css = ".react-datepicker__month-container")
    protected WebElement datePickerCont;

    @FindBy(css = ".react-datepicker__month-select")
    protected WebElement dobMonth;

    @FindBy(css = ".react-datepicker__year-select")
    protected WebElement dobYear;

    @FindBy(css = ".react-datepicker__month")
    protected WebElement dobDayCont;

    @FindBy(css = ".react-datepicker__month .react-datepicker__day")
    protected List<WebElement> dobDay;

    @FindBy(id = "hobbiesWrapper")
    protected WebElement hobbiesCont;

    @FindBy(css = "input[id*='hobbies']")
    protected List<WebElement> hobbiesListCheckbox;

    @FindBy(css = "label[for*='hobbies']")
    protected List<WebElement> hobbiesListLabel;

    @FindBy(id = "uploadPicture")
    protected WebElement picUpload;

    @FindBy(id = "currentAddress")
    protected WebElement currAddress;

    @FindBy(id = "stateCity-wrapper")
    protected WebElement stateAndCityWrap;

    @FindBy(id = "state")
    protected WebElement state;

    @FindBy(id = "city")
    protected WebElement city;

    @FindBy(css = ".css-11unzgr")
    protected WebElement stateOrCityList;

    @FindBy(css = "div[id*='react-select-3-option']")
    protected List<WebElement> stateListOptions;

    @FindBy(css = "div[id*='react-select-4-option']")
    protected List<WebElement> cityListOptions;

    @FindBy(id = "submit")
    protected WebElement submitBtn;

    @FindBy(css = ".modal-content")
    protected WebElement submitFormModal;
}
