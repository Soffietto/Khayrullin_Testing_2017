package org.testing.tests;

import org.junit.Assert;
import org.junit.Test;
import org.testing.enity.SignInParams;
import org.testing.util.Settings;

public class LoginTest extends TestBase {

    private final String LOGIN = Settings.getlogin();
    private final String PASSWORD = Settings.getPassword();
    private final String WRONG_PASSWORD = "123qwe";

    @Test
    public void loginWithValidData() throws InterruptedException {
        SignInParams signInParams = new SignInParams(LOGIN, PASSWORD);
        appManager.getLoginHelper().logout();
        appManager.getLoginHelper().login(signInParams);
        boolean isLoggedIn = appManager.getLoginHelper().isLoggedIn(signInParams);
        Assert.assertTrue(isLoggedIn);
    }

    @Test
    public void loginWithInvalidData() throws InterruptedException {
        SignInParams signInParams = new SignInParams(LOGIN, WRONG_PASSWORD);
        appManager.getLoginHelper().logout();
        appManager.getLoginHelper().login(signInParams);
        boolean isValid = appManager.getLoginHelper().isLoggedIn(signInParams);
        Assert.assertFalse(isValid);
    }
}
