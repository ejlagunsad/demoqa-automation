package com.demoqa.base;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;
    protected Logger log;

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(String browser) {
        BrowserDriverFactory factory = new BrowserDriverFactory(browser);
        driver = factory.createDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }

}