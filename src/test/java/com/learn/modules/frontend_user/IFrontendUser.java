package com.learn.modules.frontend_user;


import com.learn.components.*;

public interface IFrontendUser {

    IFrontendUser login();

    IFrontendUser fillProfileDetails(Products products);

    IFrontendUser submitProfileChanges();

    IFrontendUser verifyProfileDetailsUpdated(Products products);
}
