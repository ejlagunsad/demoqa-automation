package com.demoqa.actions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class BaseActions {

    protected WebDriver driver;

    public BaseActions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void openUrl(String url) {
        driver.get(url);
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected void click(By locator) {
        waitForVisibility(locator, Duration.ofSeconds(5));
        find(locator).click();
    }

    protected void click(WebElement element) {
        waitForVisibility(element, Duration.ofSeconds(5));
        element.click();
    }

    protected void type(String text, By locator) {
        waitForVisibility(locator, Duration.ofSeconds(5));
        find(locator).sendKeys(text);
    }

    public static String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    protected String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    protected void type(String text, WebElement element) {
        waitForVisibility(element, Duration.ofSeconds(5));
        element.sendKeys(text);
    }

    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected String getCurrentPageTitle() {
        return driver.getTitle();
    }

    protected String getPageSource() {
        return driver.getPageSource();
    }

    private void waitFor(ExpectedCondition<WebElement> condition, Duration seconds) {
        seconds = seconds != null ? seconds : Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(condition);
    }

    //For using Locator
    protected void waitForVisibility(By locator, Duration... seconds) {
        int attempts = 0;
        while(attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        (seconds.length > 0 ? seconds[0] : null));
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
    }

    //For using WebElement
    protected void waitForVisibility(WebElement element, Duration... seconds) {
        int attempts = 0;
        while(attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOf(element),
                        (seconds.length > 0 ? seconds[0] : null));
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
    }

    protected Boolean awaitForElementVisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            wait.ignoring (NoSuchElementException.class).pollingEvery (Duration.ofSeconds (5)).until (ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    protected Boolean awaitForElementVisibility(WebElement element) {

        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(30));
        try {
            wait.ignoring (NoSuchElementException.class).pollingEvery (Duration.ofSeconds (5)).until (ExpectedConditions.visibilityOf (element));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    protected Boolean awaitForElementInVisibility(WebElement element) {

        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(30));
        try {
            wait.ignoring (NoSuchElementException.class).pollingEvery (Duration.ofSeconds (5)).until (ExpectedConditions.invisibilityOf (element));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    protected boolean awaitAlertVisibility(long duration) {
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(duration));
        try {
            wait.ignoring (NoSuchElementException.class).pollingEvery (Duration.ofSeconds (5)).until (ExpectedConditions.alertIsPresent());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    protected void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //Alert Actions
    protected Alert switchToAlert() {
        return driver.switchTo().alert();
    }

    protected String getAlertText() {
        Alert alert = switchToAlert();
        return alert.getText();
    }

    protected void clickAlertAcceptBtn() {
        Alert alert = switchToAlert();
        alert.accept();
    }

    protected void clickAlertDismissBtn() {
        Alert alert = switchToAlert();
        alert.dismiss();
    }

    protected void inputTextOnAlertField(String text) {
        Alert alert = switchToAlert();
        alert.sendKeys(text);
    }

    // Windows Actions
    protected void switchToWindowWithTitle(String pageTitle) {
        String firstWindow = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> windowsIterator = allWindows.iterator();

        while(windowsIterator.hasNext()) {
            String windowHandle = windowsIterator.next();
            if(!windowHandle.equals(firstWindow)) {
                driver.switchTo().window(windowHandle);
                if (getCurrentPageTitle().equals(pageTitle)) {
                    break;
                }
            }
        }
    }

    protected void switchToIframe(WebElement element) {
        driver.switchTo().frame(element);
    }

    protected void switchToIframe(By locator) {
        driver.switchTo().frame(driver.findElement(locator));
    }

    protected void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

}
