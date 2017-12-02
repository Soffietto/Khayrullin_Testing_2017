package org.testing;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.testing.tests.CommentTest;
import org.testing.tests.LoginTest;
import org.testing.tests.PostTest;
import org.testing.bases.TestBase;

@RunWith(Suite.class)
@Suite.SuiteClasses({LoginTest.class, CommentTest.class, PostTest.class})
public class AllTestSuit extends TestBase {

    @AfterClass
    public static void quit() {
        AppManager.getInstance().getDriver().quit();
    }
}
