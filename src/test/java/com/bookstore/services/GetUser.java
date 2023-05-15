package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class GetUser extends Globals {

    public void getUserInformation(){
        response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when().log().all()
                .get("/Account/v1/User/" + userId)
                .prettyPeek();
    }

    public void validateUserInformation(int number){
        JsonPath jsonPath = response.jsonPath();
        List<Integer> list = jsonPath.getList("books.isbn");

        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.path("userId"), userId);
        Assert.assertEquals(response.path("username"), userName);
        Assert.assertEquals(list, isbnNumbers.stream().limit(number).collect(Collectors.toList()));
    }

}
