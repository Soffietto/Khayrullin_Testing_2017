package org.testing.tests;

import org.junit.After;
import org.junit.Before;
import org.testing.AppManager;
import org.testing.enity.SignInParams;

import static org.junit.Assert.fail;

public class TestBase {

    public AppManager appManager;
    private final String LOGIN = "azot273@gmail.com";
    private final String PASSWORD = "HzxU683J";

    @Before
    public void setUp() throws Exception {
        appManager = new AppManager();
        appManager.getNavigateHelper().getLoginPage();
    }

    @After
    public void tearDown() throws Exception {
        appManager.getDriver().quit();
        String verificationErrorString = appManager.getVerificationErrors().toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}