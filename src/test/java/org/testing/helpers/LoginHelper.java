package org.testing.helpers;

import org.openqa.selenium.By;
import org.testing.AppManager;
import org.testing.bases.HelperBase;
import org.testing.enity.SignInParams;

public class LoginHelper extends HelperBase {

    public LoginHelper(AppManager appManager) {
        super(appManager);
    }

    public void login(SignInParams signInParams) throws InterruptedException {
        String login = signInParams.getLogin();
        String password = signInParams.getPassword();
        if (isLoggedIn()) {
            if (isLoggedIn(signInParams)) {
                return;
            }
            logout();
        }
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(login);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Sing in']")).click();
        sleep();
    }

    public void logout() throws InterruptedException {
        if (isLoggedIn()) {
            driver.findElement(By.linkText("Logout")).click();
        }
    }

    public boolean isLoggedIn() {
        return isElementPresent(By.cssSelector("a[href='/logout']"));
    }

    public boolean isLoggedIn(SignInParams signInParams) {
        boolean isLoggedin = isLoggedIn();
        return isLoggedin && signInParams.getLogin().equals(getLoggedUserName());
    }

    public String getLoggedUserName() {
        String text = driver.findElement(By.id("login_data")).getText();
        return text;
    }
}
