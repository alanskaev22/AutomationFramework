package com.learn.listeners;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.learn.logger.Logging;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

import static io.vavr.control.Try.run;

public class WebDriverListener implements WebDriverEventListener, Logging {
    @Override
    public void beforeAlertAccept(WebDriver webDriver) {
        run(() -> Thread.sleep(1000));
    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {
        run(() -> Thread.sleep(1000));
    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {
    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {
    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
        log("Navigating to -> " + s);
    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        log("Navigated tp -> " + s);
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {
    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {
    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {
    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        Wait wait = new FluentWait<>(WebDriverRunner.getWebDriver()).withTimeout(Duration.ofMillis(15000)).pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);
        log("Looking for element -> " + by);
        wait.until((Function<WebDriver, WebElement>) driver1 -> Selenide.getFocusedElement());
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        log("Element Found -> " + by);
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        log("Clicking on -> " + webElement.getText());
        run(() -> Thread.sleep(1000));
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        log("Clicked on -> " + webElement.getText());
        run(() -> Thread.sleep(1000));
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {
    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {
    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {
    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {
    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
        log("Exception occured -> " + throwable);
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {
        log("Screenshot taken ->" + x);
    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {
    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {
        log("Text retrieved -> " + s);
        run(() -> Thread.sleep(1000));
    }
}
