package org.testing.helpers;

import org.openqa.selenium.*;
import org.testing.AppManager;

public class HelperBase {

    public WebDriver driver;
    public AppManager appManager;
    private boolean acceptNextAlert = true;

    public HelperBase(AppManager appManager) {
        this.appManager = appManager;
        this.driver = appManager.getDriver();
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getBaseUrl() {
        return appManager.getBaseUrl();
    }

    public void sleep() throws InterruptedException {
        Thread.sleep(1000);
    }
}
