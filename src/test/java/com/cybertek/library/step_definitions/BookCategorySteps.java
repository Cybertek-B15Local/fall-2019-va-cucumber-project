package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.BooksPage;
import com.cybertek.library.pojos.User;
import com.cybertek.library.utilities.AuthenticationUtility;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.DBUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BookCategorySteps {

    String token;
    List<User> userList = new ArrayList<>();
    List<User> groupIdList = new ArrayList<>();

    @Then("book categories must match api and db")
    public void book_categories_must_match_api_and_db() {
        // get category information from db
        String sqlQuery = "SELECT name FROM book_categories;";
        // this method returns all values from a single column
        List<Object> dbNamesObj = DBUtils.getColumnData(sqlQuery, "name");
        List<String> dbNames = new ArrayList<>();
        for (Object object : dbNamesObj) {
            dbNames.add(object.toString());
        }
        // the dorin way --> List<String> dbNames = new ArrayList(DBUtils.getColumnData(sqlQuery, "name"));

        // get category information from api
        String token = AuthenticationUtility.getLibrarianToken();
        Response response = given().
                header("x-library-token", token).
                log().all().
                when().
                get("/get_book_categories").prettyPeek();
        response.then().statusCode(200);
        List<String> apiNames = response.jsonPath().getList("name");
        // get category information from ui 
        BooksPage booksPage = new BooksPage();
        List<WebElement> namesEl = booksPage.mainCategoryList().getOptions();
        List<String> uiNames = BrowserUtils.getElementsText(namesEl);
        uiNames.remove(0);

        // compare the 3 lists
        assertThat(uiNames, allOf(equalTo(apiNames), equalTo(dbNames)));

    }// BREAK 8.43


    @Given("I get information for each user using get_user_by_id endpoint")
    public void i_get_information_for_each_user_using_get_user_by_id_endpoint() {
        // get ids of every one
        token = AuthenticationUtility.getLibrarianToken();
        List<String> idList = given().
                header("x-library-token", token).
                log().all().
            when().
                get("/get_all_users").prettyPeek().
                jsonPath().getList("id");

        // remove the admin user
        idList.remove(0);

        // for each id, call the get user by id endpoint
        // since it is taking too long to run for each user, i will just get info for 10 people. change to for each to get for every one
//        for (String id : idList) {
        for (int i = 0; i < 10; i++) {
            User userPojo = given().
                    header("x-library-token", token).
                    pathParam("id", idList.get(i)).
                    log().all().
                when().
                    get("/get_user_by_id/{id}").peek().as(User.class);
            userList.add(userPojo);
        }

    }

    @When("I get the available groups using the get_user_groups endpoint")
    public void i_get_the_available_groups_using_the_get_user_groups_endpoint() {
        groupIdList = given().
                header("x-library-token", token).
                log().all().
            when().
                get("/get_user_groups").peek().
                jsonPath().getList("id");
    }

    @Then("groups of non admin users should match the groups from get_user_groups")
    public void groups_of_non_admin_users_should_match_the_groups_from_get_user_groups() {

        // verify that each pojo object in the user list contains one of the ids from the groupList
        for (User user : userList) {
            assertThat(user.getUserGroupId(), in((List)groupIdList));
        }
    }


}
