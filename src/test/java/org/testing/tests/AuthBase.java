package org.testing.tests;

import org.junit.Before;
import org.testing.enity.SignInParams;
import org.testing.util.Settings;

public class AuthBase extends TestBase{
    private final String LOGIN = Settings.getlogin();
    private final String PASSWORD = Settings.getPassword();

    @Before
    public void login() throws InterruptedException {
        SignInParams signInParams = new SignInParams(LOGIN, PASSWORD);
        appManager.getLoginHelper().login(signInParams);
    }
}
