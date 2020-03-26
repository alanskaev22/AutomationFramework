package com.learn.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.learn.base.BaseTest;
import io.qameta.allure.Step;
import io.vavr.control.Try;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class Login extends BaseTest {
    private static String usernameXpath = "//input[@type='password']/preceding::input";
    private static String passwordXpath = "//input[@type='password']";
    private static String loginBtn = "//button[@type='submit']";

    private final String emailKey = "username";
    private final String passwordKey = "password";
    private final String urlKey = "URL";

    @Step("Login into application with valid credentials")
    public void LogIntoApp(Roles role) {
        Map<String, String> map = ReadCredentials.getCredentials(role);
        String username = map.get(emailKey);
        String password = map.get(passwordKey);
        String url = map.get(urlKey);

        open(url);
        WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Selenide.refresh();
        $x(usernameXpath).sendKeys(username);
        $x(passwordXpath).sendKeys(password);
        $x(loginBtn).click();
        Try.run(() -> Thread.sleep(3000));

        String currentURL = WebDriverRunner.url();
        assertThat(currentURL).as("FAILED LOGIN").containsIgnoringCase("account");
    }
}
