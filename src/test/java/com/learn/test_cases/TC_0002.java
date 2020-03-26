package com.learn.test_cases;

import com.learn.base.BaseTest;
import com.learn.factory.IFactory;
import org.junit.jupiter.api.Test;

public class TC_0002 extends BaseTest {

    private IFactory iFactory;

    public TC_0002(){
        this.iFactory = new IFactory();
    }
    @Test
    public void test2(){
    System.out.println("TEST 2");

        iFactory.getFrontendUserBlock().login();
    }
}
