package com.demoqa.test.forms;

import com.demoqa.actions.FormsActions;
import com.demoqa.actions.HomepageActions;
import com.demoqa.base.TestUtilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestUtilities {

    @Test
//    @Parameters({"fname","lname", "email", "gender", "mobile", "dob", "subject", "hobbies", "picture", "currAdd", "state", "city"})
//    public void verifyPracticeForm(String fname, String lname, String email, String gender, String mobile, String dob, String subject, String hobbies, String picture, String currAdd, String state, String city) {
        public void verifyPracticeForm() {
        HomepageActions homepageActions = new HomepageActions(driver);
        homepageActions.openPage();

        FormsActions formsActions = homepageActions.clickFormsBtn();
        formsActions.verifyPracticeForm();

    }

}
