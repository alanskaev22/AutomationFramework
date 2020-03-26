package com.learn.pages;

import com.learn.configurations.Config;

import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import static io.vavr.API.*;

public class ReadCredentials {

    public static Map<String, String> getCredentials(Roles role) {
        Map<String, String> map = new TreeMap<>();
        String userName = "username";
        String pwd = "password";
        String address = "URL";
        return Match(role).of(Case($(Roles.FRONTEND_USER), () -> {
            map.put(userName, Credentials.FRONTEND_USER_EMAIL);
            map.put(pwd, Credentials.FRONTEND_USER_PASSWORD);
            map.put(address, Credentials.FRONTEND_URL);
            return map;
        }), Case($(Roles.BACKEND_ADMIN), () -> {
            map.put(userName, Credentials.BACKEND_USER_EMAIL);
            map.put(pwd, Credentials.BACKEND_USER_PASSWORD);
            map.put(address, Credentials.BACKEND_URL);
            return map;
        }));
    }

    static class Credentials {
        private static Properties properties = Config.read();

        // Front-end URL
        static final String FRONTEND_URL = properties.getProperty("frontend_phptravel_url");
        // Backend URL
        static final String BACKEND_URL = properties.getProperty("backend_phptravel_url");
        // Front-end User
        static final String FRONTEND_USER_EMAIL = properties.getProperty("frontend_phptravel_email");
        static final String FRONTEND_USER_PASSWORD = properties.getProperty("frontend_phptravel_password");
        // Backend Admin
        static final String BACKEND_USER_EMAIL = properties.getProperty("backend_phptravel_email");
        static final String BACKEND_USER_PASSWORD = properties.getProperty("backend_phptravel_password");
    }
}
