package com.newxel.pageObject.api;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserService {
    private final String token;
    private int userId;

    public UserService(String token) {
        this.token = token;
    }

    @Step
    public int findFirstUser() {
        int page = 1;
        boolean userFound = false;

        while (!userFound) {
            Response response = given()
                    .header("Authorization", "Bearer " + token)
                    .when()
                    .get("/users?page=" + page);

            response.then().statusCode(200);
            List<Integer> userIds = response.jsonPath().getList("data.id");

            if (!userIds.isEmpty()) {
                userId = userIds.get(0);
                userFound = true;
            } else {
                page++;
                if (page > 3) {
                    Assert.fail("User is absent");
                }
            }
        }
        return userId;
    }

    @Step
    public void verifyUserDetails() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/users/" + userId);

        response.then().statusCode(200);
        int userID = response.jsonPath().getInt("data.id");
        Assert.assertEquals(userID, userId, "User ID doesn't match the expected ID");
    }
}
