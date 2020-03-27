package com.learn.test_cases;

import com.learn.base.BaseTest;
import com.learn.components.Products;
import com.learn.components.Profile;
import com.learn.factory.IFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TC_0002 extends BaseTest {

    private IFactory iFactory;

    public TC_0002() {
        this.iFactory = new IFactory();
    }

    @Test
    @DisplayName("TC-0002 - Edit profile functionality")
    public void verifyProfileUpdates() {
        Profile profile = Profile.builder().email("alanskaev22@github.com").address("123 test drive").address2("suite 1").city("java").phone("1234567890").country("United States").state("New jersey")
                        .zipCode("12345").build();
        Products products = Products.builder().profile(profile).build();
        iFactory.getFrontendUserBlock().login().fillProfileDetails(products).submitProfileChanges().verifyProfileDetailsUpdated(products);
    }
}
