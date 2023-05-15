package com.bookstore.stepdefs;

import com.bookstore.services.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class BookStoreFlow_StepDefs {

    GetAllBooks getAllBooks = new GetAllBooks();
    AddNewUser addNewUser = new AddNewUser();
    GenerateToken generateToken = new GenerateToken();
    Authorization authorization = new Authorization();
    AddBooks addBooks = new AddBooks();
    GetUser getUser = new GetUser();
    UpdateBook updateBook = new UpdateBook();
    DeleteBook deleteBook = new DeleteBook();

    @Given("Get all books")
    public void get_all_books() {
        getAllBooks.getBooks();
    }

    @Then("Validate that books are listed")
    public void validate_that_books_are_listed() {
        getAllBooks.validateThatBooksAreListed();
    }

    @Given("Add new user")
    public void add_new_user() {
        addNewUser.addNewUser();
    }

    @Then("Validate that user is created")
    public void validate_that_user_is_created() {
        addNewUser.validateUserIsCreated();
    }

    @Given("Create Token")
    public void create_Token() {
        generateToken.generateToken();
    }

    @Then("Validate token is created")
    public void validate_token_is_created() {
        generateToken.validateTokenIsCreated();
    }

    @Given("Authorize user")
    public void authorize_user() {
        authorization.authorizeUser();
    }

    @Then("Validate that user is authorized")
    public void validate_that_user_is_authorized() {
        authorization.validateUserIsAuthorized();
    }

    @Then("Add {int} books to the user and verify that books are added")
    public void addBooksToTheUserAndVerifyThatBooksAreAdded(int arg0) {
        addBooks.addBook(arg0);
    }

    @Given("Get User Information")
    public void get_User_Information() {
        getUser.getUserInformation();
    }

    @Then("Validate that user information is as expected - {int}")
    public void validateThatUserInformationIsAsExpected(int arg0) {
        getUser.validateUserInformation(arg0);
    }

    @Given("Update Book")
    public void update_Book() {
        updateBook.updateFirstBook();
    }

    @Then("Validate that the book is updated")
    public void validateThatTheBookIsUpdated() {
        updateBook.validateTheBookIsUpdated();
    }

    @Given("Delete one of the book")
    public void delete_one_of_the_book() {
        deleteBook.deleteBook();
    }

    @Then("Validate that the book is deleted")
    public void validate_that_the_book_is_deleted() {
        deleteBook.validateThatTheBookIsDeleted();
    }
}
