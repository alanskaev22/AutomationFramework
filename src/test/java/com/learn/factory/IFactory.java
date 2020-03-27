package com.learn.factory;


import com.learn.modules.frontend_user.FrontendUser;
import com.learn.modules.frontend_user.IFrontendUser;

public class IFactory {

    private IFrontendUser iFrontendUser;

    public IFactory() {
        this.iFrontendUser = new FrontendUser();
    }

    public IFrontendUser getFrontendUserModule() {
        return iFrontendUser;
    }
}
