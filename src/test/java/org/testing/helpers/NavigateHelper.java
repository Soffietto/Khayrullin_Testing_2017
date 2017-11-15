package org.testing.helpers;

import org.testing.AppManager;

public class NavigateHelper extends HelperBase {

    private String baseUrl;

    public NavigateHelper(AppManager appManager, String baseUrl) {
        super(appManager);
        this.baseUrl = baseUrl;
    }

    public void getLoginPage() {
        appManager.getDriver().get(baseUrl + "/sign_in");
    }


}
