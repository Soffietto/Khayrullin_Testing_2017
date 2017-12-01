package org.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testing.helpers.CommentHelper;
import org.testing.helpers.LoginHelper;
import org.testing.helpers.NavigateHelper;
import org.testing.helpers.PostHelper;
import org.testing.util.PropertySetter;
import org.testing.util.Settings;

public class AppManager {

    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();
    private CommentHelper commentHelper;
    private PostHelper postHelper;
    private LoginHelper loginHelper;
    private NavigateHelper navigateHelper;

    private static ThreadLocal<AppManager> app = new ThreadLocal<AppManager>();

    private AppManager() {
        PropertySetter.setProperty();
        driver = new FirefoxDriver();
        baseUrl = Settings.getBaseUrl();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        commentHelper = new CommentHelper(this);
        postHelper = new PostHelper(this);
        loginHelper = new LoginHelper(this);
        navigateHelper = new NavigateHelper(this, baseUrl);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public StringBuffer getVerificationErrors() {
        return verificationErrors;
    }

    public CommentHelper getCommentHelper() {
        return commentHelper;
    }

    public PostHelper getPostHelper() {
        return postHelper;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public NavigateHelper getNavigateHelper() {
        return navigateHelper;
    }

    public static AppManager getInstance() {
        if(app.get() == null) {
            AppManager appManager = new AppManager();
            appManager.getNavigateHelper().getLoginPage();
            app.set(appManager);
        }
        return app.get();
    }
}
