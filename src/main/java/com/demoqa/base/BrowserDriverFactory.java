package com.demoqa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDriverFactory {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private String browser;

    public BrowserDriverFactory(String browser) {
        this.browser = browser.toLowerCase();
    }

    public WebDriver createDriver() {
        switch (browser) {
            case "firefox":
                driver.set(new FirefoxDriver());
                break;
            case "chrome":
            default:
//                System.setProperty("webdriver.chrome.driver", "C:/Automation/Resources/WebDriver/chromedriver.exe");
                driver.set(new ChromeDriver());
                break;
        }
        return driver.get();
    }

}
