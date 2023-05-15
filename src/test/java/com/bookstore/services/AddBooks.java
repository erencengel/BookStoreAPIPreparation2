package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;

public class AddBooks extends Globals {

    public void addBook(int count){
        for (int i = 0; i < count; i++) {

            String body = "{\n" +
                    "  \"userId\": \"" + userId + "\",\n" +
                    "  \"collectionOfIsbns\": [\n" +
                    "    {\n" +
                    "      \"isbn\": \"" + isbnNumbers.get(i) + "\"\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}";

            RestAssured
                    .given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .header("Authorization", "Bearer " + token)
                    .body(body)
                    .when().log().all()
                    .post("/BookStore/v1/Books")
                    .prettyPeek()
                    .then()
                    .statusCode(201)
                    .and()
                    .body("books.isbn[0]", Matchers.equalTo(isbnNumbers.get(i)));
        }
    }
}
