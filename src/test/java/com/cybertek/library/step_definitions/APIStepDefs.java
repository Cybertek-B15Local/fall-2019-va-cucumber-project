package com.cybertek.library.step_definitions;

import com.cybertek.library.utilities.AuthenticationUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class APIStepDefs {

    @Given("new student is added using the add_user endpoint")
    public void new_student_is_added_using_the_add_user_endpoint() {
        // set base url --> let's in Hooks class
        // get a token
        String librarianToken = AuthenticationUtility.getLibrarianToken();
        System.out.println("librarianToken = " + librarianToken);
        // create new user information
        // create using using the add_user
    }

    @When("I login as the new user created using add_user endpoint")
    public void i_login_as_the_new_user_created_using_add_user_endpoint() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
