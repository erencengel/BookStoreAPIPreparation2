package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import java.util.List;

public class GetAllBooks extends Globals {

    public void getBooks(){
        response = RestAssured
                .given()
                .accept(ContentType.JSON)
                .when().log().all()
                .get("/BookStore/v1/Books").prettyPeek();
    }

    public void validateThatBooksAreListed(){
        JsonPath jsonPath = response.jsonPath();
        List<Object> list = jsonPath.getList("books.isbn");
        list.forEach(n -> Assert.assertNotNull(n));
        response.then().statusCode(200);
        isbnNumbers = jsonPath.getList("books.isbn");
    }
}
