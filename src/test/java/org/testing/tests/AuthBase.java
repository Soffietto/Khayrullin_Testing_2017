package org.testing.tests;

import org.junit.Before;
import org.testing.enity.SignInParams;

public class AuthBase extends TestBase{
    private final String LOGIN = "azot273@gmail.com";
    private final String PASSWORD = "HzxU683J";

    @Before
    public void login() throws InterruptedException {
        SignInParams signInParams = new SignInParams(LOGIN, PASSWORD);
        appManager.getLoginHelper().login(signInParams);
    }
}
