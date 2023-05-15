@bookStoreFlow
Feature: BookStore Circle

  @getAllBooks
  #Get All Books
  Scenario: Scenario-1
    Given Get all books
    Then Validate that books are listed

  @addNewUser
  #Add New User
  Scenario: Scenario-2
    Given Add new user
    Then Validate that user is created

  @generateToken
  #Generate Token
  Scenario: Scenario-3
    Given Create Token
    Then Validate token is created

  @authorizeUser
  #Authorize
  Scenario: Scenario-4
    Given Authorize user
    Then Validate that user is authorized

  @addNewBook
  #Add New Book
  Scenario: Scenario-5
    Then Add 3 books to the user and verify that books are added

  @getUserInfo
  #Get User Information
  Scenario:  Scenario-6
    Given Get User Information
    Then Validate that user information is as expected - 3

  @updateBook
  #Update Book
  Scenario: Scenario-7
    Given Update Book
    Then Validate that the book is updated

  @deleteBook
  #Delete Book
  Scenario: Scenario-8
    Given Delete one of the book
    Then Validate that the book is deleted


