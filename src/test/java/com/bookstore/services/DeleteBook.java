package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class DeleteBook extends Globals {

    public void deleteBook(){

        Map<String,Object> map = new HashMap<>();
        map.put("isbn", isbnNumbers.get(0));
        map.put("userId", userId);

        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(map)
                .when()
                .log().all()
                .delete("BookStore/v1/Book");
    }

    public  void validateThatTheBookIsDeleted(){
        Assert.assertEquals(response.statusCode(),204);
    }
}
