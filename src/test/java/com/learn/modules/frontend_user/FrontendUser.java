package com.learn.modules.frontend_user;


import com.learn.components.Products;
import com.learn.components.Profile;
import com.learn.logger.Logging;
import com.learn.pages.Login;
import com.learn.pages.Roles;
import com.learn.pages.frontend.AccountPage;

import static org.assertj.core.api.Assertions.assertThat;

/** Substeps which can be use together in test case to build actions */


public class FrontendUser implements IFrontendUser, Logging {

    private AccountPage accountPage = new AccountPage();

    public IFrontendUser login() {
        log("Logging in as a -> " + Roles.FRONTEND_USER);
        Login login = new Login();
        login.LogIntoApp(Roles.FRONTEND_USER);
        return this;
    }

    public IFrontendUser fillProfileDetails(Products products) {
        log("FIll profile details on account page");
        accountPage.clickOnMyProfile();
        accountPage.fillAccountDetails(products);
        return this;
    }

    public IFrontendUser submitProfileChanges() {
        log("Submit profile changes on account page");
        accountPage.submitProfileDetailsForUpdate();
        return this;
    }

    public IFrontendUser verifyProfileDetailsUpdated(Products products) {
        Profile updatedProfile = accountPage.verifyUpdates();
        accountPage.clickOnMyProfile();
        assertThat(products.getProfile().getEmail().toLowerCase()).as("Verifying email was updated").isEqualToIgnoringWhitespace(updatedProfile.getEmail().toLowerCase());
        assertThat(products.getProfile().getAddress()).as("Verifying address was updated").isEqualToIgnoringWhitespace(updatedProfile.getAddress());
        assertThat(products.getProfile().getAddress2()).as("Verifying address2 was updated").isEqualToIgnoringWhitespace(updatedProfile.getAddress2());
        assertThat(products.getProfile().getCity()).as("Verifying city was updated").isEqualToIgnoringWhitespace(updatedProfile.getCity());
        assertThat(products.getProfile().getPhone()).as("Verifying phone was updated").isEqualToIgnoringWhitespace(updatedProfile.getPhone());
        assertThat(products.getProfile().getState()).as("Verifying state was updated").isEqualToIgnoringWhitespace(updatedProfile.getState());
        assertThat(products.getProfile().getZipCode()).as("Verifying zip code was updated").isEqualToIgnoringWhitespace(updatedProfile.getZipCode());
        return this;
    }
}
