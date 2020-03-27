package com.learn.test_cases;

import com.learn.factory.IFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TC_0001 {
    private IFactory iFactory;

    public TC_0001() {
        this.iFactory = new IFactory();
    }

    @Test
    @DisplayName("TC-0001 - Login functionality")
    public void loginToFrontendApp() {

        iFactory.getFrontendUserModule().login();
    }
}
