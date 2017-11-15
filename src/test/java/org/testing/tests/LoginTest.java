package org.testing.tests;

import org.junit.Assert;
import org.junit.Test;
import org.testing.enity.SignInParams;

public class LoginTest extends TestBase {

    private final String LOGIN = "azot273@gmail.com";
    private final String PASSWORD = "HzxU683J";
    private final String WRONG_PASSWORD = "123qwe";

    @Test
    public void loginWithValidData() throws InterruptedException {
        SignInParams signInParams = new SignInParams(LOGIN, PASSWORD);
        appManager.getLoginHelper().logout();
        appManager.getLoginHelper().login(signInParams);
        Assert.assertTrue(appManager.getLoginHelper().isLoggedIn(signInParams));
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
