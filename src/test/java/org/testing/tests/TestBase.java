package org.testing.tests;

import org.junit.After;
import org.junit.Before;
import org.testing.AppManager;
import org.testing.enity.SignInParams;

import static org.junit.Assert.fail;

public class TestBase {

    public AppManager appManager;

    @Before
    public void setUp() throws Exception {
        appManager = AppManager.getInstance();
        appManager.getNavigateHelper().getLoginPage();
    }

    @After
    public void tearDown() throws Exception {
        String verificationErrorString = appManager.getVerificationErrors().toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}