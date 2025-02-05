package com.newxel.pageObject.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class TokenHandler {
    private static String token;

    public static String authenticateUser(String email, String password) {
        Response response = given()
                .contentType(ContentType.JSON)
                .body(String.format("{\"email\": \"%s\", \"password\": \"%s\"}", email, password))
                .when()
                .post("/login");

        response.then().statusCode(200);
        token = response.jsonPath().getString("token");
        Assert.assertNotNull(token, "Token is null");
        return token;
    }

}
