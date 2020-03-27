package com.learn.pages.frontend;


import com.learn.components.Products;
import com.learn.components.Profile;
import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Methods which are used to create reusbale methods in FrontendUser class
 */

public class AccountPage {


    private static String myProfileXpath = "//a[contains(@href, 'profile')]";
    private static String firstNameXpath = "//form[@id='profilefrm']//input[@name='firstname']";
    private static String lastNameXpath = "//form[@id='profilefrm']//input[@name='lastname']";
    private static String emailXpath = "//form[@id='profilefrm']//input[@name='email']";
    private static String addressXpath = "//form[@id='profilefrm']//input[@name='address1']";
    private static String address2Xpath = "//form[@id='profilefrm']//input[@name='address2']";
    private static String cityXpath = "//form[@id='profilefrm']//input[@name='city']";
    private static String stateXpath = "//form[@id='profilefrm']//input[@name='state']";
    private static String zipCodeXpath = "//form[@id='profilefrm']//input[@name='zip']";
    private static String selectCountryXpath = "//form[@id='profilefrm']//a[@class='chosen-single']";
    private static String typeCountryXpath = "//form[@id='profilefrm']//input[@class='chosen-search-input']";
    /*
     * $x("//form[@id='profilefrm']//a[@class='chosen-single']").click(); $x("//form[@id='profilefrm']//input[@class='chosen-search-input']").sendKeys("United States"); $x("//form[@id='profilefrm']//input[@class='chosen-search-input']").pressEnter();
     */
    // private final String COUNTRY = "country";
    private static String phoneXpath = "//form[@id='profilefrm']//input[@name='phone']";
    private static String submitBtnXpath = "//button[contains(@class, 'updateprofile')]";


    @Step("Navigate to My Profile")
    public void clickOnMyProfile() {
        $x(myProfileXpath).click();
    }

    @Step("Fill product details")
    public void fillAccountDetails(Products products) {

        if (products.getProfile().getEmail() != null) {
            sleep(1000);
            $x(emailXpath).clear();
            $x(emailXpath).sendKeys(products.getProfile().getEmail());
        }
        if (products.getProfile().getAddress() != null) {
            sleep(1000);
            $x(addressXpath).clear();
            $x(addressXpath).sendKeys(products.getProfile().getAddress());
        }
        if (products.getProfile().getAddress2() != null) {
            sleep(1000);
            $x(address2Xpath).clear();
            $x(address2Xpath).sendKeys(products.getProfile().getAddress2());
        }
        if (products.getProfile().getCity() != null) {
            sleep(1000);
            $x(cityXpath).clear();
            $x(cityXpath).sendKeys(products.getProfile().getCity());
        }
        if (products.getProfile().getState() != null) {
            sleep(1000);
            $x(stateXpath).clear();
            $x(stateXpath).sendKeys(products.getProfile().getState());
        }
        if (products.getProfile().getZipCode() != null) {
            sleep(1000);
            $x(zipCodeXpath).clear();
            $x(zipCodeXpath).sendKeys(products.getProfile().getZipCode());
        }
        if (products.getProfile().getCountry() != null) {
            sleep(1000);
            $x(selectCountryXpath).click();
            sleep(500);
            $x(typeCountryXpath).sendKeys(products.getProfile().getCountry());
            $x(typeCountryXpath).pressEnter();
        }
        if (products.getProfile().getPhone() != null) {
            sleep(1000);
            $x(phoneXpath).clear();
            $x(phoneXpath).sendKeys(products.getProfile().getPhone());
        }
    }

    @Step("Submit profile information to be updated")
    public void submitProfileDetailsForUpdate() {
        sleep(500);
        $x(submitBtnXpath).click();
    }

    @Step("Verify profile details have been updated")
    public Profile verifyUpdates() {
        Profile updatedProfile = new Profile();
        sleep(500);
        updatedProfile.setEmail(StringUtils.normalizeSpace($x(emailXpath).getValue()));
        sleep(500);
        updatedProfile.setAddress(StringUtils.normalizeSpace($x(addressXpath).getValue()));
        sleep(500);
        updatedProfile.setAddress2(StringUtils.normalizeSpace($x(address2Xpath).getValue()));
        sleep(500);
        updatedProfile.setState(StringUtils.normalizeSpace($x(stateXpath).getValue()));
        sleep(500);
        updatedProfile.setZipCode(StringUtils.normalizeSpace($x(zipCodeXpath).getValue()));
        sleep(500);
        updatedProfile.setPhone(StringUtils.normalizeSpace($x(phoneXpath).getValue()));
        sleep(500);
        return updatedProfile;
    }

}
