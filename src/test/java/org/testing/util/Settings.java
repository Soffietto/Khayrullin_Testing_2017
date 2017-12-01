package org.testing.util;

import java.io.*;
import java.util.Properties;

public class Settings {
    private static String baseUrl;
    private static String login;
    private static String password;
    private static Properties properties;
    private static InputStream inputStream = null;
    private static final String FILE_NAME = "src/test/resources/test.properties";

    static {
        try {
            inputStream = new FileInputStream(FILE_NAME);
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBaseUrl() {
        if(baseUrl == null) {
            baseUrl = properties.getProperty("base.url");
        }
        return baseUrl;
    }

    public static String getlogin() {
        if(login == null) {
            login = properties.getProperty("login");
        }
        return login;
    }

    public static String getPassword() {
        if(password == null) {
            password = properties.getProperty("password");
        }
        return password;
    }
}
