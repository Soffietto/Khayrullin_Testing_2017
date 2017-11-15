package org.testing.util;

public class PropertySetter {
    private static final String PROPERTY = "webdriver.gecko.driver";
    private static final String GECKODRIVER_PATH = "/Users/azathajrullin/Downloads/geckodriver";

    public static void setProperty() {
        System.setProperty(PROPERTY, GECKODRIVER_PATH);
    }

}
