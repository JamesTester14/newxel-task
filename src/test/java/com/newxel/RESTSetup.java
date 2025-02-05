package com.newxel;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class RESTSetup {
    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://reqres.in/api";
    }
}
