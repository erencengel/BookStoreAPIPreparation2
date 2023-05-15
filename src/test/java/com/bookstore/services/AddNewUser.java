package com.bookstore.services;

import com.bookstore.utilities.Globals;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class AddNewUser extends Globals {

    Faker faker = new Faker();

    public void addNewUser(){
        userName = faker.name().fullName();
        password = "Ab!.1" + faker.internet().password(8,16);
        Map<String,Object> map = new HashMap<>();
        map.put("userName",userName);
        map.put("password",password);
        response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(map)
                .when().log().all()
                .post("/Account/v1/User")
                .prettyPeek();
        userId = response.path("userID");
    }

    public void validateUserIsCreated(){
        Assert.assertNotNull(response.path("userID"));
        Assert.assertEquals(userName,response.path("username"));
        response.then().statusCode(201);
    }
}
