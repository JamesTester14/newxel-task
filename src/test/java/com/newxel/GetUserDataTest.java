package com.newxel;

import com.newxel.pageObject.api.TokenHandler;
import com.newxel.pageObject.api.UserService;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetUserDataTest extends RESTSetup{
    private String token;
    private UserService userService;

    @BeforeClass
    public void getToken() {
        token = TokenHandler.authenticateUser("eve.holt@reqres.in", "cityslicka");
        userService = new UserService(token);
    }

    @Test(priority = 1)
    @Description("Check user exists")
    public void testFindUser() {
        userService.findFirstUser();
    }

    @Test(priority = 2, dependsOnMethods = "testFindUser")
    @Description("Assert user has correct ID")
    public void testVerifyUserDetails() {
        userService.verifyUserDetails();
    }
}
