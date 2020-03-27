package com.learn.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.learn.configurations.Config;
import com.learn.listeners.WebDriverListener;
import com.learn.logger.Logging;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.util.Properties;

public class BaseTest implements Logging {
    private static Properties properties;

    @BeforeAll
    public static void setupAll() {
        properties = Config.read();
        WebDriverManager.chromedriver().version("79.0.3945.36");
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebDriverRunner.addListener(new WebDriverListener());
        Configuration.startMaximized = true;
        Configuration.browser = properties.getProperty("browser");
        Configuration.headless = Boolean.parseBoolean(properties.getProperty("headless"));
        Configuration.timeout = 30000;
    }

    @AfterEach
    public void tearDown() {
        SelenideLogger.removeAllListeners();
    }

    @AfterAll
    public static void tearDownAll() {
        WebDriverRunner.getWebDriver().close();
    }
}
