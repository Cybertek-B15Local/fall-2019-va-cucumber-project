package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.BooksPage;
import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.pojos.Book;
import com.cybertek.library.utilities.AuthenticationUtility;
import com.cybertek.library.utilities.DBUtils;
import com.cybertek.library.utilities.LibraryUserUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class APIStepDefs {
    Map<String, Object> student;
    @Given("new student is added using the add_user endpoint")
    public void new_student_is_added_using_the_add_user_endpoint() {
        // set base url --> let's in Hooks class
        // get a token
        String librarianToken = AuthenticationUtility.getLibrarianToken();
        System.out.println("librarianToken = " + librarianToken);
        // create new user information
        student = LibraryUserUtility.createUser(3);
        System.out.println("student = " + student);
        // create using using the add_user
        Response response = given().
                header("x-library-token", librarianToken).
                formParams(student).
                log().all().
        when().
                post("add_user").
                prettyPeek();
        response.then().statusCode(200);
    }

    @When("I login as the new user created using add_user endpoint")
    public void i_login_as_the_new_user_created_using_add_user_endpoint() {
        String email = student.get("email").toString();
        String password = student.get("password").toString();
        LoginPage loginPage = new LoginPage();
        loginPage.login(email, password);
    }

    @Then("book information must match the api for {}")
    public void book_information_must_match_the_api_for_The_kite_runner(String book) {
        // call the database to get the book id for
        String query = "SELECT id FROM books WHERE name = '"+book+"'";
        System.out.println("query = " + query);
        String id = DBUtils.getCellValue(query).toString();
        System.out.println("Book id = " + id);
        // get the token
        String token = AuthenticationUtility.getLibrarianToken();
        // use the id to make the call to api
        Response response = given().
                log().all().
                header("x-library-token", token).
                pathParam("id", id).
        when().
                get("/get_book_by_id/{id}").
                prettyPeek();
        // verify response vs ui
        response.then().statusCode(200).contentType(ContentType.JSON);
        Book bookPojo = response.as(Book.class);
        System.out.println("bookPojo = " + bookPojo);

        BooksPage booksPage = new BooksPage();

        assertThat(bookPojo.getName(), is(booksPage.bookName.getAttribute("value")));
        assertThat(bookPojo.getAuthor(), is(booksPage.author.getAttribute("value")));
        assertThat(bookPojo.getIsbn(), is(booksPage.isbn.getAttribute("value")));
        assertThat(bookPojo.getDescription(), is(booksPage.description.getAttribute("value")));


    }

}
