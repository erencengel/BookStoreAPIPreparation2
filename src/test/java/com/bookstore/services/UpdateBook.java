package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class UpdateBook extends Globals {

    public void updateFirstBook(){

        Map<String,Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("isbn", isbnNumbers.get(3));

        response = RestAssured
                .given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(map)
                .when()
                .log().all()
                .put("/BookStore/v1/Books/" + isbnNumbers.get(2))
                .prettyPeek();
    }

    public void validateTheBookIsUpdated(){
        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(response.path("userId"),userId);
        Assert.assertEquals(response.path("username"), userName);
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertTrue(jsonPath.getList("books.isbn").stream().anyMatch(n -> n.equals(isbnNumbers.get(3))));
    }
}
