package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.UsersPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

import static org.junit.Assert.*;

public class AddUsersStepDefs {

    UsersPage usersPage = new UsersPage();

    @When("I click on Add Users")
    public void i_click_on_Add_Users() {
        usersPage.addUsers.click();
    }


    @Then("dialog fields must have matching placeholder")
    public void dialog_fields_must_have_matching_placeholder(Map<String, String> fields) {
        for (String key : fields.keySet()) {
            System.out.println("key = " + key);
            System.out.println("value = " + fields.get(key));
            System.out.println();
        }

        String expectedFullname = fields.get("fullname");
        String actualFullName = usersPage.fullName.getAttribute("placeholder");
        assertEquals("Full Name placeholder value did not match",
                expectedFullname, actualFullName);

        String expectedEmail = fields.get("email");
        String actualEmail = usersPage.email.getAttribute("placeholder");
        assertEquals("Email placeholder value did not match",
                expectedEmail, actualEmail);

        String expectedPassword = fields.get("password");
        String actualPassword = usersPage.password.getAttribute("placeholder");
        assertEquals("Password placeholder value did not match",
                expectedPassword, actualPassword);

        String actualAddress = usersPage.address.getAttribute("placeholder");
        assertEquals("Address placeholder must be empty",
                "", actualAddress);


        String myString;
        String yourString="";
    }

}





