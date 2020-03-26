package com.learn.modules.frontend_user;


import com.learn.components.Products;

public interface IFrontendUser {

    public IFrontendUser login();

    public IFrontendUser fillProfileDetails(Products products);

    public IFrontendUser submitProfileChanges();

    public IFrontendUser verifyProfileDetailsUpdated(Products products);
}
