package org.testing.helpers;

import org.testing.AppManager;
import org.testing.util.Settings;

public class NavigateHelper extends HelperBase {

    private String baseUrl = Settings.getBaseUrl();

    public NavigateHelper(AppManager appManager, String baseUrl) {
        super(appManager);
        this.baseUrl = baseUrl;
    }

    public void getLoginPage() {
        appManager.getDriver().get(baseUrl + "/sign_in");
    }


}
